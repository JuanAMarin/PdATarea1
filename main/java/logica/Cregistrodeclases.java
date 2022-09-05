package logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import interfaces.ICregistrodeclases;
import persistencia.Conexion;

public class Cregistrodeclases implements ICregistrodeclases {
	
	private String insti;
	private String acti;
	
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
	
	public void setInsti(String insti) {
		this.insti = insti;
	}
	
	public void setActi(String acti) {
		this.acti = acti;
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
	
	@Override
	public Clase buscarClase(String clase) {
		ManejadorClases mC = ManejadorClases.getInstancia();
		return mC.buscarClase(clase);
	}
	
	public String[] listarClases(String actividad){
		ArrayList<String> clases = new ArrayList<>();
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		List<Clase> clasesL = mAD.buscarActividad(actividad).getClases();
		Iterator<Clase> it = clasesL.iterator();
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
