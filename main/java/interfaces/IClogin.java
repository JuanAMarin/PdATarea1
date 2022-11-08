package interfaces;

import datatypes.DtProfesor;
import datatypes.DtSocio;

public interface IClogin {
	public abstract DtProfesor existeP(String nickname, String pass);
	public abstract DtSocio existeS(String nickname, String pass);
	public abstract boolean existeSBoolean(String nickname, String pass);
	public abstract boolean existePBoolean(String nickname, String pass);
}