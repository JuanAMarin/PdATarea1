package logica;
import exceptions.UsuarioRepetidoException;
import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.NicknameRepetidoException;
import interfaces.ICaltausuario;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Caltausuario implements ICaltausuario{

	protected String nickname, nombre, apellido, email;
	protected Date fechaNac;
	private String descripcion, biografia, sitioweb;
	private InstitucionDep institucion;
	private boolean profe;
	
	@SuppressWarnings("deprecation")
	public void datosUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) throws UsuarioRepetidoException, NicknameRepetidoException, EmailRepetidoException, ErrorFechaException{
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		if(musus.usuarios.containsKey(nickname + email))
			throw new UsuarioRepetidoException("El nickname " + nickname + " y el email " + email + " ya ha sido ingresado");
		Iterator<Map.Entry<String, Usuario>> itr = musus.usuarios.entrySet().iterator();
        while(itr.hasNext()) {
        	Map.Entry<String, Usuario> entry = itr.next();
        	if(nickname.equalsIgnoreCase(entry.getValue().getNickname()))
        		throw new NicknameRepetidoException("El nickname " + nickname + " ya ha sido ingresado");
        	else if(email.equalsIgnoreCase(entry.getValue().getEmail()))
        		throw new EmailRepetidoException("El email " + email + " ya ha sido ingresado");
        }
        Date century = new Date();
        century.setYear(century.getYear()-100); //Se puede cambiar valor de resta para limite de edad
        
        if(fechaNac.after(new Date()) || fechaNac.before(century))
    		throw new ErrorFechaException("La fecha es incorrecta");
        
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
	}
	
	
	public void datosProfesor(String descripcion, String biografia, String sitioweb, InstitucionDep institucion, boolean profe) {
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucion = institucion;
		this.profe = profe;
	}
	
	public void altausuario() {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		Usuario usu;
		if(profe)
			usu = new Profesor(nickname, nombre, apellido, email, fechaNac, descripcion, biografia, sitioweb, institucion);
		else
			usu = new Socio(nickname, nombre, apellido, email, fechaNac);
		musus.agregarUsuario(usu);
	}
}
