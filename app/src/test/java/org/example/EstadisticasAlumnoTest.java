/**
 * 
 */
package us.dit.fs.clase.control;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import us.dit.fs.clase.model.AlumnoDAO;
import us.dit.fs.clase.model.Asignatura;
import us.dit.fs.clase.model.Alumno;

/**
 * @author Isabel Román
 *
 */
@ExtendWith(MockitoExtension.class)
class EstadisticasAlumnoTest {

	@Mock(serializable = true)
	private static AlumnoDAO alumnoDAO;

	@Captor
	private ArgumentCaptor<String> uvusCaptor;
	@Captor
	private ArgumentCaptor<Asignatura> asignaturaCaptor;
	@Captor
	private ArgumentCaptor<String> claseCaptor;

	// Lista de alumnos para las pruebas
	private static List<Alumno> alumnos = new ArrayList<Alumno>();

	private static Alumno alumno1 = new Alumno("uvus01", "clase");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		// Configuración de la lista de alumnos utilizada como ejemplo

		Alumno alumno2 = new Alumno("uvus02", "clase");
		Alumno alumno3 = new Alumno("uvus03", "clase");
		Alumno alumno4 = new Alumno("uvus04", "clase");

	        // Notas de ejemplo para el alumno y sus compañeros
		// La media de la nota de matemáticas es 7,125, por tanto el alumno uvus01 tiene
		// de diferencia -1,625 (por debajo de la media)
		// La media de la nota de lengua es 7,25, por tanto el alumno uvus01 tiene 1,75
		// de diferencia (por encima de la media)
		// En matemáticas el alumno uvus01 es el peor de clase, cuartil 1
		// En lengua el alumno uvus01 es el mejor de clase, cuartil 4
		
		// La media de notas del alumno es 7,25
		// La media de notas de la clase es 7,19
		// En el conjunto de las asignaturas, cuartil por clase, uvus01 está en el cuartil 3

		alumno1.setNotaAsignatura(Asignatura.MATEMATICAS, 5.5);
		alumno2.setNotaAsignatura(Asignatura.MATEMATICAS, 6);
		alumno3.setNotaAsignatura(Asignatura.MATEMATICAS, 10);
		alumno4.setNotaAsignatura(Asignatura.MATEMATICAS, 7);

		alumno1.setNotaAsignatura(Asignatura.LENGUA, 9);
		alumno2.setNotaAsignatura(Asignatura.LENGUA, 8);
		alumno3.setNotaAsignatura(Asignatura.LENGUA, 5);
		alumno4.setNotaAsignatura(Asignatura.LENGUA, 7);

		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		alumnos.add(alumno4);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#EstadisticasAlumno(us.dit.fs.clase.model.AlumnoDAO)}.
	 */
	@Test
	void testEstadisticasAlumno() {
		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones
	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerMediaNotas(java.lang.String)}.
	 */
	@Test
	void testObtenerMediaNotas() {
		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones
	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerClase(java.lang.String)}.
	 */
	@Test
	void testObtenerClase() {
		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones
		        
	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerCuartilPorAsignatura(java.lang.String, us.dit.fs.clase.model.Asignatura)}.
	 */
	@Test
	void testObtenerCuartilPorAsignatura() {
		
		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones
	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerDiferenciaMediaAsignatura(java.lang.String, us.dit.fs.clase.model.Asignatura)}.
	 */
	@Test
	void testObtenerDiferenciaMediaAsignaturaPositiva() {

		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones

	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerDiferenciaMediaAsignatura(java.lang.String, us.dit.fs.clase.model.Asignatura)}.
	 */
	@Test
	void testObtenerDiferenciaMediaAsignaturaNegativa() {

	//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones

	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerDiferenciaMediaClase(java.lang.String)}.
	 */
	@Test
	void testObtenerDiferenciaMediaClase() {
		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones
	}

	/**
	 * Test method for
	 * {@link us.dit.fs.clase.control.EstadisticasAlumno#obtenerCuartilPorClase(java.lang.String)}.
	 */
	@Test
	void testObtenerCuartilPorClase() {
		//Configurar comportamiento del MOCK
		
	
		// Crear instancia de EstadisticasAlumno con el mock de AlumnoDAO
		
		//Invocar métdo a probar
		

		//Escribir verificaciones
		
	}

}
