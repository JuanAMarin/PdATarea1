package interfaces;

import java.util.Date;

import exceptions.ClaseRepetidaException;
import exceptions.NoExisteProfesorException;

public interface ICaltadictadoclase {
	public abstract String[] listarInstituciones();
	//public abstract String[] listarActividades(String nombre);
	public abstract String[] listarActividades(String nombre);
	public abstract void altaClase(String nombre, String url, Date fecha, Date fechaReg, Date HoraInicio, String profesor) throws ClaseRepetidaException, NoExisteProfesorException;
	public abstract String[] listarClases();
}
