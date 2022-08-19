package logica;

import java.util.Date;

public class Profesor extends Usuario{
	private String descripcion, biografia, sitioweb;
	private InstitucionDep institucion;

	public Profesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucion=institucion;
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
	
	public InstitucionDep getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDep institucion) {
		this.institucion = institucion;
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
