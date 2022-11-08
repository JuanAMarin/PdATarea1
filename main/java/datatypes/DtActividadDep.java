package datatypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtActividadDep {
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Date fechaReg;
	private byte[] image;
	
	public DtActividadDep(){}
	
	public DtActividadDep(String nombre, String descripcion, Integer duracion, float costo, Date fechaReg, byte[] image) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
		this.image=image;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public float getCosto() {
		return costo;
	}

	public Date getFechaReg() {
		return fechaReg;
	}
	
	public byte[] getImage() {
		return image;

	}
	
}
