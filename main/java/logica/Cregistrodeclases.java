package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import datatypes.DtClase;
import exceptions.ClaseRepetidaException;
import exceptions.SocioYaRegistradoException;
import exceptions.UsuarioRepetidoException;
import interfaces.ICregistrodeclases;

public class Cregistrodeclases implements ICregistrodeclases {
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		Manejador m = Manejador.getInstancia();
		instituciones = m.obtenerInstituciones();
		String[] inst = new String[instituciones.size()];
		int i = 0;
		for (String ins:instituciones) {
			inst[i]=ins;
			i++;
		}
		return inst;
	}
		
	public String[] listarActividades(String nombre) {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> actividades = m.listarActdeIns(nombre);
		String[] act = new String[actividades.size()];
		int i = 0;
		for (String ad:actividades) {
			act[i]=ad;
			i++;
		}
		return act;
	}
	
	@Override
	public DtClase buscarClase(String clase) {
		Manejador m = Manejador.getInstancia();
		return m.buscarClase(clase);
	}
	
	public String[] listarClases(String actividad){
		ArrayList<String> clases = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		List<DtClase> clasesL = m.buscarClases(m.listarClasesDeAct(actividad));
		Iterator<DtClase> it = clasesL.iterator();
		while(it.hasNext()) {
			clases.add(it.next().getNombre());
		}
		String[] cla = new String[clases.size()];
		int i = 0;
		for (String ad:clases) {
			cla[i]=ad;
			i++;
		}
		return cla;	
	}
	
	public String[] listarSocios() {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> socios = m.obtenerSociosN();
		String[] soc = new String[socios.size()];
		int i = 0;
		for (String so:socios) {
			soc[i]=so;
			i++;
		}
		return soc;	
	}
	
	public void Registro (String clase, String socio) throws SocioYaRegistradoException{
		Manejador m = Manejador.getInstancia();
		if(m.classTieneSocio(clase, socio)) {
			throw new SocioYaRegistradoException("Ya hay un registro de "+ socio + " a la clase: "+ clase +".");
		}else
			m.addRegistro(clase, socio);
	}
	
}
