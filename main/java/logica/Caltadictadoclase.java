package logica;

import exceptions.ClaseRepetidaException;
import exceptions.InstitucionRepetidaException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import datatypes.DtClase;
import datatypes.DtHora;
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
	
	public void altaClase(String nombre, String url, Date fecha, LocalDateTime fechaReg, DtHora HoraInicio, String profesor) throws ClaseRepetidaException {
		ManejadorUsuarios musus = ManejadorUsuarios.getInstancia();
		ManejadorClases mC = ManejadorClases.getInstancia(); 
		Usuario usu = musus.buscarUsuario(profesor);
		Clase nuevaClase = mC.buscarClase(nombre);
		if (nuevaClase != null)
			throw new ClaseRepetidaException("La clase de nombre "+ nombre + " ya existe en el Sistema");
		Clase c = new Clase(nombre, url, fecha, fechaReg, HoraInicio, usu);
		mC.agregarClase(c);	
	}

	

}



