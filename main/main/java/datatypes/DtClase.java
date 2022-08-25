package datatypes;

import java.util.Date;
import java.util.Map;

import logica.Registro;
import logica.Socio;

public class DtClase {
	private String nombre, url;
	private Date fecha, fechaReg, horaInicio;
	private Map<Socio,Registro> registros;
	
	public DtClase(String nombre, String url, Date fecha, Date fechaReg, Date horaInicio,
			Map<Socio, Registro> registros) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fecha = fecha;
		this.fechaReg = fechaReg;
		this.horaInicio = horaInicio;
		this.registros = registros;
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

	public Map<Socio, Registro> getRegistros() {
		return registros;
	}	
	
}
