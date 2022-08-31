package interfaces;

import java.util.ArrayList;
import java.util.Date;

import logica.Profesor;
import logica.Socio;

public interface ICconsultausuario {
	public abstract void consultaUsuario(String nickname);
	public abstract String[] listarUsuarios();
	public ArrayList<String> listarSocios();
	public ArrayList<String> listarProfesores();
	public abstract String getNickname(); 
	public abstract String getEmail(); 
	public abstract String getNombre(); 
	public abstract String getApellido(); 
	public abstract String getDescripcion(); 
	public abstract String getBiografia(); 
	public abstract String getSitioweb(); 
	public abstract String getInstitucion(); 
	public abstract Date getFechaNac(); 
	public abstract boolean isProfe();
	boolean esProfe(Socio s, Profesor p, String nickname); 

	
}
