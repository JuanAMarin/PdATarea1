package datatypes;
import java.util.Map;
import logica.Clase;

public class DtActividadDep {
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Map<String,Clase> clases;
	
	public DtActividadDep(String nombre, String descripcion, Integer duracion, float costo, Map<String, Clase> clases) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.clases = clases;
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
	
}
