package interfaces;

import exceptions.ActividadRepetidaException;

public interface ICaltaactividaddeportiva {
	public abstract void datosActividad(String nombre, String descripcion, Integer duracion, float costo, String insti)throws ActividadRepetidaException;
	public abstract void altaActividad();
	public abstract String[] listarInstituciones();
}
