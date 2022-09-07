package datatypes;

import java.util.Date;

public class DtActividadDep {
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Date fechaReg;
	
	public DtActividadDep(String nombre, String descripcion, Integer duracion, float costo, Date fechaReg) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
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
	
	
	
}
