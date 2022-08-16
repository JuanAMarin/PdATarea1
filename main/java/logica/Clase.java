package logica;

import java.util.Date;

public class Clase {
	private String nombre, url;
	private Date fecha, fechaReg, horaInicio;
	private Registro registro;
	
	public Clase(String nombre, String url, Date fecha, Date fechaReg, Date horaInicio, Registro registro) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fecha = fecha;
		this.fechaReg = fechaReg;
		this.horaInicio = horaInicio;
		this.registro = registro;
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
	public Registro getRegistro() {
		return registro;
	}
	public void setRegistro(Registro registro) {
		this.registro = registro;
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
	
	
	
	
	
}
