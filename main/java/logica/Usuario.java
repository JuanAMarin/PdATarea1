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
	
	protected Date fechaNac;
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
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

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public DtUsuario getDT() {
		return new DtUsuario(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac());
	}
	
}
