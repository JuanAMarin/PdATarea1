package logica;

import java.util.Date;
import java.util.List;

import interfaces.ICconsultausuario;

public class Cconsultausuario implements ICconsultausuario{
	
	private String nickname, email, nombre, apellido, descripcion, biografia, sitioweb, institucion;
	private Date fechaNac;
	private boolean profe;
	
	public Cconsultausuario() {
		super();
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getSitioweb() {
		return sitioweb;
	}

	public String getInstitucion() {
		return institucion;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public boolean isProfe() {
		return profe;
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
	
	public Profesor buscarProfesor(String nickname) {
		ManejadorUsuarios mU = ManejadorUsuarios.getInstancia();
		Usuario user = mU.buscarProfesor(nickname);
		Profesor profe = (Profesor) user;
		return profe;
	}
	
	public Socio buscarSocio(String nickname) {
		ManejadorUsuarios mU = ManejadorUsuarios.getInstancia();
		Usuario user = mU.buscarSocio(nickname);
		Socio socio = (Socio) user;
		return socio;
	}

	
	
}
