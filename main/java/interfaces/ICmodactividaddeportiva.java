package interfaces;

import java.util.Date;

import logica.ActividadDep;
import logica.Clase;

public interface ICmodactividaddeportiva {
	public abstract String[] listarActividades();
	public abstract void ModActividadDeportiva(String nombre, String descripcion, Integer duracion, float costo);
	public abstract ActividadDep obtenerInfo(String act);
}
