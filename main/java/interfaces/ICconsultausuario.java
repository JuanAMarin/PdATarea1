package interfaces;

import java.util.Date;

public interface ICconsultausuario {
	public abstract void consultaUsuario(String key);
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
	
}
