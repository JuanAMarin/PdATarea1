package logica;

import interfaces.IClogin;

public class Clogin implements IClogin{
	public Profesor existeP(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		return m.existePM(nickname, pass);
	}
	public Socio existeS(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		return m.existeSM(nickname, pass);
	}
}
