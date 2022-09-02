package datatypes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import logica.Registro;
import logica.Socio;

public class DtSocio extends DtUsuario{
	private Map<Socio,Registro> registros;

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.registros= new HashMap <Socio,Registro>();
	}

	public Map<Socio, Registro> getRegistros() {
		return registros;
	}
	
}
