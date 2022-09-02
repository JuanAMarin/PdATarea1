package logica;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class ActividadDep {
	@Id
	private String nombre;
 	
	private String descripcion;
	private Integer duracion;
	private float costo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Clase> clases;
	
	
	public ActividadDep() {
		super();
	}

	public ActividadDep(String nombre, String descripcion, Integer duracion, float costo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.clases=new ArrayList<Clase>();
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

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
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
