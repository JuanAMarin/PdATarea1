package logica;

import java.util.ArrayList;

import exceptions.ActividadRepetidaException;
import interfaces.ICaltaactividaddeportiva;

public class Caltaactividaddeportiva implements ICaltaactividaddeportiva{

	private String insti;
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	
	public void datosActividad(String nombre, String descripcion, Integer duracion, float costo, String insti)throws ActividadRepetidaException{
		Manejador m = Manejador.getInstancia();
		if(m.buscarActividad(nombre)!= null)
			throw new ActividadRepetidaException("La actividad de nombre " + nombre + " ya ha sido ingresada");
		this.costo=costo;
		this.descripcion=descripcion;
		this.duracion=duracion;
		this.nombre=nombre;
		this.insti=insti;
	}
	public void altaActividad(){
		Manejador m = Manejador.getInstancia();
		ActividadDep actividad = new ActividadDep(this.nombre, this.descripcion, this.duracion, this.costo);
		m.agregarActividad(actividad, this.insti);
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		Manejador m = Manejador.getInstancia();
		instituciones = m.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}
	
}
