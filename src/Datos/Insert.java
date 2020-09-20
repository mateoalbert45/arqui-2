package Datos;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.Estudiante_Carrera;
import Esquemas.Estudiante_CarreraPK;
public class Insert {

	public static void main(String[] args) throws FileNotFoundException, IOException {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		Estudiante e1 = new Estudiante(2,"asd","asd",20,"hombre",23412,"tandil",321);
		Carrera c1 = new Carrera(1,"tudai");
		em.getTransaction().begin();
		insertEstudiante(e1, em);
		//matricularEstudiante(e1,c1,em);
		emf.close();

	}
	
	//a) dar de alta un estudiante
	public static void insertEstudiante(Estudiante estu, EntityManager em) {
	//	Estudiante e1 = new Estudiante(estu.getId(),estu.getNombre(),estu.getApellido(),estu.getEdad(),estu.getGenero(),estu.getDni(),estu.getCiudad_residencia(),estu.getNumero_libreta());
		em.persist(estu);
		em.getTransaction().commit();
	}
	
	//b) matricular un estudiante en una carrera
	public static void matricularEstudiante(Estudiante estu, Carrera carr, EntityManager em) {
		Estudiante_CarreraPK ecpk = new Estudiante_CarreraPK(estu.getId(),carr.getId());
		Estudiante_Carrera ec = new Estudiante_Carrera(ecpk,estu,carr);		
		em.persist(ec);
		em.getTransaction().commit();
	}
	
}