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
	
	public Usuario buscarInstitucion(String nombre) {
		return usuarios.get(nombre);
	}
	
	public void agregarUsuario(Usuario usu) {
		usuarios.putIfAbsent(usu.nickname, usu);
	}
}
