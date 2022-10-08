package logica;

import interfaces.IClogin;

public class Clogin implements IClogin{
	
	String nickname, pass;
	
	public boolean existeUser(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		return m.existeUser(nickname, pass);
	}
	
}
