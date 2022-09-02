package logica;

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
	
	public List<Clase> obtenerClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select * from Clase");
		List<Clase> listClases = (List<Clase>) query.getResultList();
		
		return listClases;
	}
}
