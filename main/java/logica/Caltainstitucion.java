package logica;

import datatypes.DtInstitucionDep;
import exceptions.InstitucionRepetidaException;
import interfaces.ICaltainstitucion;

public class Caltainstitucion implements ICaltainstitucion {

	@Override
	public void altaInstitucion(String nombreInstitucion, String descripcion, String url) throws InstitucionRepetidaException {
		InstitucionDep institucion = new InstitucionDep(nombreInstitucion, descripcion, url);
		Manejador m = Manejador.getInstancia();
		DtInstitucionDep aux=m.buscarInstitucion(nombreInstitucion);
		if(aux!=null && aux.getNombre().equals(nombreInstitucion)) {
			throw new InstitucionRepetidaException("La Institucion de nombre "+ aux.getNombre() + " ya existe en el Sistema");
		}
		aux=null;
		m.agregarInstitucion(institucion);
	}

}
