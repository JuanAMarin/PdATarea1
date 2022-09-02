package interfaces;

import java.util.List;

import logica.Clase;

public interface ICregistrodeclases {
	public abstract String[] listarInstituciones();
	public abstract String[] listarActividades(String nombre);
	public abstract List<Clase> listarClases(String nombre);
	public abstract void setInsti(String insti);
	public abstract void setActi(String acti);
}
