package logica;
import java.util.*;

public class ManejadorUsuarios {
	
	private static ManejadorUsuarios instancia;
	Map<String,Usuario> usuarios = new HashMap<String,Usuario>();
	
    public static ManejadorUsuarios getInstancia() {
        if (instancia == null) {
        	instancia = new ManejadorUsuarios();
        }
        return instancia;
    }
	
	public void agregarUsuario(Usuario usu) {
		usuarios.putIfAbsent(usu.nickname + usu.email, usu);
	}
	
	public Usuario buscarUsuario(String key) {
		Usuario usu = usuarios.get(key);
		return usu;
	}
	
	public Usuario buscarxNick(String nick) {
		Iterator<Map.Entry<String, Usuario>> itr = usuarios.entrySet().iterator();
		boolean salir = false;
		Usuario usu = null;
        while(itr.hasNext() && salir == false) {
        	Map.Entry<String, Usuario> entry = itr.next();
        	if(nick.equals(entry.getValue().getNickname())) {
        		salir = true;
        		usu = entry.getValue();
        	}
        }
        return usu;
	}
	
	public ArrayList<String> obtenerUsuarios(){
		ArrayList<String> retorno = new ArrayList<>();
		for(Usuario aux: usuarios.values()) {
			retorno.add(aux.getNombre());
		}
		return retorno;
	}

}
