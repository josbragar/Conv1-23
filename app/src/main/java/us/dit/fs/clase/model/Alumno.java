/**
 * 
 */
package us.dit.fs.clase.model;

/**
 * @author Isabel Román
 *
 */
import java.util.EnumMap;
import java.util.Map;

public class Alumno {
	private String nombre;
	private String uvus;
	private String clase;
	private Map<Asignatura, Double> notasAsignaturas;

	public Alumno(String nombre, String uvus, String clase) {
		this.nombre = nombre;
		this.uvus = uvus;
		this.clase = clase;
		this.notasAsignaturas = new EnumMap<>(Asignatura.class);
	}

	public Alumno(String uvus, String clase) {
		this.uvus = uvus;
		this.clase = clase;
		this.notasAsignaturas = new EnumMap<>(Asignatura.class);
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUvus() {
		return uvus;
	}

	public void setUvus(String uvus) {
		this.uvus = uvus;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Map<Asignatura, Double> getNotasAsignaturas() {
		return notasAsignaturas;
	}

	public void setNotaAsignatura(Asignatura asignatura, double nota) {
		notasAsignaturas.put(asignatura, nota);
	}

	public Double getNotaAsignatura(Asignatura asignatura) {
		return notasAsignaturas.get(asignatura);
	}

	public String toString() {
		return "uvus: " + this.uvus + " Notas " + this.notasAsignaturas;

	}
}
