package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Socio extends Usuario{
	private Map<Clase,Registro> registros;
	
	public Socio() {}

	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.registros = new HashMap<Clase,Registro>();
	}

	public Map<Clase, Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<Clase, Registro> registros) {
		this.registros = registros;
	}
}
