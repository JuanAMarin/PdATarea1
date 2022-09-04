package logica;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorUsuarios {
	
	private static ManejadorUsuarios instancia = null;
	
	private ManejadorUsuarios(){}
	
    public static ManejadorUsuarios getInstancia() {
        if (instancia == null) {
        	instancia = new ManejadorUsuarios();
        }
        return instancia;
    }
    
    public List<String> listarUsuarios() {
    	List<String> lista = new ArrayList<>();
    	lista = obtenerProfesoresN();
    	lista.addAll(obtenerSociosN());
		return lista;
    }
	
	public void agregarProfesor(Profesor usu) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
	}
	
	public void agregarSocio(Socio usu) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
	}
	
	public Profesor buscarProfesor(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Profesor.class, nickname);
	}
	
	public Socio buscarSocio(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Socio.class, nickname);
	}
	
	public boolean emailRepetido(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u where u.email='"+email+"'");
		List<Usuario> usuarios = query.getResultList();
		return (usuarios.size() != 0);
	}
	
	public boolean nicknameRepetido(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usu = em.find(Usuario.class, nick);
		return (usu != null);
	}
	
	public ArrayList<String> obtenerSociosN(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select s.nickname from Socio s");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> obtenerProfesoresN(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p.nickname from Profesor p");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> obtenerProfesoresInst(String institucion){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p.nickname from Profesor p where p.institucion ='"+institucion+"'");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> obtenerSociosE(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select s.email from Socio s");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> obtenerProfesoresE(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p.email from Profesor p");
		return (ArrayList<String>) query.getResultList();
	}
	
	public void modificarSoc(String nickname, String nombre, String apellido, Date fechaNac) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Socio socio = em.find(Socio.class, nickname);
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setFechaNac(fechaNac);
		em.getTransaction().begin();
		em.merge(socio);
		em.getTransaction().commit();
	}
	
	public void modificarProf(String nickname, String nombre, String apellido, Date fechaNac, String descripcion, String biografia, String sitioweb) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Profesor profesor = em.find(Profesor.class, nickname);
		profesor.setNombre(nombre);
		profesor.setApellido(apellido);
		profesor.setFechaNac(fechaNac);
		profesor.setBiografia(biografia);
		profesor.setDescripcion(descripcion);
		profesor.setSitioweb(sitioweb);
		em.getTransaction().begin();
		em.merge(profesor);
		em.getTransaction().commit();
	}
	
	public void addClase(String profe, Clase clase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Profesor profesor = em.find(Profesor.class, profe);
		profesor.getClases().add(clase);
		em.getTransaction().begin();
		em.persist(profesor);
		em.getTransaction().commit();
	}

}

