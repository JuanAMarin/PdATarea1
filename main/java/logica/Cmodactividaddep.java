package logica;

import java.util.ArrayList;

import datatypes.DtActividadDep;
import interfaces.ICmodactividaddep;

public class Cmodactividaddep implements ICmodactividaddep {
	
	public String[] listarActividades() {
		ArrayList<String> actividades;
		Manejador m = Manejador.getInstancia();
		actividades = m.obtenerActividades();
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
		Manejador m = Manejador.getInstancia();
		m.modificarAD(nombre, descripcion, duracion, costo);	
	}
	
	public DtActividadDep obtenerInfo(String nombre) {
		Manejador m = Manejador.getInstancia();
		return m.buscarActividad(nombre);
	}
}

