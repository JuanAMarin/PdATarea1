package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import interfaces.ICaltaactividaddeportiva;

public class Caltaactividaddeportiva implements ICaltaactividaddeportiva{

	private String institucion, nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Date fecha;
	ManejadorInstituciones minst;
	
	public boolean datosClaveActividad(String institucion, String nombre){
		
		this.institucion=institucion;
		this.nombre=nombre;
		minst = ManejadorInstituciones.getInstancia();
		
		if(minst.instituciones.get(institucion).buscarActividad(nombre)==null)
			return false;
		else
			return true;
	}
	
	public void datosActividad(String institucion, String nombre, String descripcion, Integer duracion, float costo){
		
		this.institucion = institucion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = new Date();
			
	}
	public void altaActividad(){
		minst = ManejadorInstituciones.getInstancia();
		ActividadDep act;
		act = new ActividadDep(nombre, descripcion, duracion, costo, fecha);
		Map<String,ActividadDep> actividades = minst.instituciones.get(institucion).getActividades();
		actividades.put(nombre, act);
		minst.instituciones.get(institucion).setActividades(actividades);;
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		minst = ManejadorInstituciones.getInstancia();
		instituciones = minst.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}
	
}
