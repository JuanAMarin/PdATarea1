package logica;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ActividadDep {
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Date fechaAlta;
	private Map<String,Clase> clases;
	
	public ActividadDep(){}
	
	public ActividadDep(String nombre, String descripcion, Integer duracion, float costo, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaAlta = fechaAlta;
		this.clases=new HashMap<String,Clase>();
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

	public Map<String, Clase> getClases() {
		return clases;
	}

	public void setClases(Map<String, Clase> clases) {
		this.clases = clases;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	//-----------------------------------------------------------------------------------
	// Funciones ...
	
	
	
}
