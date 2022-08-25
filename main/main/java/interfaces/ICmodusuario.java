package interfaces;

import java.util.Date;

import logica.InstitucionDep;
import logica.Usuario;

public interface ICmodusuario {
	public abstract void modProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion);
	public abstract void modSocio(String nickname, String nombre, String apellido, String email, Date fechaNac);
	public abstract String[] listarUsuarios();
	public abstract String[] listarInstituciones();
	public abstract Usuario obtenerInfo(String nombre);
}

