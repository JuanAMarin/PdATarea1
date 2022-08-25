package interfaces;

import java.util.ArrayList;
import java.util.Date;

import logica.InstitucionDep;
import logica.ManejadorUsuarios;
import logica.Profesor;
import logica.Socio;
import persistencia.UsuarioID;

public interface ICmodusuario {
	public abstract void modProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion);
	public abstract void modSocio(String nickname, String nombre, String apellido, String email, Date fechaNac);
	public ArrayList<String> listarSociosN();
	public ArrayList<String> listarProfesoresN();
	public String[] listarUsuariosN();
	public ArrayList<String> listarSociosE();
	public ArrayList<String> listarProfesoresE();
	public String[] listarUsuariosE();
	public abstract String[] listarInstituciones();
	public abstract Profesor obtenerProfesor(UsuarioID key);
	public abstract Socio obtenerSocio(UsuarioID key);
}

