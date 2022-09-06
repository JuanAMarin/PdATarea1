package logica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtClase;

@Entity
public class Clase {
	@Id
	private String nombre;
	
	private String url;
	private Date fecha, fechaReg, horaInicio;
	
	@OneToMany(mappedBy="clase",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<Registro>();;
	
	public Clase() {
		super();
	}

	public Clase(String nombre, String url, Date fecha, Date fechaReg, Date horaInicio) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fecha = fecha;
		this.fechaReg = fechaReg;
		this.horaInicio = horaInicio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getUrl() {
		return url;
	}
	public Date getFecha() {
		return fecha;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public DtClase getDT() {
		return new DtClase(this.getNombre(),this.getUrl(),this.getFecha(),this.getFechaReg(),this.getHoraInicio());
	}
}
