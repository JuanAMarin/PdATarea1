package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtProfesor;

@Entity
public class Profesor extends Usuario{
	private String descripcion, biografia, sitioweb;
	
	@ManyToOne
	@JoinColumn(name = "insti")
	private InstitucionDep institucion;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Clase> clases;

	public Profesor() {
		super();
	}

	public Profesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion, String contra, byte[] image) {
		super(nickname, nombre, apellido, email, fechaNac, contra, image);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucion = institucion;
		this.clases = new ArrayList<>();
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
	
	public List<Clase> getClases() {
		return clases;
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

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public DtProfesor getDT() {
		return new DtProfesor(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac(),this.getDescripcion(),this.getBiografia(),this.getSitioweb(),this.getInstitucion(), this.image);
	}
	
}
