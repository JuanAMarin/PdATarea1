package logica;

import exceptions.ClaseRepetidaException;
import exceptions.ErrorFechaException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtClase;
import interfaces.ICaltadictadoclase;

public class Caltadictadoclase implements ICaltadictadoclase {

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
	public String[] listarClases() {
		ArrayList<String> clases;
		Manejador m = Manejador.getInstancia();
		clases = m.obtenerClases();
		String[] Lclases = new String[clases.size()];
		int i = 0;
		for (String c:clases) {
			Lclases[i]=c;
			i++;
		}
		return Lclases;
	}
	
	public String[] listarActividades(String nombre) {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> actividades = m.listarActdeIns(nombre);
		String[] act = new String[actividades.size()];
		int i = 0;
		for (String ad:actividades) {
			act[i]=ad;
			i++;
		}
		return act;
	}
	
	public void altaClase(String nombre, String url, Date fecha, Date fechaReg, Date HoraInicio, String profesor, String actividad) throws ClaseRepetidaException, ErrorFechaException {
		Manejador m = Manejador.getInstancia();
		DtClase nuevaClase = m.buscarClase(nombre);
		if (nuevaClase != null)
			throw new ClaseRepetidaException("La clase de nombre "+ nombre + " ya existe en el Sistema");
        
		//if(fecha.after(new Date()) || fecha.before(new Date()))
		if(fecha.before(new Date()))
    		throw new ErrorFechaException("La fecha es incorrecta");
		Clase c = new Clase(nombre, url, fecha, fechaReg, HoraInicio);
		m.addClase(profesor, c);
		m.addClaseA(actividad, c);
	}

	@Override
	public String[] listarProfesores(String insti) {
		Manejador m = Manejador.getInstancia();
		List<String> lista = m.obtenerProfesoresInst(insti);
		String[] users = new String[lista.size()];
		int i = 0;
		for(String s: lista) {
			users[i] = s;
			i++;
		}
		return users;
	}

}



