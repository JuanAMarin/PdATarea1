package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorClases {
	private static ManejadorClases instancia = null;
	private List<Clase> clases = new ArrayList<>();
	
	private ManejadorClases(){}
	
	public static ManejadorClases getInstancia() {
		if (instancia == null)
			instancia = new ManejadorClases();
		return instancia;
	}
	
	public void agregarClase(Clase clase) {
		clases.add(clase);
	}
	
	public Clase buscarClase(String nombre) {
		Clase aretornar=null;
		for(Clase c: clases) {
			if (c.getNombre() == nombre)
				aretornar=c;
		}
		return aretornar;
	}
}
