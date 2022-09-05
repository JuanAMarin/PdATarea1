package interfaces;

import java.util.List;

import logica.Clase;

public interface ICregistrodeclases {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String nombre);
	public abstract String[] listarClases(String actividad);
	public abstract Clase buscarClase(String clase);
	public abstract void setInsti(String insti);
	public abstract void setActi(String acti);
}
