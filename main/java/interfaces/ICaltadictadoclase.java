package interfaces;

import java.util.Date;

import datatypes.DtActividadDep;
import datatypes.DtInstitucionDep;
import exceptions.ClaseRepetidaException;
import exceptions.ErrorFechaException;

public interface ICaltadictadoclase {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String nombre);
	public abstract void altaClase(String nombre, String url, Date fecha, Date fechaReg, Date HoraInicio, String profesor, String actividad, byte[] image) throws ClaseRepetidaException,ErrorFechaException;
	public abstract String[] listarClases();
	public String[] listarProfesores(String insti);
	public abstract void buscarActividad(String actividad);
	public abstract DtActividadDep getDtad();
	public DtInstitucionDep buscarInsti(String insti);
	public boolean existeClase(String clase);
}
