package logica;

import java.util.ArrayList;
import java.util.Date;

import interfaces.ICconsultausuario;

public class Cconsultausuario implements ICconsultausuario{
	
	private String nickname, email, nombre, apellido, descripcion, biografia, sitioweb, institucion;
	private Date fechaNac;
	private boolean profe;
	
	public Cconsultausuario() {
		super();
	}
	
	@Override
	public void consultaUsuario(String key, boolean profe) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		if(profe) {
			Profesor prof = musus.buscarProfesor(key);
			InstitucionDep insti;
			this.profe=true;
			this.nickname=prof.getNickname();
			this.email=prof.getEmail();
			this.nombre=prof.getNombre();
			this.apellido=prof.getApellido();
			this.fechaNac=prof.getFechaNac();
			this.descripcion=prof.getDescripcion();
			this.biografia=prof.getBiografia();
			this.sitioweb=prof.getSitioweb();
			insti=prof.getInstitucion();
			this.institucion=insti.getNombre();
		}else {
			Socio socio = musus.buscarSocio(key);
			this.nickname=socio.getNickname();
			this.email=socio.getEmail();
			this.nombre=socio.getNombre();
			this.apellido=socio.getApellido();
			this.fechaNac=socio.getFechaNac();
		}
	}
	
	
	@Override
	public boolean esProfe(Socio s, Profesor p, String key) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		s=musus.buscarSocio(key);
		if(s==null) {
			p=musus.buscarProfesor(key);
			return true;
		}
		return false;
	}
	
	@Override
	public ArrayList<String> listarUsuarios(){
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ArrayList<String> profes = musus.obtenerProfesores();
		profes.addAll(musus.obtenerSocios());
		return profes;
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
}
