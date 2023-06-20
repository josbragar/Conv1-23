/**
 * 
 */
package us.dit.fs.clase.control;

import java.util.ArrayList;
/**
 * @author  Isabel Román
 *
 */
import java.util.Comparator;
import java.util.List;

import us.dit.fs.clase.model.Alumno;
import us.dit.fs.clase.model.Asignatura;

public class ComparadorNotasMedias implements Comparator<Alumno> {

	@Override
	public int compare(Alumno alumno1, Alumno alumno2) {
		List<Double> notas = new ArrayList<Double>(alumno1.getNotasAsignaturas().values());

		double media1 = 0;
		for (Double nota : notas) {
			media1 += nota.doubleValue();
		}
		media1 = media1 / notas.size();
		notas = new ArrayList<Double>(alumno2.getNotasAsignaturas().values());
		double media2 = 0;
		for (Double nota : notas) {
			media2 += nota.doubleValue();
		}
		media2 = media2 / notas.size();

		return Double.compare(media1, media2);
	}
}
