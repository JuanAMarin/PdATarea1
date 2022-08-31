package interfaces;

import java.time.LocalDateTime;
import java.util.Date;

import datatypes.DtHora;
import exceptions.ClaseRepetidaException;

public interface ICaltadictadoclase {
	
	public abstract String[] listarInstituciones();
	//public abstract String[] listarActividades(String nombre);
	public abstract String[] listarActividades();
	public abstract void altaClase(String nombre, String url, Date fecha, LocalDateTime fechaReg, DtHora HoraInicio, String profesor) throws ClaseRepetidaException;
	public abstract String[] listarClases();

	
}
