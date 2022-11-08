package datatypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtProfesor extends DtUsuario{
	private String descripcion, biografia, sitioweb;
	protected String nickname, nombre, apellido, email;
	protected Date fechaNac;
	protected byte[] image;
	
	public DtProfesor(){}
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, byte[] image, String descripcion, String biografia, String sitioweb) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.image= image;
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNac() {
		return fechaNac;
	}
	
	public byte[] getImage() {
		return image;
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

}
