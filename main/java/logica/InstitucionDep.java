package logica;
import java.util.ArrayList;
import java.util.List;

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
	
	public InstitucionDep() {
		super();
	}
	
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ActividadDep> getActividades() {
		return actividades;
	}
	public void setActividades(List<ActividadDep> actividades) {
		this.actividades = actividades;
	}
	
}
