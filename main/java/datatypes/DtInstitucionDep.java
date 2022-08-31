package datatypes;

import java.util.List;
import logica.ActividadDep;

public class DtInstitucionDep {
	private String nombre, descripcion, url;
	private List<ActividadDep> actividades;
	
	public DtInstitucionDep(String nombre, String descripcion, String url, List<ActividadDep> actividades) {
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

	public List<ActividadDep> getActividades() {
		return actividades;
	}
}
