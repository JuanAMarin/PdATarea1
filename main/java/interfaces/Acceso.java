package interfaces;

import logica.Profesor;
import logica.Socio;

public class Acceso {
	
	private static Acceso instancia;
	private Profesor p;
	private Socio s;
	
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

	public void killInstancia() {
		instancia = null;
		p = null;
		s = null;
	}
}
