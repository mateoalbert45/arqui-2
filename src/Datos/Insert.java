package Datos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.Estudiante_Carrera;
import Esquemas.Estudiante_CarreraPK;
public class Insert {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Estudiante e1 = new Estudiante(1,"Agustin","Miguel",25,"m","Tandil",321);
        Carrera c1 = new Carrera(1,"tudai");
        Estudiante e2 = new Estudiante(2,"Mateo","Albert",25,"m","Tandil",322);
        Carrera c2 = new Carrera(2,"tupar");
        Estudiante e3 = new Estudiante(3,"Ezequiel","Balcaldi",25,"m","Tandil",321);
        Carrera c3 = new Carrera(3,"ing. en Sist.");
        Estudiante e4 = new Estudiante(4,"Pablo","Calandria",25,"m","Tandil",321);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		insertEstudiante(e1, em);
		insertEstudiante(e2, em);
		insertEstudiante(e3, em);
		insertEstudiante(e4, em);
		
		insertCarrera(c1,em);
		insertCarrera(c2,em);
		insertCarrera(c3,em);
		
		matricularEstudiante(e1,c1,em);
		matricularEstudiante(e2,c2,em);
		matricularEstudiante(e3,c3,em);
		matricularEstudiante(e4,c3,em);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
	
	//a) dar de alta un estudiante
	public static void insertEstudiante(Estudiante estu, EntityManager em) {
		em.persist(estu);
	}
	
	public static void insertCarrera(Carrera carr, EntityManager em) {
		em.persist(carr);
	}
	
	
	//b) matricular un estudiante en una carrera
	public static void matricularEstudiante(Estudiante estu, Carrera carr, EntityManager em) {
		Estudiante_CarreraPK ecpk = new Estudiante_CarreraPK(estu.getDni(),carr.getId());
		//Generamos fechas aleatoreas
		Estudiante_Carrera ec = new Estudiante_Carrera(ecpk,estu,carr, new Date((long) (System.currentTimeMillis() - Math.random() * 1000000000)));
		em.persist(ec);

	}
	
}