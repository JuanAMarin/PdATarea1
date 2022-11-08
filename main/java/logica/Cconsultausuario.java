package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDep;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import interfaces.ICconsultausuario;
@SuppressWarnings("deprecation")
public class Cconsultausuario implements ICconsultausuario{
	
	private DtSocio socio;
	private DtProfesor profesor;
	
	public Cconsultausuario() {
		super();
	}
	
	public DtSocio getSocioDT() {
		return socio;
	}
	public DtProfesor getProfesorDT() {
		return profesor;
	}

	@Override
	public String[] listarUsuarios() {
		Manejador mU = Manejador.getInstancia();
		List<String> lista = mU.listarUsuarios();
		String[] users = new String[lista.size()];
		int i = 0;
		for(String s: lista) {
			users[i] = s;
			i++;
		}
		return users;
	}
	
	public ArrayList<Object[]> listarClasesP(String nickname) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.buscarClases(m.listarClasesDeProf(nickname));
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtClase dt: dtc) {
			Object[] o = {dt.getNombre(), dt.getUrl(), 
					(dt.getFecha().getYear()+1900)+"-"+(dt.getFecha().getMonth()+1)+"-"+dt.getFecha().getDate(), 
					dt.getFechaReg(), dt.getHoraInicio().getHours()+":"+dt.getHoraInicio().getMinutes()};
			r.add(o);
		}
		return r;
	}
	
	public ArrayList<Object[]> listarClasesA(String nombre) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.buscarClases(m.listarClasesDeAct(nombre));
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtClase dt: dtc) {
			Object[] o = {dt.getNombre(), dt.getUrl(), 
					(dt.getFecha().getYear()+1900)+"-"+(dt.getFecha().getMonth()+1)+"-"+dt.getFecha().getDate(), 
					dt.getFechaReg(), dt.getHoraInicio().getHours()+":"+dt.getHoraInicio().getMinutes()};
			r.add(o);
		}
		return r;
	}
	
	public ArrayList<Object[]> listarActividades(String nickname) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtActividadDep> dtc = m.buscarActividades(m.listarActividadesDeProf(nickname));
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtActividadDep dt: dtc) {
			Object[] o = {dt.getNombre(), dt.getDescripcion(), dt.getDuracion(), dt.getCosto(), dt.getFechaReg()};
			r.add(o);
		}
		return r;
	}
	
	public ArrayList<Object[]> listarClasesS(String nickname) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.buscarClases(m.listarClasesDeSoci(nickname));
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtClase dt: dtc) {
			Object[] o = {dt.getNombre(), dt.getUrl(), 
					(dt.getFecha().getYear()+1900)+"-"+(dt.getFecha().getMonth()+1)+"-"+dt.getFecha().getDate(), 
					dt.getFechaReg(), dt.getHoraInicio().getHours()+":"+dt.getHoraInicio().getMinutes()};
			r.add(o);
		}
		return r;
	}
	
	public ArrayList<Object[]> listarRegistros(String clase) {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtRegistro> dtc = m.buscarRegistrosC(clase);
		ArrayList<Object[]> r = new ArrayList<>();
		for(DtRegistro dt: dtc) {
			Object[] o = {dt.getNickname(), dt.getFecha()};
			r.add(o);
		}
		return r;
	}
	
	public DtProfesor buscarProfesor(String nickname) {
		Manejador mU = Manejador.getInstancia();
		return mU.buscarProfesor(nickname);
	}
	
	public DtSocio buscarSocio(String nickname) {
		Manejador mU = Manejador.getInstancia();
		return mU.buscarSocio(nickname);
	}

	public void buscarUsuario(String nickname) {
		Manejador m = Manejador.getInstancia();
		socio = m.buscarSocio(nickname);
		profesor = m.buscarProfesor(nickname);
	}
	
}

