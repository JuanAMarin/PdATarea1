package persistencia;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private String email;
	
	public UsuarioID() {
		super();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioID other = (UsuarioID) obj;
		return Objects.equals(email, other.email) && Objects.equals(nickname, other.nickname);
	}
}
