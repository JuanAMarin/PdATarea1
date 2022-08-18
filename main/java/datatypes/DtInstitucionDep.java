package datatypes;
import java.util.Map;
import logica.ActividadDep;

public class DtInstitucionDep {
	private String nombre, descripcion, url;
	private Map<String,ActividadDep> actividades;
	
	public DtInstitucionDep(String nombre, String descripcion, String url, Map<String, ActividadDep> actividades) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividades = actividades;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUrl() {
		return url;
	}

	public Map<String, ActividadDep> getActividades() {
		return actividades;
	}
}
