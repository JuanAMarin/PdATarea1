package interfaces;

import logica.InstitucionDep;

public interface ICmodinstitucion {
	public abstract void modInstitucion(String nombreInstitucion, String descripcion, String url);
	public String[] listarInstituciones();
	public InstitucionDep obtenerInfo(String nombre);
}
