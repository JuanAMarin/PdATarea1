package interfaces;

import datatypes.DtActividadDep;
import datatypes.DtClase;
import datatypes.DtInstitucionDep;
import datatypes.DtProfesor;
import datatypes.DtSocio;

public class Acceso {
	
	private static Acceso instancia;
	private DtProfesor p;
	private DtSocio s;
	private DtActividadDep actividad;
	private DtInstitucionDep institucion;
	private DtClase clase;
	private boolean modal;
	private boolean modalErr;
	private boolean ModalAux;
	
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

	public DtClase getclase() {
		return clase;
	}

	public void setclase(DtClase clase) {
		this.clase = clase;
	}
	
	public DtInstitucionDep getInstitucion() {
		return institucion;
	}

	public void setInstitucion(DtInstitucionDep institucion) {
		this.institucion = institucion;
	}
	
	public boolean isModal() {
		return modal;
	}

	public void setModal(boolean modal) {
		this.modal = modal;
	}
	
	public boolean isModalErr() {
		return modalErr;
	}

	public void setModalErr(boolean modalErr) {
		this.modalErr = modalErr;
	}
	
	public boolean isModalAux() {
		return ModalAux;
	}

	public void setModalAux(boolean modalAux) {
		ModalAux = modalAux;
	}

	public void killInstancia() {
		instancia = null;
		this.p = null;
		this.s = null;
		this.actividad = null;
		this.modal = false;
		this.clase = null;
		this.institucion = null;
	}
	
	public boolean pIsNull() {
		return (this.p==null);
	}
	
	public boolean sIsNull() {
		return (this.s==null);
	}
	
	public boolean iIsNull() {
		return (this.institucion==null);
	}
	
	public boolean aIsNull() {
		return (this.actividad==null);
	}
	
	public boolean cIsNull() {
		return (this.clase==null);
	}
	
}
