package interfaces;

import datatypes.DtActividadDep;

public interface ICmodactividaddep {
	public abstract String[] listarActividades();
	public abstract void ModActividadDeportiva(String nombre, String descripcion, Integer duracion, float costo, byte[] personImage);
	public abstract DtActividadDep obtenerInfo(String act);
}

