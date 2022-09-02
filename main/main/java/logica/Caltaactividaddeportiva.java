package logica;

import java.util.ArrayList;
import java.util.Date;

import interfaces.ICaltaactividaddeportiva;

public class Caltaactividaddeportiva implements ICaltaactividaddeportiva{

	private String nombre, descripcion;
	private Integer duracion;
	private float costo;
	private Date fecha;
	
	public void datosActividad(){
		
	}
	public void altaActividad(){
		
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
