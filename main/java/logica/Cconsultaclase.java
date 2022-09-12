package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtClase;
import datatypes.DtRegistro;
import interfaces.ICconsultaclase;

public class Cconsultaclase implements ICconsultaclase{	
	
	private DtClase dtc;
	
	public Cconsultaclase() {
		super();
	}

	public DtClase getDtad() {
		return dtc;
	}

	public String[] listarInstituciones() {
		Manejador m = Manejador.getInstancia();
		List<String> l = m.obtenerInstituciones();
		String[] insti = new String[l.size()];
		int i = 0;
		for(String s: l) {
			insti[i] = s;
			i++;
		}
		return insti;
	}

	public String[] listarActividades(String institucion) {
		Manejador m = Manejador.getInstancia();
		List<String> l = m.listarActdeIns(institucion);
		String[] activ = new String[l.size()];
		int i = 0;
		for(String s: l) {
			activ[i] = s;
			i++;
		}
		return activ;
	}
	
	public String[] listarClases(String actividad) {
		Manejador m = Manejador.getInstancia();
		List<String> l = m.listarClasesDeAct(actividad);
		String[] clas = new String[l.size()];
		int i = 0;
		for(String s: l) {
			clas[i] = s;
			i++;
		}
		return clas;
	}
	
	public void buscarClase(String clase){
		Manejador m = Manejador.getInstancia();
		dtc = m.buscarClase(clase);
	}

	public ArrayList<Object[]> listarRegistros(String clase) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtRegistro> dtr = m.buscarRegistrosC(clase);
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtRegistro dt: dtr) {
			Object[] o = {dt.getNickname(),dt.getFecha()};
			r.add(o);
		}
		return r;
	}
	
	public String buscarProfesorCC(String clase){
		Manejador m = Manejador.getInstancia();
		return m.buscarProfesorC(clase);
	}
}
