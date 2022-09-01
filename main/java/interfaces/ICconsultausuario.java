package interfaces;

import java.util.Date;

import logica.Profesor;
import logica.Socio;

public interface ICconsultausuario {
	public abstract String[] listarUsuarios();
	public abstract String getNickname(); 
	public abstract String getEmail(); 
	public abstract String getNombre(); 
	public abstract String getApellido(); 
	public abstract String getDescripcion(); 
	public abstract String getBiografia(); 
	public abstract String getSitioweb(); 
	public abstract String getInstitucion(); 
	public abstract Date getFechaNac(); 
	public abstract Profesor buscarProfesor(String nickname);
	public abstract Socio buscarSocio(String nickname);
}
