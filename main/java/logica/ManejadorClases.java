package logica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorClases {
	
	private static ManejadorClases instancia = null;
	
	private ManejadorClases(){}
	
	public static ManejadorClases getInstancia() {
		if (instancia == null)
			instancia = new ManejadorClases();
		return instancia;
	}
	
	public void agregarClase(Clase clase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(clase);
		
		em.getTransaction().commit();
	}
	
	public Clase buscarClase(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
			Clase clase = em.find(Clase.class, nombre);
		return clase;
	}
	
	public List<Clase> listarClasesDeAct(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c from ActividadDep a inner join a.clases c where a.nombre ='"+nombre+"'");
		return (List<Clase>) query.getResultList();
	}
	
	/*public List<String> obtenerRanking(){
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

