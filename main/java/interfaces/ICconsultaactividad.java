package interfaces;

import java.util.ArrayList;

import datatypes.DtActividadDep;

public interface ICconsultaactividad {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String institucion);
	public abstract void buscarActividad(String actividad);
	public abstract DtActividadDep getDtad();
	public abstract ArrayList<Object[]> listarClases(String actividad);
	public abstract ArrayList<Object[]> listarRegistros(String clase);
	public abstract String buscarProfesorCC(String clase);
}
