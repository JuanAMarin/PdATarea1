package logica;
import java.util.*;

public class ManejadorInstituciones {
	
	private static ManejadorInstituciones instancia;
	Map<String,InstitucionDep> instituciones = new HashMap<String,InstitucionDep>();
	
	public static ManejadorInstituciones getInstancia() {
        if (instancia == null) {
        	instancia = new ManejadorInstituciones();
        }
        return instancia;
    }
	
	public InstitucionDep buscarInstitucion(String nombre) {
		InstitucionDep retorno=null;
		for (InstitucionDep aux : instituciones.values()) {
			if(aux.getNombre().equals(nombre))
				retorno=aux;
		}
		return retorno;		
	}
	
	public void agregarInstitucion(InstitucionDep ins) { 
		instituciones.put(ins.getNombre(), ins);
	}
	
	public ArrayList<String> obtenerInstituciones(){
		ArrayList<String> retorno = new ArrayList<>();
		for(InstitucionDep aux: instituciones.values()) {
			retorno.add(aux.getNombre());
		}
		return retorno;
	}
}
