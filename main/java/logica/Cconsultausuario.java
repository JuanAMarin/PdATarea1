package logica;

import java.util.Date;

import interfaces.ICconsultausuario;

public class Cconsultausuario implements ICconsultausuario{
	
	private String nickname, email, nombre, apellido, descripcion, biografia, sitioweb, institucion;
	private Date fechaNac;
	private boolean profe;
	
	public Cconsultausuario() {
		super();
	}
	
	public void consultaUsuario(String key) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		Usuario usu = musus.buscarUsuario(key);
		Class<? extends Usuario> clase = usu.getClass();
		String name = clase.getName();
		if(name == "Profesor" ) {
			Profesor prof = (Profesor) usu;
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
			Socio socio = (Socio) usu;
			this.nickname=socio.getNickname();
			this.email=socio.getEmail();
			this.nombre=socio.getNombre();
			this.apellido=socio.getApellido();
			this.fechaNac=socio.getFechaNac();
		}
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
