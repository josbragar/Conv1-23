/**
 *
 */
package us.dit.fs.clase.model;

/**
 * @author  Isabel Román
 *
 */
import java.util.List;

public interface AlumnoDAO {
	/**
	 * @param uvus
	 * @return
	 */
	Alumno getAlumnoByUvus(String uvus);

	/**
	 * 
	 * @param clase
	 * @return
	 */
	List<Alumno> getAlumnosByClase(String clase);

	/**
	 * 
	 * @param asignatura
	 * @return
	 */
	List<Alumno> getAlumnosByAsignatura(Asignatura asignatura);
}
