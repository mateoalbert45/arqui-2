package Requests;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="estudiante_carrera") 
public class Estudiante_Carrera {

    	@EmbeddedId
    	private Estudiante_CarreraPK id;

	    @ManyToOne
	    @MapsId("id") //This is the name of attr in EmployerDeliveryAgentPK class
	    @JoinColumn(name = "ID_Estudiante")
	    private Estudiante estudiante;

	    @ManyToOne
	    @MapsId("id")
	    @JoinColumn(name = "ID_Carrera")
	    private Carrera carrera;

		public Estudiante_Carrera(Estudiante_CarreraPK id, Estudiante estudiante, Carrera carrera) {
			super();
			this.id = id;
			this.estudiante = estudiante;
			this.carrera = carrera;
		}    
	
	    
	    
}
