package interfaces;

import datatypes.DtClase;

public interface ICregistrodeclases {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String nombre);
	public abstract String[] listarClases(String actividad);
	public abstract DtClase buscarClase(String clase);
	public abstract String[] listarSocios();
}
