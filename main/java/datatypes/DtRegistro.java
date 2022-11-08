package datatypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtRegistro {
	protected String nickname;
	protected Date fecha;
	
	public DtRegistro(){}
	
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
