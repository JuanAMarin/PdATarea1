package logica;

import exceptions.ClaseRepetidaException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import interfaces.ICaltadictadoclase;

public class Caltadictadoclase implements ICaltadictadoclase {
	private String nombre, url;
	private Profesor profesor;

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
	public String[] listarClases() {
		ArrayList<String> clases;
		ManejadorClases mC = ManejadorClases.getInstancia();
		clases = mC.obtenerClases();
		String[] Lclases = new String[clases.size()];
		int i = 0;
		for (String c:clases) {
			Lclases[i]=c;
			i++;
		}
		return Lclases;
	}

	
	public String[] listarActividades(String nombre) {
		ArrayList<String> actividades = new ArrayList<>();
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		List<ActividadDep> actividadesL = mI.buscarInstitucion(nombre).getActividades();
		Iterator<ActividadDep> it = actividadesL.iterator();
		while(it.hasNext()) {
		      actividades.add(it.next().getNombre());
		}
		String[] act = new String[actividades.size()];
		int i = 0;
		for (String ad:actividades) {
			act[i]=ad;
			i++;
		}
		return act;
	}
	
	public void altaClase(String nombre, String url, Date fecha, Date fechaReg, Date HoraInicio, String profesor, String actividad) throws ClaseRepetidaException {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ManejadorClases mC = ManejadorClases.getInstancia(); 
		ActividadDep activity = mAD.buscarActividad(actividad);
		Clase nuevaClase = mC.buscarClase(nombre);
		if (nuevaClase != null)
			throw new ClaseRepetidaException("La clase de nombre "+ nombre + " ya existe en el Sistema");
		Clase c = new Clase(nombre, url, fecha, fechaReg, HoraInicio);
		musus.addClase(profesor, c);
		mAD.addClase(activity, c);
	}

	@Override
	public String[] listarProfesores(String insti) {
		ManejadorUsuarios mU = ManejadorUsuarios.getInstancia();
		List<String> lista = mU.obtenerProfesoresInst(insti);
		String[] users = new String[lista.size()];
		int i = 0;
		for(String s: lista) {
			users[i] = s;
			i++;
		}
		return users;
	}

}



