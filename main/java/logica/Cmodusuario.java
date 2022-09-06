package logica;

import java.util.Date;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.ICmodusuario;

public class Cmodusuario implements ICmodusuario {

	public void modProfesor(String nickname, String nombre, String apellido, Date fechaNac, String descripcion, String biografia, String sitioweb) {
		Manejador m = Manejador.getInstancia();
		m.modificarProf(nickname, nombre, apellido, fechaNac, descripcion, biografia, sitioweb);
	}
	
	public void modSocio(String nickname, String nombre, String apellido, Date fechaNac) {
		Manejador m = Manejador.getInstancia();
		m.modificarSoc(nickname, nombre, apellido, fechaNac);
	}
	
	@Override
	public String[] listarUsuarios() {
		Manejador m = Manejador.getInstancia();
		List<String> lista = m.listarUsuarios();
		String[] users = new String[lista.size()];
		int i = 0;
		for(String s: lista) {
			users[i] = s;
			i++;
		}
		return users;
	}
	
	public DtProfesor obtenerProfesor(String nickname) {
		Manejador m = Manejador.getInstancia();
		return m.buscarProfesor(nickname);
	}
	
	public DtSocio obtenerSocio(String nickname) {
		Manejador m = Manejador.getInstancia();
		return m.buscarSocio(nickname);
	}
	
}
