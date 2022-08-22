package interfaces;
import logica.Caltainstitucion;
import logica.Caltausuario;
import logica.CconsultaUsuario;
import logica.Cmodinstitucion;

public class Fabrica {
	
	private static Fabrica instancia;
	
	public static Fabrica getInstancia() {
        if (instancia == null) {
        	instancia = new Fabrica();
        }
        return instancia;
    }
	
	public ICaltausuario getICaltausuario() {
        return new Caltausuario();
    }
	
	public ICconsultaUsuario getICconsultaUsuario() {
        return new CconsultaUsuario();
    }
	
	public ICaltainstitucion getICaltainstitucion() {
		return new Caltainstitucion();
	}
	
	public ICmodinstitucion getICmodinstitucion() {
		return new Cmodinstitucion();
	}
}

