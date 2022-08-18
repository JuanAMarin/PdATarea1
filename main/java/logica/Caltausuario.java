package logica;
import java.time.LocalDate;
import interfaces.ICaltausuario;

public class Caltausuario implements ICaltausuario{

	protected String nickname, nombre, apellido, email;
	protected LocalDate fechaNac;
	private String descripcion, biografia, sitioweb;
	private InstitucionDep institucion;
	private boolean profe;
	
	public void datosUsuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac) {
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
		ManejadorUsuarios musu = ManejadorUsuarios.getInstancia();
		Usuario usu;
		if(profe)
			usu = new Profesor(nickname, nombre, apellido, email, fechaNac, descripcion, biografia, sitioweb, institucion);
		else
			usu = new Socio(nickname, nombre, apellido, email, fechaNac);
		musu.agregarUsuario(usu);
	}
}
