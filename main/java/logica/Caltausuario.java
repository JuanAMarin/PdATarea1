package logica;
import java.time.LocalDate;
import exceptions.UsuarioRepetidoException;
import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import interfaces.ICaltausuario;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

public class Caltausuario implements ICaltausuario{

	protected String nickname, nombre, apellido, email;
	protected LocalDate fechaNac;
	private String descripcion, biografia, sitioweb;
	private InstitucionDep institucion;
	private boolean profe;
	
	public void datosUsuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac) throws UsuarioRepetidoException, EmailRepetidoException, ErrorFechaException{
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		if(musus.usuarios.containsKey(nickname))
			throw new UsuarioRepetidoException("El nickname " + nickname + " ya ha sido ingresado");
		Iterator<Map.Entry<String, Usuario>> itr = musus.usuarios.entrySet().iterator();
        while(itr.hasNext()) {
        	Map.Entry<String, Usuario> entry = itr.next();
        	if(email == entry.getValue().email)
        		throw new EmailRepetidoException("El email " + email + " ya ha sido ingresado");
    		int dia = (int)fechaNac.getDayOfMonth();
    		int mes = (int)fechaNac.getMonthValue();
    		int anio = (int)fechaNac.getYear();
    		Calendar cal= Calendar.getInstance();
    		int year= cal.get(Calendar.YEAR);
    		if(anio>year || anio<year-100)
    			throw new ErrorFechaException("*Fecha inadecuada");
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12)
				if(dia>31 ||dia<1)
					throw new ErrorFechaException("*Fecha inadecuada");
			else if(mes==4 || mes==6 || mes==9 || mes==11) {
				if(anio%400==0 || (anio%4==0 && anio%100!=0))
					if(mes == 2)
						if(dia>29 ||dia<1)
							throw new ErrorFechaException("*Fecha inadecuada");
				else {
					if(mes == 2)
						if(dia>28 ||dia<1)
							throw new ErrorFechaException("*Fecha inadecuada");
					else
						if(dia>30 ||dia<1)
							throw new ErrorFechaException("*Fecha inadecuada");
				}
			}
    		this.nickname = nickname;
    		this.nombre = nombre;
    		this.apellido = apellido;
    		this.email = email;
    		this.fechaNac = fechaNac;
        }
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
