package interfaces;

public interface ICaltaactividaddeportiva {
	
	public abstract boolean datosClaveActividad(String institucion, String nombre);
	public abstract void datosActividad(String institucion, String nombre, String descripcion, Integer duracion, float costo);
	public abstract void altaActividad();
	public abstract String[] listarInstituciones();

}
