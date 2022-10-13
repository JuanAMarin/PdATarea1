package interfaces;

import datatypes.DtActividadDep;
import datatypes.DtInstitucionDep;
import datatypes.DtProfesor;
import datatypes.DtSocio;

public class Acceso {
	
	private static Acceso instancia;
	private DtProfesor p;
	private DtSocio s;
	private DtActividadDep actividad;
	private DtInstitucionDep institucion;
	private boolean modal;
	
	public static Acceso getInstancia() {
        if (instancia == null) {
        	instancia = new Acceso();
        }
        return instancia;
    }
	
	public DtProfesor getP() {
		return p;
	}

	public void setP(DtProfesor p) {
		this.p = p;
	}

	public DtSocio getS() {
		return s;
	}

	public void setS(DtSocio s) {
		this.s = s;
	}
	
	public DtActividadDep getActividad() {
		return actividad;
	}

	public void setActividad(DtActividadDep actividad) {
		this.actividad = actividad;
	}

	public boolean isModal() {
		return modal;
	}

	public void setModal(boolean modal) {
		this.modal = modal;
	}

	public DtInstitucionDep getInstitucion() {
		return institucion;
	}

	public void setInstitucion(DtInstitucionDep institucion) {
		this.institucion = institucion;
	}

	public void killInstancia() {
		instancia = null;
		p = null;
		s = null;
		actividad = null;
		modal = false;
	}
}
