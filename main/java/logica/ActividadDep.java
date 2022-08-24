package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActividadDep {
	@Id
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private float costo;
	private List<Clase> clases;
	
	public ActividadDep(String nombre, String descripcion, Integer duracion, float costo, Clase clase) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.clases=new ArrayList<>();
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

	public void setClases(Map<String, Clase> clases) {
		this.clases = clases;
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
	
	//-----------------------------------------------------------------------------------
	// Funciones ...
	
	
	
}
