package Requests;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
public class Carrera {
	@Id
	private int id;
	@Column
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
	private List <Estudiante_Carrera> estudiantes;
	
	public Carrera(){
		
	}
	public Carrera(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	public void addEstudiante(Estudiante_Carrera estudiante) {
		estudiantes.add(estudiante);
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public List<Estudiante_Carrera> getEstudiantes() {
		return estudiantes;
	}
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
