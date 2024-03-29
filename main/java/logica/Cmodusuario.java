package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;
import java.util.Collections;

import interfaces.ICmodusuario;
import persistencia.UsuarioID;

public class Cmodusuario implements ICmodusuario {

	public void modProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, InstitucionDep institucion) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		UsuarioID key = new UsuarioID(nickname, email);
		Usuario aux=musus.buscarProfesor(key);
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
		UsuarioID key = new UsuarioID(nickname, email);
		Usuario aux=musus.buscarSocio(key);
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
	

	public ArrayList<String> listarSociosN() {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ArrayList<String> usuarios = musus.obtenerSociosN();
		return usuarios;
	}
	
	public ArrayList<String> listarProfesoresN() {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ArrayList<String> usuarios = musus.obtenerSociosN();
		return usuarios;
	}
	
	public String[] listarUsuariosN() {
		ArrayList<String> profes = listarProfesoresN();
		ArrayList<String> socios = listarSociosN();
		profes.addAll(socios);
		String[] usuarios = (String[]) profes.toArray();
		return usuarios;
	}
	
	public ArrayList<String> listarSociosE() {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ArrayList<String> usuarios = musus.obtenerSociosE();
		return usuarios;
	}
	
	public ArrayList<String> listarProfesoresE() {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ArrayList<String> usuarios = musus.obtenerSociosE();
		return usuarios;
	}
	
	public String[] listarUsuariosE() {
		ArrayList<String> profes = listarProfesoresE();
		ArrayList<String> socios = listarSociosE();
		profes.addAll(socios);
		String[] usuarios = (String[]) profes.toArray();
		return usuarios;
	}
	
	public Profesor obtenerProfesor(UsuarioID key) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		return musus.buscarProfesor(key);
	}
	
	public Socio obtenerSocio(UsuarioID key) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		return musus.buscarSocio(key);
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
