package interfaces;

import java.util.ArrayList;

import datatypes.DtActividadDep;
import datatypes.DtClase;

public interface ICconsultaclase {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String institucion);
	public abstract String[] listarClases(String actividad);
	public abstract void buscarClase(String clase);
	public abstract DtClase getDtad();
	public abstract ArrayList<Object[]> listarRegistros(String clase);
}
