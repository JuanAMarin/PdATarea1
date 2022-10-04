package datatypes;

import java.util.Date;;

public class DtClase {
	private String nombre, url;
	private Date fecha, fechaReg, horaInicio;
	private byte[] image;
	
	public DtClase(String nombre, String url, Date fecha, Date fechaReg, Date horaInicio, byte[] image) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fecha = fecha;
		this.fechaReg = fechaReg;
		this.horaInicio = horaInicio;
		this.image = image;
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
	
	
	public byte[] getImage() {
		return image;
	}

}
