package interfaces;

import logica.Profesor;
import logica.Socio;

public interface IClogin {
	public abstract Profesor existeP(String nickname, String pass);
	public abstract Socio existeS(String nickname, String pass);
}