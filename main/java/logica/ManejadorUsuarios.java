package logica;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;
import persistencia.UsuarioID;

public class ManejadorUsuarios {
	
	private static ManejadorUsuarios instancia = null;
	
	private ManejadorUsuarios(){}
	
    public static ManejadorUsuarios getInstancia() {
        if (instancia == null) {
        	instancia = new ManejadorUsuarios();
        }
        return instancia;
    }
	
	public void agregarUsuario(Usuario usu) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(usu);
		
		em.getTransaction().commit();
	}
	
	public Profesor buscarProfesor(UsuarioID key) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
			Profesor prof = em.find(Profesor.class, key);
		return prof;
	}
	
	public Socio buscarSocio(UsuarioID key) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
			Socio socio = em.find(Socio.class, key);
		return socio;
	}
	
	public boolean emailRepetido(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select email from Profesor union select email from Socio");
		List<String> listEmail = (List<String>) query.getResultList(); 
		return listEmail.equals(email);
	}
	
	public boolean nicknameRepetido(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select nickname from Profesor union select nickname from Socio");
		List<String> listNick = (List<String>) query.getResultList(); 
		return listNick.equals(nick);
	}
	
	public ArrayList<String> obtenerSocios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from Socio s");
		List<Socio> listSocio = (List<Socio>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Socio s: listSocio) {
			aRetornar.add(s.getNickname());
		}
		return aRetornar;
	}
	
	public ArrayList<String> obtenerProfesores(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select p from Profesor p");
		List<Profesor> listProfesor = (List<Profesor>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Profesor p: listProfesor) {
			aRetornar.add(p.getNickname());
		}
		return aRetornar;
	}

}
