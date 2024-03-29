package logica;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtHora;

@Entity
public class Clase {
	@Id
	private String nombre;
	private String url;
	private Usuario profesor;
	LocalDateTime fechaReg;
	private Date fecha;
	private DtHora horaInicio;

	@OneToMany(mappedBy="clase",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros;
	
	public Clase() {
		super();
	}
	
	public Clase(String nombre, String url, Date fecha, LocalDateTime fechaReg, DtHora horaInicio, Usuario profesor) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fecha = fecha;
		this.fechaReg = fechaReg;
		this.horaInicio = horaInicio;
		this.profesor = profesor;
		this.registros = new ArrayList<>();
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
	public LocalDateTime getFechaReg() {
		return fechaReg;
	}
	public DtHora getHoraInicio() {
		return horaInicio;
	}
	public Usuario getProfesor() {
		return profesor;
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
	public void setFechaReg(LocalDateTime fechaReg) {
		this.fechaReg = fechaReg;
	}
	public void setHoraInicio(DtHora horaInicio) {
		this.horaInicio = horaInicio;
	}
}
