package interfaces;

import datatypes.DtActividadDep;
import datatypes.DtInstitucionDep;
import logica.Profesor;
import logica.Socio;

public class Acceso {
	
	private static Acceso instancia;
	private Profesor p;
	private Socio s;
	private DtActividadDep actividad;
	private DtInstitucionDep institucion;
	private boolean modal;
	
	public static Acceso getInstancia() {
        if (instancia == null) {
        	instancia = new Acceso();
        }
        return instancia;
    }
	
	public Profesor getP() {
		return p;
	}

	public void setP(Profesor p) {
		this.p = p;
	}

	public Socio getS() {
		return s;
	}

	public void setS(Socio s) {
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
