package logica;

import java.util.Date;
import java.util.List;

import interfaces.ICmodusuario;

public class Cmodusuario implements ICmodusuario {

	public void modProfesor(String nickname, String nombre, String apellido, Date fechaNac, String descripcion, String biografia, String sitioweb) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		musus.modificarProf(nickname, nombre, apellido, fechaNac, descripcion, biografia, sitioweb);
	}
	
	public void modSocio(String nickname, String nombre, String apellido, Date fechaNac) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		musus.modificarSoc(nickname, nombre, apellido, fechaNac);
	}
	
	@Override
	public String[] listarUsuarios() {
		ManejadorUsuarios mU = ManejadorUsuarios.getInstancia();
		List<String> lista = mU.listarUsuarios();
		String[] users = new String[lista.size()];
		int i = 0;
		for(String s: lista) {
			users[i] = s;
			i++;
		}
		return users;
	}
	
	public Profesor obtenerProfesor(String nickname) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		return musus.buscarProfesor(nickname);
	}
	
	public Socio obtenerSocio(String nickname) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		return musus.buscarSocio(nickname);
	}
	
}
