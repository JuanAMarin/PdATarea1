package logica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import datatypes.DtSocio;

@Entity
public class Socio extends Usuario{
	@OneToMany(mappedBy="socio",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
	
	public Socio() {
		super();
	}
	
	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac, String contra, byte[] image) {
		super(nickname, nombre, apellido, email, fechaNac, contra, image);
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public DtSocio getDT() {
		return new DtSocio(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac(), this.getImage());
	}
	
	public void addRegistro(Registro r) {
		registros.add(r);
	}
}
