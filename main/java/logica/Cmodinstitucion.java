package logica;

import java.util.ArrayList;

import datatypes.DtInstitucionDep;
import interfaces.ICmodinstitucion;

public class Cmodinstitucion implements ICmodinstitucion {

	@Override
	public void modInstitucion(String nombreInstitucion, String descripcion, String url) {
		Manejador m = Manejador.getInstancia();
		m.modificarID(nombreInstitucion, descripcion, url);	
	}

	@Override
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		Manejador m = Manejador.getInstancia();
		instituciones = m.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}

	@Override
	public DtInstitucionDep obtenerInfo(String nombre) {
		Manejador m = Manejador.getInstancia();
		return m.buscarInstitucion(nombre);
	}
	
}
