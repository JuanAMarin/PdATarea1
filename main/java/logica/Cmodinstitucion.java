package logica;

import java.util.ArrayList;

import interfaces.ICmodinstitucion;

public class Cmodinstitucion implements ICmodinstitucion {

	@Override
	public void modInstitucion(String nombreInstitucion, String descripcion, String url) {
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		mI.modificarInsti(nombreInstitucion,descripcion,url);
	}

	@Override
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		instituciones = mI.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}

	@Override
	public InstitucionDep obtenerInfo(String nombre) {
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		InstitucionDep aux=mI.buscarInstitucion(nombre);
		return aux;
	}
	
}
