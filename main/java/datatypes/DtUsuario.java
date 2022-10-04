package datatypes;

import java.util.Date;

public class DtUsuario {
	protected String nickname, nombre, apellido, email;
	protected Date fechaNac;
	protected byte[] image;
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, byte[] image) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.image= image;
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
}
