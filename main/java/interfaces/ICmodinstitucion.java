package interfaces;

import logica.InstitucionDep;

public interface ICmodinstitucion {
	public abstract void modInstitucion(String nombreInstitucion, String descripcion, String url);
	public abstract String[] listarInstituciones();
	public abstract InstitucionDep obtenerInfo(String nombre);
	public abstract String[] listarActividades();
	public abstract void eliminarAct(String nombreAct);

}
