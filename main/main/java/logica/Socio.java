package logica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Socio extends Usuario{
	@OneToMany(mappedBy="socio",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros;

	public Socio() {
		super();
	}

	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.registros = new ArrayList<>();
	}	
}
