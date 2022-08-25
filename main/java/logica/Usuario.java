package logica;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;

import persistencia.UsuarioID;

@MappedSuperclass
@IdClass(UsuarioID.class)
public class Usuario {
	
	@Id
	protected String nickname;
	
	@Id
	protected String email;
	
	protected String nombre, apellido;
	protected Date fechaNac;
	
	public Usuario(){
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
	
//-----------------------------------------------------------------------------------
// Funciones ...
	
	
	
	
}
