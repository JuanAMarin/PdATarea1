package interfaces;

import java.util.Date;

import datatypes.DtProfesor;
import datatypes.DtSocio;

public interface ICmodusuario {
	public abstract void modProfesor(String nickname, String nombre, String apellido, Date fechaNac, String descripcion, String biografia, String sitioweb, byte[] personImage);
	public abstract void modSocio(String nickname, String nombre, String apellido, Date fechaNac, byte[] personImage);
	public abstract String[] listarUsuarios();
	public abstract DtProfesor obtenerProfesor(String nickname);
	public abstract DtSocio obtenerSocio(String nickname);
}
