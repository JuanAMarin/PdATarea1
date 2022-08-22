package interfaces;
import logica.Caltainstitucion;
import logica.Caltausuario;
import logica.Cconsultausuario;
import logica.Cmodinstitucion;
import logica.Cmodusuario;
import logica.Crankingdeclases;

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
        return new Cconsultausuario();
    }
	
	public ICaltainstitucion getICaltainstitucion() {
		return new Caltainstitucion();
	}
	
	public ICmodinstitucion getICmodinstitucion() {
		return new Cmodinstitucion();
	}
	
	public ICrankingdeclases getICrankingdeclases() {
		return new Crankingdeclases();
	}
	public ICmodusuario getICmodusuario() {
		return new Cmodusuario();
	}

}

