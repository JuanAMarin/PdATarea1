package logica;

public class InstitucionDep {
	private String nombre, descripcion, url;
	private ActividadDep actividad;

	public InstitucionDep(String nombre, String descripcion, String url, ActividadDep actividad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividad=actividad;
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

	public ActividadDep getActividad() {
		return actividad;
	}

	public void setActividad(ActividadDep actividad) {
		this.actividad = actividad;
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
	
	
}
