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
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String hola = "-173479.9999";
//		System.out.println(String.format("%.4f",Double.parseDouble(hola)).toString());
//		hola = String.format("%.4f",Double.parseDouble(hola)).toString();
//		System.out.println( hola.substring(0,hola.indexOf(",") + 3));
//		
//		System.out.println(String.format("%.2f",Double.parseDouble("-173479.9990")).toString());
//		System.out.println(Double.parseDouble("-173479.656"));
//		System.out.println( hola.substring(hola.indexOf(".") + 1).length());
//		System.out.println(hola.substring(hola.indexOf(".")+ 1));
//		int cantidad = hola.substring(hola.indexOf(".")).length();
//		if(cantidad>2) {
//			hola = hola.substring(hola.indexOf("."));
//		}
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
//		@SuppressWarnings("unchecked")
//		List <Persona> personas = em.createQuery("SELECT p FROM Persona p").getResultList();
//		for(int i = 0; i<personas.size(); i++) {
//			System.out.println(personas.get(i).toString());
//		}
//		
		
		Estudiante e1 = new Estudiante(1,"mateo","albert",20,"hombre",1234567,"tandil",12345);
		Carrera c1 = new Carrera(1,"tudai");
		Estudiante_CarreraPK ec1pk = new Estudiante_CarreraPK(1,1);
		Estudiante_Carrera ec1 = new Estudiante_Carrera(ec1pk,e1,c1);
		
			
//		Persona p1 = new Persona(1,"mateo","albert");
//		Persona p2 = new Persona(2,"mateo2","albert2");
		em.persist(e1);
		em.persist(c1);
		em.persist(ec1);
		em.getTransaction().commit();
		em.close();
		emf.close();

		
//			try {
//				Class.forName(driver).getDeclaredConstructor().newInstance();
//			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
//					| InvocationTargetException | NoSuchMethodException | SecurityException
//					| ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("pedimo");
//			}
			
//		String uri= "jdbc:mysql://localhost/Arqui?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
		
//		
//		try {
//			Connection conn = DriverManager.getConnection(uri, "root", "");
//			String sql =" CREATE TABLE  factura(" + "id_factura INT," + " id_cliente INT NOT NULL," +" PRIMARY KEY(id_factura), "+ " FOREIGN KEY (`id_cliente`) REFERENCES `cliente`(`id_cliente`))";
//			PreparedStatement select = conn.prepareStatement(sql);
//			conn.prepareStatement(sql).execute();
//			//ResultSet resultSet = select.executeQuery();
//			//while (resultSet.next()) {
//             //   System.out.println("Nombre: " + resultSet.getString(1) + " Apellido: " + resultSet.getString(2) );
//            //}
//			
//			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
//
//					FileReader("productos.csv"));
//					for(CSVRecord row: parser) {
//					System.out.println(row.get("idProducto"));
//					System.out.println(row.get("nombre"));
//					System.out.println(row.get("valor"));
//					}
//			
//			conn.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("perdimo");
//
//		}
		


//

	}
	

	}


