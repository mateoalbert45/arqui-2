package Esquemas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Estudiante_Carrera {

    	@EmbeddedId
    	private Estudiante_CarreraPK id;

    	
	    @ManyToOne
	    @MapsId("dni") 
	    @JoinColumn(name = "ID_Estudiante")
	    private Estudiante estudiante;

	    @ManyToOne
	    @MapsId("id")
	    @JoinColumn(name = "ID_Carrera")
	    private Carrera carrera;
		
	    @Column
	    (nullable = true)
	    private Date fechaEgreso;
	    
	    
	    
		public Estudiante_Carrera(){
			
		}
	    
	    
	    
		public Estudiante_Carrera(Estudiante_CarreraPK id, Estudiante estudiante, Carrera carrera) {
			super();
			this.id = id;
			this.estudiante = estudiante;
			this.carrera = carrera;
			this.fechaEgreso = null;
		}



		@Override
		public String toString() {
			return "Estudiante_Carrera [estudiante=" + estudiante + ", carrera=" + carrera + "]";
		}    
	
		public String infoCarrera() {
			return "Estudiante_Carrera [ carrera_id=" + carrera.getId() + ", carrera_]";
		}



		public Estudiante getEstudiante() {
			return estudiante;
		}



		public Carrera getCarrera() {
			return carrera;
		}



		public Date getFechaEgreso() {
			return fechaEgreso;
		}    
	    
		
		
		
}
