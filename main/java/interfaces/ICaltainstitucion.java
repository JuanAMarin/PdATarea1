package interfaces;

import exceptions.InstitucionRepetidaException;

public interface ICaltainstitucion {
	public abstract void altaInstitucion(String nombreInstitucion, String descripcion, String url) throws InstitucionRepetidaException;
}
