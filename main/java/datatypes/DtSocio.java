package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Registro;

public class DtSocio extends DtUsuario{
	private List<Registro> registros;

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.registros= new ArrayList <Registro>();
	}

	public List<Registro> getRegistros() {
		return registros;
	}
	
}
