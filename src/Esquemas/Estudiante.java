package Esquemas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {
	@Id
	private int dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	@Column
	private String ciudad_residencia;
	@Column 
	private int numero_libreta;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	private List <Estudiante_Carrera> carreras;
	
	
	public Estudiante(){
		
	}
	
	public Estudiante(int dni,String nombre, String apellido, int edad, String genero,
			String ciudad_residencia, int numero_libreta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudad_residencia = ciudad_residencia;
		this.numero_libreta = numero_libreta;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero="
				+ genero + ", dni=" + dni + ", ciudad_residencia=" + ciudad_residencia + ", numero_libreta="
				+ numero_libreta + "]";
	}


	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public int getDni() {
		return dni;
	}

	public String getCiudad_residencia() {
		return ciudad_residencia;
	}

	public int getNumero_libreta() {
		return numero_libreta;
	}

	public List<Estudiante_Carrera> getCarreras() {
		return carreras;
	}
	
	
	
	
}
