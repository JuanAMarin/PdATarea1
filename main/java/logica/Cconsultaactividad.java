package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDep;
import datatypes.DtClase;
import datatypes.DtRegistro;
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

	public ArrayList<String> listarClasesN(String actividad) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.buscarClases(m.listarClasesDeAct(actividad));
		ArrayList<String> c = new ArrayList<>();
		for(DtClase dt: dtc) {
			c.add(dt.getNombre());
		}
		return c;
	}
	
	public ArrayList<Object[]> listarClases(String actividad) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.buscarClases(m.listarClasesDeAct(actividad));
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtClase dt: dtc) {
			@SuppressWarnings("deprecation")
			Object[] o = {dt.getNombre(), dt.getUrl(), 
					(dt.getFecha().getYear()+1900)+"-"+(dt.getFecha().getMonth()+1)+"-"+dt.getFecha().getDate(), 
					dt.getFechaReg(), 
					dt.getHoraInicio().getHours()+":"+dt.getHoraInicio().getMinutes()};
			r.add(o);
		}
		return r;
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
	
	public String buscarProfesorCC(String clase) {
		Manejador m = Manejador.getInstancia();
		return m.buscarProfesorC(clase);
	}
}
