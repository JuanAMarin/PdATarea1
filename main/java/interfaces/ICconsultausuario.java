package interfaces;

import java.util.ArrayList;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public interface ICconsultausuario {
	public abstract String[] listarUsuarios();
	public abstract ArrayList<Object[]> listarClasesP(String nickname);
	public abstract ArrayList<Object[]> listarClasesS(String nickname);
	public abstract ArrayList<Object[]> listarRegistros(String nombre);
	public abstract ArrayList<Object[]> listarClasesA(String nombre);
	public abstract DtUsuario getUsuario();
	public abstract ArrayList<Object[]> listarActividades(String nickname);
	public abstract DtProfesor buscarProfesor(String nickname);
	public abstract DtSocio buscarSocio(String nickname);
	public abstract void buscarUsuario(String nickname);
}
