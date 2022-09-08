package logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import interfaces.ICrankingdeclases;
import persistencia.Conexion;

public class Crankingdeclases implements ICrankingdeclases{

	public Crankingdeclases() {
		super();
	}
	
	public List<String> obtenerRankingC(){
		Manejador m = Manejador.getInstancia();
		//return mcla.obtenerRanking();
		List<String> socios = new ArrayList<String>();
		return socios;
	}
	
	/*public List<String> obtInfoClases(String acti){
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
	}*/

}

