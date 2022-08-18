package interfaces;
import java.time.LocalDate;

import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.UsuarioRepetidoException;
import logica.InstitucionDep;

public interface ICaltausuario {
	
	public abstract void datosUsuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac) throws UsuarioRepetidoException, EmailRepetidoException, ErrorFechaException;
	public abstract void datosProfesor(String descripcion, String biografia, String sitioweb, InstitucionDep institucion, boolean profe);
	public abstract void altausuario();
	
}
