package logica;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import interfaces.ICmodusuario;

public class Cmodusuario implements ICmodusuario {

	public void modProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		Usuario aux=musus.buscarUsuario(nickname);
		Class<? extends Usuario> clase = aux.getClass();
		String name = clase.getName();
		if(name == "Profesor") {
			Profesor prof = (Profesor) aux;
			if(aux!=null) {
				prof.setEmail(email);
				prof.setNickname(nickname);
				prof.setApellido(apellido);
				prof.setFechaNac(fechaNac);
				prof.setNombre(nombre);
				prof.setDescripcion(descripcion);
				prof.setBiografia(biografia);
				prof.setSitioweb(sitioweb);
			}
		}
	}
	
	public void modSocio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		Usuario aux=musus.buscarUsuario(nickname);
		Class<? extends Usuario> clase = aux.getClass();
		String name = clase.getName();
		if(name == "Socio") {
			Socio socio = (Socio) aux;
			if(aux!=null) {
				socio.setEmail(email);
				socio.setNickname(nickname);
				socio.setApellido(apellido);
				socio.setFechaNac(fechaNac);
				socio.setNombre(nombre);
			}
		}
	}
	

	public String[] listarUsuarios() {
		ArrayList<String> usuarios;
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		usuarios = musus.obtenerUsuarios();
		String[] inst = new String[usuarios.size()];
		int i = 0;
		for (String ins:usuarios) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}

	public Usuario obtenerInfo(String nombre) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		return musus.buscarxNick(nombre);
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		instituciones = mI.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}
	
}
