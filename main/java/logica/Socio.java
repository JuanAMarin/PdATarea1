package logica;

import java.util.Date;

public class Socio extends Usuario{
	private Registro registro;
	
	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac, Registro registro) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.registro=registro;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	
	
}
