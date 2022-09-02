package datatypes;

import java.util.Date;
import java.util.List;
import logica.Registro;

public class DtClase {
	private String nombre, url;
	private Date fecha, fechaReg, horaInicio;
	private List<Registro> registros;
	
	public DtClase(String nombre, String url, Date fecha, Date fechaReg, Date horaInicio,
			List<Registro> registros) {
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

	public List<Registro> getRegistros() {
		return registros;
	}	
	
}
