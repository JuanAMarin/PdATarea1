package logica;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import datatypes.DtRegistro;
import datatypes.DtSocio;
import persistencia.RegistroID;

@Entity
@IdClass(RegistroID.class)
public class Registro {
	@Id 
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Socio socio;
	
	@Id 
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Clase clase;
	
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	
	public Registro() {
		super();
	}

	public Registro(Date fechaReg, Socio socio, Clase clase) {
		super();
		this.fechaReg = fechaReg;
		this.socio = socio;
		this.clase = clase;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public Socio getSocio() {
		return socio;
	}

	public Clase getClase() {
		return clase;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
	public DtRegistro getDT() {
		return new DtRegistro(this.getSocio().getNickname(),this.getFechaReg());
	}
	
}











