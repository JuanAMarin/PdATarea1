package logica;
import java.util.HashMap;
import java.util.Map;

public class InstitucionDep {
	private String nombre, descripcion, url;
	private Map<String,ActividadDep> actividades;
	
	public InstitucionDep(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividades = new HashMap<String,ActividadDep>();
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setActividades(Map<String, ActividadDep> actividades) {
		this.actividades = actividades;
	}
	public ActividadDep buscarActividad(String nombre) {
		return actividades.get(nombre);
	}
}
