package interfaces;
import java.util.Date;
import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.NicknameRepetidoException;
import exceptions.UsuarioRepetidoException;

public interface ICaltausuario {
	
	public abstract void datosUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) throws UsuarioRepetidoException, NicknameRepetidoException, EmailRepetidoException, ErrorFechaException;
	public abstract void datosProfesor(String descripcion, String biografia, String sitioweb, String institucion, boolean profe);
	public abstract void altausuario();
	
}
