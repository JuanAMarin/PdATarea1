package logica;

import java.util.*;

public class ManejadorInstituciones {
	Map<String,InstitucionDep> instituciones = new HashMap<String,InstitucionDep>();
	
	public InstitucionDep buscarInstitucion(String nombre) {
		InstitucionDep insti;
		insti=instituciones.get(nombre);
		return insti;
	}
}
