package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorActividadDeportiva {
	private static ManejadorActividadDeportiva instancia = null;
	private List<ActividadDep> actividades = new ArrayList<>();
	
	private ManejadorActividadDeportiva() {}
	
	public static ManejadorActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new ManejadorActividadDeportiva();
		return instancia;
	}
	
	public void agregarActividad(ActividadDep actividadDep) {
		actividades.add(actividadDep);
	}
	
	public ActividadDep buscarActividad(String nombre) {
		ActividadDep aretornar=null;
		for(ActividadDep a: actividades) {
			if (a.getNombre().equals(nombre))
				aretornar=a;
		}
		return aretornar;
	}
	
	public ArrayList<String> obtenerActividades(){
		ArrayList<String> retorno = new ArrayList<>();
		for(ActividadDep aux: actividades) {
			retorno.add(aux.getNombre());
		}
		return retorno;
	}
	
	public void eliminarActividad(String nombre) {
		ActividadDep aEliminar= buscarActividad(nombre);
		actividades.remove(aEliminar);
	}



}

