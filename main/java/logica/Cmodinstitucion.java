package logica;

import java.util.ArrayList;

import interfaces.ICmodinstitucion;

public class Cmodinstitucion implements ICmodinstitucion {

	@Override
	public void modInstitucion(String nombreInstitucion, String descripcion, String url) {
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		InstitucionDep aux=mI.buscarInstitucion(nombreInstitucion);
		if(aux!=null) {
			aux.setDescripcion(descripcion);
			aux.setUrl(url);
		}
	}

	@Override
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

	@Override
	public InstitucionDep obtenerInfo(String nombre) {
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		InstitucionDep aux=mI.buscarInstitucion(nombre);
		return aux;
	}
	
	@Override
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
	public void eliminarAct(String nombreAct) {
		ManejadorActividadDeportiva mAD= ManejadorActividadDeportiva.getInstancia();
		ActividadDep act = mAD.buscarActividad(nombreAct);
		mAD.eliminarActividad(act.getNombre());
	}

}
