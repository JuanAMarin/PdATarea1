package interfaces;

import logica.ActividadDep;

public interface ICmodactividaddep {
	public abstract String[] listarActividades();
	public abstract void ModActividadDeportiva(String nombre, String descripcion, Integer duracion, float costo);
	public abstract ActividadDep obtenerInfo(String act);
}

