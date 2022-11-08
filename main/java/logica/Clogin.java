package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.IClogin;

public class Clogin implements IClogin{
	public DtProfesor existeP(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		if(m.existePM(nickname, pass)!=null)
			return m.existePM(nickname, pass).getDT();
		return null;
	}
	public DtSocio existeS(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		if(m.existeSM(nickname, pass)!=null)
			return m.existeSM(nickname, pass).getDT();
		return null;
	}
	public boolean existeSBoolean(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		if(m.existeSM(nickname, pass)!=null)
			return true;
		return false;
	}
	public boolean existePBoolean(String nickname, String pass) {
		Manejador m = Manejador.getInstancia();
		if(m.existePM(nickname, pass)!=null)
			return true;
		return false;
	}
}
