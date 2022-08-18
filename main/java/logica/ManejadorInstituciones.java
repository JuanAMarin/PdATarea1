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
		return instituciones.get(nombre);
	}
}
