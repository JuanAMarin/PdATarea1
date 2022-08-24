package logica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Profesor extends Usuario{
	private String descripcion, biografia, sitioweb;
	private String insti;

	public Profesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, String institucion) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.insti=institucion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getSitioweb() {
		return sitioweb;
	}
	
	public String getInstitucion() {
		return insti;
	}

	public void setInstitucion(String institucion) {
		this.insti = institucion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void setSitioweb(String sitioweb) {
		this.sitioweb = sitioweb;
	}
	
	
	
}
