package logica;
import exceptions.UsuarioRepetidoException;
import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.NicknameRepetidoException;
import interfaces.ICaltausuario;
import persistencia.UsuarioID;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Caltausuario implements ICaltausuario{

	protected String nickname, nombre, apellido, email;
	protected Date fechaNac;
	private String descripcion, biografia, sitioweb;
	private String institucion;
	private boolean profe;
	
	
	@SuppressWarnings("deprecation")
	public void datosUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) throws UsuarioRepetidoException, NicknameRepetidoException, EmailRepetidoException, ErrorFechaException{
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		UsuarioID key = new UsuarioID(nickname, email);
		if(musus.buscarProfesor(key) == null && musus.buscarSocio(key) == null)
			throw new UsuarioRepetidoException("El nickname " + nickname + " y el email " + email + " ya ha sido ingresado");
		if(musus.emailRepetido(email)) {
			throw new EmailRepetidoException("El email " + email + " ya ha sido ingresado");
		} else if(musus.nicknameRepetido(nickname)) {
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
	}
	
	
	public void datosProfesor(String descripcion, String biografia, String sitioweb, String institucion, boolean profe) {
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucion = institucion;
		this.profe = profe;
	}
	
	public void altausuario() {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		if(profe) {
			Profesor profesor = new Profesor(nickname, nombre, apellido, email, fechaNac, descripcion, biografia, sitioweb, institucion);
			musus.agregarProfesor(profesor);
		}else {
			Socio socio = new Socio(nickname, nombre, apellido, email, fechaNac);
			musus.agregarSocio(socio);
		}
	}
}
