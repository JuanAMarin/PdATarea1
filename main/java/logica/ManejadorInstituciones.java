package logica;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstituciones {
	
	private static ManejadorInstituciones instancia = null;
	
	private ManejadorInstituciones(){};
	
	public static ManejadorInstituciones getInstancia() {
        if (instancia == null) {
        	instancia = new ManejadorInstituciones();
        }
        return instancia;
    }
	
	public InstitucionDep buscarInstitucion(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
			InstitucionDep insti = em.find(InstitucionDep.class, nombre);
		return insti;
	}
	
	public void agregarInstitucion(InstitucionDep ins) { 
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			
			em.persist(ins);
			
			em.getTransaction().commit();
	}
	
	public void agregarActividad(ActividadDep actividadDep, InstitucionDep insti) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		insti.getActividades().add(actividadDep);
		em.getTransaction().begin();
		em.persist(insti);
		em.getTransaction().commit();
	}
	
	public ArrayList<String> obtenerInstituciones(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select insti from InstitucionDep insti");
		List<InstitucionDep> listInsti = (List<InstitucionDep>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(InstitucionDep insti: listInsti) {
			aRetornar.add(insti.getNombre());
		}
		return aRetornar;
	}
	
	public void modificarInsti(String nombre, String descripcion, String url) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		InstitucionDep insti = em.find(InstitucionDep.class,nombre);
		insti.setNombre(nombre);
		insti.setDescripcion(descripcion);
		insti.setUrl(url);
		em.getTransaction().begin();
		em.merge(insti);
		em.getTransaction().commit();
	}
}

