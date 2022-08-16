package logica;

public class ActividadDep {
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Clase clase;
	
	public ActividadDep(String nombre, String descripcion, Integer duracion, float costo, Clase clase) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.clase=clase;
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
	
	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
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
	
}
