package logica;

import java.util.ArrayList;
import java.util.Date;

import interfaces.ICaltaactividaddeportiva;

public class Caltaactividaddeportiva implements ICaltaactividaddeportiva{

	private String insti;
	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	
	public void datosActividad(String nombre, String descripcion, Integer duracion, float costo, String insti){
		this.costo=costo;
		this.descripcion=descripcion;
		this.duracion=duracion;
		this.nombre=nombre;
		this.insti=insti;
	}
	public void altaActividad(){
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		InstitucionDep institucion = mI.buscarInstitucion(this.insti);
		ActividadDep actividad = new ActividadDep(this.nombre, this.descripcion, this.duracion, this.costo);
		mI.agregarActividad(actividad, institucion);
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		instituciones = mI.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}
	
}
