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
		InstitucionDep insti;
		insti=instituciones.get(nombre);
		return insti;
		return instituciones.get(nombre);
	}
}
