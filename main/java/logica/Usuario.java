package logica;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import datatypes.DtUsuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	@Id
	protected String nickname;
	
	protected String nombre, apellido;
	
	@Column(unique=true)
	protected String email;
	protected String contraseña;
	protected Date fechaNac;
	protected byte[] image;
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String contraseña, byte[] image) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contraseña = contraseña;
		this.fechaNac = fechaNac;
		this.image = image;
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
	
	public String getContraseña() {
		return contraseña;
	}

	public Date getFechaNac() {
		return fechaNac;
	}
	public byte[] getImage() {
		return image;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public DtUsuario getDT() {
		return new DtUsuario(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac(),this.getImage());
	}
	
}
