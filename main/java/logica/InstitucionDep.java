package logica;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtInstitucionDep;

@Entity
public class InstitucionDep {
	@Id
	private String nombre;
	
	private String descripcion, url;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActividadDep> actividades = new ArrayList<ActividadDep>();
	
	public InstitucionDep() {
		super();
	}

	public InstitucionDep(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setActividades(List<ActividadDep> actividades) {
		this.actividades = actividades;
	}
	public ActividadDep buscarActividad(String nombre) {
		ActividadDep aretornar=null;
		for(ActividadDep a: actividades) {
			if (a.getNombre().equals(nombre))
				aretornar=a;
		}
		return aretornar;
	}

	public DtInstitucionDep getDT() {
		return new DtInstitucionDep(this.getNombre(), this.getDescripcion(), this.getUrl());
	}
}
