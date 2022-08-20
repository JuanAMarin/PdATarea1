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
}
