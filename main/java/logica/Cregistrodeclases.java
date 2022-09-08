package logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtClase;
import interfaces.ICregistrodeclases;
import persistencia.Conexion;

public class Cregistrodeclases implements ICregistrodeclases {
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
	
	@Override
	public DtClase buscarClase(String clase) {
		Manejador m = Manejador.getInstancia();
		return m.buscarClase(clase);
	}
	
	public String[] listarClases(String actividad){
		ArrayList<String> clases = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		List<DtClase> clasesL = m.buscarClases(m.listarClasesDeAct(actividad));
		Iterator<DtClase> it = clasesL.iterator();
		while(it.hasNext()) {
			clases.add(it.next().getNombre());
		}
		String[] cla = new String[clases.size()];
		int i = 0;
		for (String ad:clases) {
			cla[i]=ad;
			i++;
		}
		return cla;	
	}
	
	public String[] listarSocios() {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> socios = m.obtenerSociosN();
		String[] soc = new String[socios.size()];
		int i = 0;
		for (String so:socios) {
			soc[i]=so;
			i++;
		}
		return soc;	
	}

	
	public List<String> obtInfoClases(String acti){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select * from Clase");
		List<Clase> listClases = (List<Clase>) query.getResultList();
		ArrayList<Integer> orden = new ArrayList<>();
		for(Clase c: listClases) {
			orden.add(c.getRegistros().size());
		}
		orden.sort(Comparator.naturalOrder());
		Iterator<Integer> it = orden.iterator();
		List<String> ranking = new ArrayList<>();
	    while(it.hasNext()) {
			for(Clase c: listClases) {
				if((Integer)c.getRegistros().size()==it.next()) {
					ranking.add(c.getNombre());
					ranking.add(c.getFecha().getDay()+"/"+c.getFecha().getMonth()+"/"+c.getFecha().getYear());
					ranking.add(c.getUrl());
					ranking.add("");
					listClases.remove(c);
				}
			}
	    }
		return ranking;
	}
	
	
	
}
