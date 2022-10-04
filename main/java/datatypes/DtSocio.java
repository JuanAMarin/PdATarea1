package datatypes;

import java.util.Date;

public class DtSocio extends DtUsuario{

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, byte[] image) {
		super(nickname, nombre, apellido, email, fechaNac, image);
	}
	
}
