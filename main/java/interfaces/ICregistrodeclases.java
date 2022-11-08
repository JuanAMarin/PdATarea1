package interfaces;

import datatypes.DtClase;
import exceptions.SocioYaEliminadoException;
import exceptions.SocioYaRegistradoException;

public interface ICregistrodeclases {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String nombre);
	public abstract String[] listarClases(String actividad);
	public abstract DtClase buscarClase(String clase);
	public abstract String[] listarSocios();
	public abstract void Registro (String clase, String Socio)throws SocioYaRegistradoException;
	public abstract void eliminarRegistro (String clase, String socio) throws SocioYaEliminadoException;
	public abstract boolean socioYaRegistrado (String clase, String socio);
}
