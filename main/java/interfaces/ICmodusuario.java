package interfaces;

import java.util.Date;

import logica.Profesor;
import logica.Socio;

public interface ICmodusuario {
	public abstract void modProfesor(String nickname, String nombre, String apellido, Date fechaNac, String descripcion, String biografia, String sitioweb);
	public abstract void modSocio(String nickname, String nombre, String apellido, Date fechaNac);
	public abstract String[] listarUsuarios();
	public abstract Profesor obtenerProfesor(String nickname);
	public abstract Socio obtenerSocio(String nickname);
}
