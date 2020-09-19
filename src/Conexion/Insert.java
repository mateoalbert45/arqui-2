package Conexion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Requests.Carrera;
import Requests.Estudiante;
import Requests.Estudiante_Carrera;
import Requests.Estudiante_CarreraPK;
public class Insert {

	public static void main(String[] args) throws FileNotFoundException, IOException {		
//		Persona p1 = new Persona(1,"mateo","albert");
//		Persona p2 = new Persona(2,"mateo2","albert2");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
//		@SuppressWarnings("unchecked")
//		List <Persona> personas = em.createQuery("SELECT p FROM Persona p").getResultList();
//		for(int i = 0; i<personas.size(); i++) {
//			System.out.println(personas.get(i).toString());
//		}
//		
		
//		Estudiante e1 = new Estudiante(1,"mateo","albert",20,"hombre",1234567,"tandil",12345);
//		Carrera c1 = new Carrera(1,"tudai");
//		Estudiante_CarreraPK ec1pk = new Estudiante_CarreraPK(1,1);
//		Estudiante_Carrera ec1 = new Estudiante_Carrera(ec1pk,e1,c1);
		
		recuperarEstudiantes(em);

//		em.persist(e1);
//		em.persist(c1);
//		em.persist(ec1);
//		em.getTransaction().commit();
//		em.close();
		emf.close();

	}
	
	public void insert(Estudiante estu, EntityManager em) {
	//	Estudiante e1 = new Estudiante(estu.getId(),estu.getNombre(),estu.getApellido(),estu.getEdad(),estu.getGenero(),estu.getDni(),estu.getCiudad_residencia(),estu.getNumero_libreta());
		em.getTransaction().begin();
		em.persist(estu);
		em.getTransaction().commit();
		em.close();
	}
	
	public void matricularEstudiante(Estudiante estu, Carrera carr, EntityManager em) {
		em.getTransaction().begin();
		Estudiante_CarreraPK ecpk = new Estudiante_CarreraPK(estu.getId(),carr.getId());
		Estudiante_Carrera ec = new Estudiante_Carrera(ecpk,estu,carr);		
		em.persist(ec);
		em.getTransaction().commit();
		em.close();
	}
	
	
	//LOS SELECTTTTT
	//c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
	
	public static List<Estudiante> recuperarEstudiantes(EntityManager em){
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List <Estudiante> estudiantes = em.createQuery("SELECT * from estudiante order by edad DESC").getResultList();
		for(int i = 0; i<estudiantes.size(); i++) {
			System.out.println(estudiantes.get(i).toString());
		}
		em.close();
		return estudiantes;
		
	}
	}


