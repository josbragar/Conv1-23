/**
 * 
 */
package org.example;

/**
 * @author Isabel Román
 *
 */
import java.util.Comparator;
import org.example.Alumno;
import org.example.Asignatura;

public class ComparadorNotasAsignatura implements Comparator<Alumno> {
	private Asignatura asignatura;

	public ComparadorNotasAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int compare(Alumno alumno1, Alumno alumno2) {

		double nota1 = alumno1.getNotaAsignatura(asignatura);
		double nota2 = alumno2.getNotaAsignatura(asignatura);
		return Double.compare(nota1, nota2);
	}
}
