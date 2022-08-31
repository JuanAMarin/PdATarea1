package datatypes;

import java.util.Date;
import logica.InstitucionDep;

public class DtProfesor extends DtUsuario{
	private String descripcion, biografia, sitioweb;
	private InstitucionDep institucion;
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucion = institucion;
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

}
