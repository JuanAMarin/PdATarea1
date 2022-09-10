package datatypes;

import java.util.Date;

public class DtRegistro {
	protected String nickname;
	protected Date fecha;
	
	public DtRegistro(String nickname, Date fecha) {
		super();
		this.nickname = nickname;
		this.fecha = fecha;
	}

	public String getNickname() {
		return nickname;
	}

	public Date getFecha() {
		return fecha;
	}
}
