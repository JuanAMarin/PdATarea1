package datatypes;

public class DtActividadDep {
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	
	public DtActividadDep(String nombre, String descripcion, Integer duracion, float costo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
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
	
}
