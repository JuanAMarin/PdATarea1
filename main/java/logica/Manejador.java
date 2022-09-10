package logica;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtActividadDep;
import datatypes.DtClase;
import datatypes.DtInstitucionDep;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import persistencia.Conexion;

@SuppressWarnings("unchecked")
public class Manejador {
	
	private static Manejador instancia = null;
	
	private Manejador(){}
	
    public static Manejador getInstancia() {
        if (instancia == null) {
        	instancia = new Manejador();
        }
        return instancia;
    }
    
    //Usuarios
    
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
	
	public DtProfesor buscarProfesor(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Profesor.class, nickname) != null)
			return em.find(Profesor.class, nickname).getDT();
		return null;	 
		
	}
	
	public DtSocio buscarSocio(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Socio.class, nickname) != null)
			return em.find(Socio.class, nickname).getDT();
		return null;	
	}
	
	public DtUsuario buscarUsuario(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nickname) != null)
			return em.find(Usuario.class, nickname).getDT();
		return null;	
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
	
	//Clases
	
	public void addClase(String profe, Clase clase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Profesor profesor = em.find(Profesor.class, profe);
		profesor.getClases().add(clase);
		em.getTransaction().begin();
		em.persist(profesor);
		em.getTransaction().commit();
	}
	
	public ArrayList<DtClase> buscarClases(ArrayList<String> clases) {
		ArrayList<DtClase> ret = new ArrayList<>();
		for(String c: clases) {
			ret.add(buscarClase(c));
		}
		return ret;
	}
	
	public ArrayList<String> listarClasesDeAct(String actividad) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c.nombre from ActividadDep a inner join a.clases c where a.nombre ='"+actividad+"'");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> listarClasesDeProf(String profesor) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c.nombre from Profesor p inner join p.clases c where p.nickname ='"+profesor+"'");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> listarActividadesDeProf(String profesor) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a.nombre from Profesor p inner join p.institucion i inner join i.actividades a where p.nickname ='"+profesor+"'");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> listarClasesDeSoci(String socio) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c.nombre from Socio s inner join s.registros r inner join r.clase c where s.nickname = '"+socio+"'");
		return (ArrayList<String>) query.getResultList();
	}
	
	public ArrayList<String> obtenerClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select clas from Clase clas");
		List<Clase> listclas = (List<Clase>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Clase clas: listclas) {
			aRetornar.add(clas.getNombre());
		}
		return aRetornar;
	}
	
	public void agregarClase(Clase clase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(clase);
		em.getTransaction().commit();
	}
	
	public DtClase buscarClase(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Clase.class, nombre) != null)
			return em.find(Clase.class, nombre).getDT();
		return null;
	}
	
	public void addClaseA (String actividad, Clase clase) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		ActividadDep act=em.find(ActividadDep.class, actividad);
		act.addClase(clase);
		em.getTransaction().begin();
		em.persist(act);
		em.getTransaction().commit();
	}
	
	public ArrayList<DtClase> obtRankClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c from Clase c order by size(c.registros) desc");
		ArrayList<DtClase> ret = new ArrayList<>();
		for(Clase c:(List<Clase>) query.getResultList())
			ret.add(c.getDT());
		return ret;
	}
	
	public ArrayList<DtActividadDep> obtRankActividades(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a from ActividadDep a order by size(a.clases) desc");
		ArrayList<DtActividadDep> ret = new ArrayList<>();
		for(ActividadDep a:(List<ActividadDep>) query.getResultList())
			ret.add(a.getDT());
		return ret;
	}
	
	public void agregarActividad(ActividadDep actividadDep, String insti) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		InstitucionDep inst = em.find(InstitucionDep.class, insti);
		inst.getActividades().add(actividadDep);
		em.getTransaction().begin();
		em.persist(inst);
		em.getTransaction().commit();
	}
	
	public ArrayList<DtActividadDep> buscarActividades(ArrayList<String> actividades) {
		ArrayList<DtActividadDep> ret = new ArrayList<>();
		for(String c: actividades) {
			ret.add(buscarActividad(c));
		}
		return ret;
	}
	
	public DtActividadDep buscarActividad(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(ActividadDep.class, nombre)!= null)
			return em.find(ActividadDep.class, nombre).getDT();
		return null;
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
	
	//Instituciones
	
	public DtInstitucionDep buscarInstitucion(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(InstitucionDep.class, nombre)!= null)
			return em.find(InstitucionDep.class, nombre).getDT();
		return null;
	}
	
	public void agregarInstitucion(InstitucionDep ins) { 
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.persist(ins);
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
	
	public void modificarID(String nombre, String descripcion, String url) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		InstitucionDep institucionDep = em.find(InstitucionDep.class, nombre);
		institucionDep.setDescripcion(descripcion);
		institucionDep.setUrl(url);
		em.getTransaction().begin();
		em.merge(institucionDep);
		em.getTransaction().commit();
	}
	
	//REGISTRO
	
	public ArrayList<DtRegistro> buscarRegistrosC(String clase) {
		ArrayList<DtRegistro> ret = new ArrayList<>();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Clase clas = em.find(Clase.class, clase);
		for(Registro r:clas.getRegistros()) {
			ret.add(r.getDT());
		}
		return ret;
	}
	
	public boolean classTieneSocio(String clase, String socio) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Clase clas = em.find(Clase.class, clase);
		for(Registro r:clas.getRegistros()) {
			if(r.getSocio().getNickname().compareTo(socio)==0) {
				return true;
			}
		}
		return false;
	}
	
	public void addRegistro(String clase, String socio) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Clase clas = em.find(Clase.class, clase);
		Socio soc = em.find(Socio.class, socio);
		Registro r= new Registro(soc,clas);
		soc.addRegistro(r);
		clas.addRegistro(r);
		em.getTransaction().begin();
		em.persist(soc);
		em.persist(clas);
		em.getTransaction().commit();
	}
	
}

