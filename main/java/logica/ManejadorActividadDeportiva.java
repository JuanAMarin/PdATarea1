package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorActividadDeportiva {
	private static ManejadorActividadDeportiva instancia = null;
	private List<ActividadDep> actividades = new ArrayList<>();
	
	private ManejadorActividadDeportiva() {}
	
	public static ManejadorActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new ManejadorActividadDeportiva();
		return instancia;
	}
	
	public void agregarActividad(ActividadDep actividadDep) {
		actividades.add(actividadDep);
	}
	
	public ActividadDep buscarActividad(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(ActividadDep.class, nombre);
	}
	
	public void eliminarActividad(String nombre) {
		ActividadDep aEliminar= buscarActividad(nombre);
		actividades.remove(aEliminar);
	}

	
	public ArrayList<String> listarActdeIns(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a.nombre from InstitucionDep i inner join i.actividades a where i.nombre ='"+nombre+"'");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> obtenerActividades() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a.nombre from InstitucionDep i inner join i.actividades a");
		return (ArrayList<String>) query.getResultList();
	}
	
	public void modificarAD(String nombre, String descripcion, Integer duracion, float costo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		ActividadDep actividadDep = em.find(ActividadDep.class, nombre);
		actividadDep.setNombre(nombre);
		actividadDep.setDescripcion(descripcion);
		actividadDep.setDuracion(duracion);
		actividadDep.setCosto(costo);
		em.getTransaction().begin();
		em.merge(actividadDep);
		em.getTransaction().commit();
	}
}
