package interfaces;

import java.util.Date;

import exceptions.ClaseRepetidaException;

public interface ICaltadictadoclase {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String nombre);
	public abstract void altaClase(String nombre, String url, Date fecha, Date fechaReg, Date HoraInicio, String profesor, String actividad) throws ClaseRepetidaException;
	public abstract String[] listarClases();
	public String[] listarProfesores(String insti);
}
