package logica;

import exceptions.ClaseRepetidaException;

import java.util.ArrayList;

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

	/*
	public String[] listarActividades() {
		ArrayList<String> actividades;
		ManejadorActividadDep mAD = ManejadorActividadDep.getInstancia();
		actividades = mAD.obtenerActividadesDep();
		String[] act = new String[actividades.size()];
		int i = 0;
		for (String ad:actividades) {
			act[i]=ad;
			i++;
		}
		return act;
	}*/
	
	public void agregarClase() throws ClaseRepetidaException{
		/*ManejadorClases mC = ManejadorClases.getInstancia();
		Clase nuevaClase = mC.buscarClase(clase.getNombre());
		if (nuevaClase != null)
			throw new ClaseRepetidaException("La clase de nombre "+ clase.getNombre() + " ya existe en el Sistema");
		mC.agregarClase(nuevaClase);*/
	}

	public String[] listarActividades() {
		return null;
	}
	
	public void datosClase(String nombre, String url, String profesor) {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		Usuario usu=musus.buscarxNick(nombre);
		this.profesor=(Profesor) usu;
		this.nombre=nombre;
		this.url=url;
	}
}

