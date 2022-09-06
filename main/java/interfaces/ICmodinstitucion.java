package interfaces;

import datatypes.DtInstitucionDep;

public interface ICmodinstitucion {
	public abstract void modInstitucion(String nombreInstitucion, String descripcion, String url);
	public abstract String[] listarInstituciones();
	public abstract DtInstitucionDep obtenerInfo(String nombre);
}
