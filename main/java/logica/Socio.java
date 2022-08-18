package logica;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Socio extends Usuario{
	private Map<Socio,Registro> registros;
	
	public Socio(String nickname, String nombre, String apellido, String email, LocalDate fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.registros = new HashMap<Socio,Registro>();
	}

	public Map<Socio, Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<Socio, Registro> registros) {
		this.registros = registros;
	}
	
	
}
