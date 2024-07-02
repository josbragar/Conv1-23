/**
 * 
 */
package us.dit.fs.clase.control;

/**
 * @author  Isabel Román
 *
 */
import java.util.Collections;
import java.util.List;
import java.util.Map;
import us.dit.fs.clase.model.AlumnoDAO;
import us.dit.fs.clase.model.Alumno;
import us.dit.fs.clase.model.Asignatura;

public class EstadisticasAlumno {
	private AlumnoDAO alumnoDAO;

	public EstadisticasAlumno(AlumnoDAO alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
	}

	public double obtenerMediaNotas(String uvus) {
		Alumno alumno = alumnoDAO.getAlumnoByUvus(uvus);
		if (alumno != null) {
			Map<Asignatura, Double> notasAsignaturas = alumno.getNotasAsignaturas();
			int cantidadAsignaturas = notasAsignaturas.size();
			if (cantidadAsignaturas > 0) {
				double sumaNotas = 0;
				for (double nota : notasAsignaturas.values()) {
					sumaNotas += nota;
				}
				return sumaNotas / cantidadAsignaturas;
			}
		}
		return 0;
	}

	/**
	 * Obtiene todos los alumnos de la clase del alumno que se pasa como parámetro
	 * 
	 * @param uvus
	 * @return
	 */
	public List<Alumno> obtenerClase(String uvus) {
		Alumno alumno = alumnoDAO.getAlumnoByUvus(uvus);
		return alumnoDAO.getAlumnosByClase(alumno.getClase());
	}

	/**
	 * 
	 * @param uvus
	 * @param asignatura
	 * @return cuartil en el que se encuentra la nota del alumno en esa asignatura
	 */
	public int obtenerCuartilPorAsignatura(String uvus, Asignatura asignatura) {
		List<Alumno> alumnos = alumnoDAO.getAlumnosByAsignatura(asignatura);
		Collections.sort(alumnos, new ComparadorNotasAsignatura(asignatura));

		int cuartil = 4;
		int posicionAlumno = -1;
		int totalAlumnos = alumnos.size();
		for (int i = 0; i < totalAlumnos; i++) {

			if (alumnos.get(i).getUvus().equals(uvus)) {

				posicionAlumno = i + 1;
				break;
			}
		}

		if (posicionAlumno != -1) {
			int Q1 = (int) Math.ceil(0.25 * totalAlumnos);

			int Q2 = (int) Math.ceil(0.50 * totalAlumnos);

			int Q3 = (int) Math.ceil(0.75 * totalAlumnos);

			if (posicionAlumno <= Q1)
				cuartil = 1;
			else if (posicionAlumno <= Q2)
				cuartil = 2;
			else if (posicionAlumno <= Q3)
				cuartil = 3;
		}

		return cuartil;
	}

	/**
	 * Devuelve la diferencia entre la nota del alumno en una asignatura y la media
	 * en dicha asignatura
	 * 
	 * @param uvus
	 * @param asignatura
	 * @return nota del alumno - nota media, un número positivo indica por encima de
	 *         la media
	 */
	public double obtenerDiferenciaMediaAsignatura(String uvus, Asignatura asignatura) {

		double notaAlumno = alumnoDAO.getAlumnoByUvus(uvus).getNotaAsignatura(asignatura);
		List<Alumno> alumnos = alumnoDAO.getAlumnosByAsignatura(asignatura);
		double totalNotas = 0;
		double media = 0;
		for (Alumno alumno : alumnos)
			totalNotas += alumno.getNotaAsignatura(asignatura);
		media = totalNotas / alumnos.size();

		return notaAlumno - media;
	}

	/**
	 * 
	 * @param uvus
	 * @return Nota media del alumno - nota media de la clase, un número positivo
	 *         indica por encima de la media
	 */
	public double obtenerDiferenciaMediaClase(String uvus) {
		Alumno alumno = alumnoDAO.getAlumnoByUvus(uvus);
		List<Alumno> alumnos = alumnoDAO.getAlumnosByClase(alumno.getClase());
		double media = 0;
		double totalNotas = 0;
		for (Alumno alum : alumnos)
			totalNotas += this.obtenerMediaNotas(alum.getUvus());
		media = totalNotas / alumnos.size();
		return this.obtenerMediaNotas(uvus) - media;
	}

	public int obtenerCuartilPorClase(String uvus) {
		Alumno alumno = alumnoDAO.getAlumnoByUvus(uvus);
		List<Alumno> alumnos = alumnoDAO.getAlumnosByClase(alumno.getClase());
		Collections.sort(alumnos, new ComparadorNotasMedias());

		int cuartil = 4;
		int posicionAlumno = -1;
		int totalAlumnos = alumnos.size();
		for (int i = 0; i < totalAlumnos; i++) {

			if (alumnos.get(i).getUvus().equals(uvus)) {

				posicionAlumno = i + 1;
				break;
			}
		}

		if (posicionAlumno != -1) {
			int Q1 = (int) Math.ceil(0.25 * totalAlumnos);

			int Q2 = (int) Math.ceil(0.50 * totalAlumnos);

			int Q3 = (int) Math.ceil(0.75 * totalAlumnos);

			if (posicionAlumno <= Q1)
				cuartil = 1;
			else if (posicionAlumno <= Q2)
				cuartil = 2;
			else if (posicionAlumno <= Q3)
				cuartil = 3;
		}

		return cuartil;
	}

}
