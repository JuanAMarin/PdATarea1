package interfaces;

import exceptions.ClaseRepetidaException;
import datatypes.DtClase;

public interface ICaltadictadoclase {
	
	public abstract void agregarClase() throws ClaseRepetidaException;
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades();
	public abstract void datosClase(String nombre, String url, String profesor);
	
}
