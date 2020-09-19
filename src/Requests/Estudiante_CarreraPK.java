package Requests;

import java.io.Serializable;

import javax.persistence.Column;

public class Estudiante_CarreraPK implements Serializable {

    @Column(name = "ID_Estudiante")
    private int id_Estudiante;

    @Column(name = "ID_Carrera")
    private int id_Carrera;

	public Estudiante_CarreraPK(){
		
	}
    
    
    
	public Estudiante_CarreraPK(int id_Estudiante, int id_Carrera) {
		super();
		this.id_Estudiante = id_Estudiante;
		this.id_Carrera = id_Carrera;
	}
    
    
}
