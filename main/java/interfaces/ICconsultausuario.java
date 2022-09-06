package interfaces;

import java.util.Date;

import datatypes.DtProfesor;
import datatypes.DtSocio;

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
	public abstract DtProfesor buscarProfesor(String nickname);
	public abstract DtSocio buscarSocio(String nickname);
}
