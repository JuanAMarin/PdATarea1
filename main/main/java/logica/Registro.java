package logica;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistencia.RegistroID;

@Entity
@IdClass(RegistroID.class)
public class Registro {
	
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	
	@Id 
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	String socio;
	
	@Id 
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	String clase;
	
	public Registro(Date fechaReg, String socio, String clase) {
		super();
		this.fechaReg = fechaReg;
		this.socio = socio;
		this.clase = clase;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public String getSocio() {
		return socio;
	}

	public String getClase() {
		return clase;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
}












