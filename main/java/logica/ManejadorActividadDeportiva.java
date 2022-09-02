package logica;

import java.util.ArrayList;
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
		ActividadDep aretornar=null;
		for(ActividadDep a: actividades) {
			if (a.getNombre().equals(nombre))
				aretornar=a;
		}
		return aretornar;
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
}
