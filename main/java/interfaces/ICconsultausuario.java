package interfaces;

import java.util.ArrayList;

import datatypes.DtProfesor;
import datatypes.DtSocio;

public interface ICconsultausuario {
	public abstract String[] listarUsuarios();
	public abstract ArrayList<Object[]> listarClasesP(String nickname);
	public abstract ArrayList<Object[]> listarClasesS(String nickname);
	public abstract ArrayList<Object[]> listarRegistros(String nombre);
	public abstract ArrayList<Object[]> listarClasesA(String nombre);
	public abstract DtSocio getSocioDT();
	public abstract DtProfesor getProfesorDT();
	public abstract ArrayList<Object[]> listarActividades(String nickname);
	public abstract DtProfesor buscarProfesor(String nickname);
	public abstract DtSocio buscarSocio(String nickname);
	public abstract void buscarUsuario(String nickname);
}
