package logica;
import exceptions.UsuarioRepetidoException;
import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.NicknameRepetidoException;
import interfaces.ICaltausuario;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtInstitucionDep;

public class Caltausuario implements ICaltausuario{

	protected String nickname, nombre, apellido, email;
	protected Date fechaNac;
	private String descripcion, biografia, sitioweb;
	private String institucion;
	private boolean profe;
	
	
	@SuppressWarnings("deprecation")
	public void datosUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) throws UsuarioRepetidoException, NicknameRepetidoException, EmailRepetidoException, ErrorFechaException{
		Manejador m = Manejador.getInstancia();
		if(m.nicknameRepetido(nickname) && m.emailRepetido(email))
			throw new UsuarioRepetidoException("El nickname " + nickname + " y el email " + email + " ya ha sido ingresado");
		if(m.emailRepetido(email)) {
			throw new EmailRepetidoException("El email " + email + " ya ha sido ingresado");
		} else if(m.nicknameRepetido(nickname)) {
			throw new NicknameRepetidoException("El nickname " + nickname + " ya ha sido ingresado");
		}
        Date century = new Date();
        century.setYear(century.getYear()-100); //you can change the value of the subtraction to the age limit
        
        if(fechaNac.after(new Date()) || fechaNac.before(century))
    		throw new ErrorFechaException("La fecha es incorrecta");
        
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.profe = false;
	}
	
	
	public void datosProfesor(String descripcion, String biografia, String sitioweb, String institucion, boolean profe) {
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucion = institucion ;
		this.profe = profe;
	}
	
	public void altausuario() {
		Manejador m = Manejador.getInstancia();
		if(profe) {
			DtInstitucionDep DtInsti = m.buscarInstitucion(institucion);
			InstitucionDep insti = new InstitucionDep(DtInsti.getNombre(),DtInsti.getDescripcion(),DtInsti.getUrl());
			Profesor profesor = new Profesor(nickname, nombre, apellido, email, fechaNac, descripcion, biografia, sitioweb, insti);
			m.agregarProfesor(profesor);
		}else {
			Socio socio = new Socio(nickname, nombre, apellido, email, fechaNac);
			m.agregarSocio(socio);
		}
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		Manejador m = Manejador.getInstancia();
		instituciones = m.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}

}

