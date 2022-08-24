package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class InstitucionDep {
	@OneToMany(mappedBy="insti",cascade=CascadeType.ALL)
	@Id
	private String nombre;
	private String descripcion, url;
	private List<ActividadDep> actividades;
	
	public InstitucionDep(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividades=new ArrayList<>();
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
