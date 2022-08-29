package interfaces;

import exceptions.ClaseRepetidaException;
import exceptions.InstitucionRepetidaException;
import logica.Registro;
import logica.Socio;
import logica.Usuario;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import datatypes.DtClase;
import datatypes.DtHora;

public interface ICaltadictadoclase {
	
	public abstract String[] listarInstituciones();
	//public abstract String[] listarActividades(String nombre);
	public abstract String[] listarActividades();
	public abstract void altaClase(String nombre, String url, Date fecha, LocalDateTime fechaReg, DtHora HoraInicio, String profesor) throws ClaseRepetidaException;
	
	
	
	public abstract String[] listarClases();
}