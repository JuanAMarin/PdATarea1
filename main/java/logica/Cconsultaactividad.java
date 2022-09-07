package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDep;
import datatypes.DtClase;
import interfaces.ICconsultaactividad;

public class Cconsultaactividad implements ICconsultaactividad{	
	
	private DtActividadDep dtad;
	
	public Cconsultaactividad() {
		super();
	}

	public DtActividadDep getDtad() {
		return dtad;
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
	
	public void buscarActividad(String actividad){
		Manejador m = Manejador.getInstancia();
		dtad = m.buscarActividad(actividad);
	}

	public ArrayList<Object[]> listarClases(String actividad) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.listarClasesDeAct(actividad);
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtClase dt: dtc) {
			Object[] o = {dt.getNombre(), dt.getUrl(), dt.getFecha(), dt.getFechaReg(), dt.getHoraInicio()};
			r.add(o);
		}
		return r;
	}
	
}
