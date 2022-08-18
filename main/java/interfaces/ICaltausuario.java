package interfaces;
import java.time.LocalDate;
import logica.InstitucionDep;

public interface ICaltausuario {
	
	public abstract void datosUsuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac);
	public abstract void datosProfesor(String descripcion, String biografia, String sitioweb, InstitucionDep institucion, boolean profe);
	public abstract void altausuario();
	
}
