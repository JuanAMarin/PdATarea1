package logica;
import java.util.Date;

public class Registro {
	private Date fechaReg;
	Socio socio;
	Clase clase;
	
	public Registro(){}
	
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
	
}












