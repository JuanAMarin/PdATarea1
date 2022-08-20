package interfaces;

import java.util.Date;

import logica.InstitucionDep;

public interface ICaltausuario {
	
	public abstract void datosUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, boolean profe);
	public abstract void datosProfesor(String descripcion, String biografia, String sitioweb, InstitucionDep institucion, boolean profe);
	public abstract void altausuario();
	
}
