package logica;

import java.util.ArrayList;
import java.util.Date;

import interfaces.ICmodactividaddep;

public class Cmodactividaddep implements ICmodactividaddep {
	
	public String[] listarActividades() {
		ArrayList<String> actividades;
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		actividades = mAD.obtenerActividades();
		String[] act = new String[actividades.size()];
		int i = 0;
		for (String ad:actividades) {
			act[i]=ad;
			i++;
		}
		return act;
	}
	
	@Override
	public void ModActividadDeportiva(String nombre, String descripcion, Integer duracion, float costo) {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		mAD.modificarAD(nombre, descripcion, duracion, costo);	
	}
	
	public ActividadDep obtenerInfo(String nombre) {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDep a=mAD.buscarActividad(nombre);
		return a;
	}
}

