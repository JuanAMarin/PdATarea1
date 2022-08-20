package interfaces;
import logica.Caltausuario;
import logica.CconsultaUsuario;

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
}
