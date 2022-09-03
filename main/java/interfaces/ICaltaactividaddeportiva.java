package interfaces;

public interface ICaltaactividaddeportiva {
	public abstract void datosActividad(String nombre, String descripcion, Integer duracion, float costo, String insti);
	public abstract void altaActividad();
	public abstract String[] listarInstituciones();
}
