package logica;

import java.util.Date;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtSocio;
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
		Manejador mU = Manejador.getInstancia();
		List<String> lista = mU.listarUsuarios();
		String[] users = new String[lista.size()];
		int i = 0;
		for(String s: lista) {
			users[i] = s;
			i++;
		}
		return users;
	}
	
	public DtProfesor buscarProfesor(String nickname) {
		Manejador mU = Manejador.getInstancia();
		return mU.buscarProfesor(nickname);
	}
	
	public DtSocio buscarSocio(String nickname) {
		Manejador mU = Manejador.getInstancia();
		return mU.buscarSocio(nickname);
	}

	
	
}
