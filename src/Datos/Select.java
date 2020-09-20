package Datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.Estudiante_Carrera;

public class Select {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		imprimirEstudiantes(recuperarEstudiantes(em));
//		imprimirEstudiante(estudianteSegunLibreUniversitaria(321,em));
//		imprimirEstudiante(estudianteSegunGenero("hombre",em));
//		imprimirCarreras(carrerasSegunInscriptos(em));
//		imprimirEstudiantes(estudianteSegunCarreraCiudad(1, "tandil",em));
//		imprimirReporteCarreras(reporteCarreras(em));
		em.close();

	}
	
	
		//c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
		public static List<Estudiante> recuperarEstudiantes(EntityManager em){
			@SuppressWarnings("unchecked")
			List <Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e order by edad DESC").getResultList();
			return estudiantes;
			
		}
		
		
		//d) recuperar un estudiante, en base a su número de libreta universitaria
		public static Estudiante estudianteSegunLibreUniversitaria(int numLibreta,EntityManager em){
			@SuppressWarnings("unchecked")
			Query query = em.createQuery("SELECT e from Estudiante e where numero_libreta = :numero_libreta");
			Estudiante estudiante = (Estudiante) query.setParameter("numero_libreta", numLibreta).getSingleResult();
			return estudiante;
		}
		
		//e) recuperar todos los estudiantes, en base a su género
		public static Estudiante estudianteSegunGenero(String genero,EntityManager em){
			@SuppressWarnings("unchecked")
			Query query = em.createQuery("SELECT e from Estudiante e where genero = :genero");
			Estudiante estudiante = (Estudiante) query.setParameter("genero", genero).getSingleResult();
			return estudiante;
		}
		
		//f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos
		public static List<Carrera> carrerasSegunInscriptos(EntityManager em){
			@SuppressWarnings("unchecked")
			List <Carrera> carreras = em.createQuery("Select ec.carrera from Estudiante_Carrera ec group by ID_Carrera having count(ID_Carrera) > 0 order by count(ID_Estudiante) DESC").getResultList();
			return carreras;
		}
		
		//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
		public static List<Estudiante> estudianteSegunCarreraCiudad(int idCarrera, String ciudad,EntityManager em){
			Query query =  em.createQuery("SELECT ec.estudiante from Estudiante_Carrera ec join ec.estudiante e  join ec.carrera c where e.ciudad_residencia = :ciudad_residencia and c.id = :id ");
			query.setParameter("ciudad_residencia", ciudad);
			query.setParameter("id", idCarrera);
			@SuppressWarnings("unchecked")
			List <Estudiante> carreras = (List<Estudiante>) query.getResultList();
			return carreras;
			
		}
		
		/*Generar un reporte de las carreras, que para cada carrera incluya información de los
		inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
		los años de manera cronológica.*/
		public static List<Estudiante_Carrera> reporteCarreras(EntityManager em){
			@SuppressWarnings("unchecked")
			List <Estudiante_Carrera> reporte = em.createQuery("Select ec from Estudiante_Carrera ec  join ec.carrera c  where ec.fechaEgreso is not null order by c.nombre,ec.fechaEgreso").getResultList();
			return reporte;	
		}
		
		
		
		public static void imprimirEstudiantes(List<Estudiante> estudiantes) {
			for(int i = 0; i<estudiantes.size(); i++) {
				System.out.println(estudiantes.get(i).toString());
				}
			}
			
		
		public static void imprimirEstudiante(Estudiante estudiante) {
				System.out.println(estudiante.toString());
				
			}
		
		
		public static void imprimirCarreras(List<Carrera>  carreras) {
			for(int i = 0; i<carreras.size(); i++) {
				System.out.println(carreras.get(i).toString());
				}
		}
		
		public static void imprimirReporteCarreras(List<Estudiante_Carrera>  reporte) {
			for(int i = 0; i<reporte.size(); i++) {
				//perdon
				if(i>0) {
					if(!reporte.get(i-1).getCarrera().getNombre().equalsIgnoreCase(reporte.get(i).getCarrera().getNombre())) {
						System.out.println(reporte.get(i).getCarrera().toString());
					}
				}
				else {
					System.out.println(reporte.get(i).getCarrera().toString());
				}
				
				System.out.println(reporte.get(i).getEstudiante().toString() + " FechaEgreso" + reporte.get(i).getFechaEgreso());

				}

				
		}
		
		
}
