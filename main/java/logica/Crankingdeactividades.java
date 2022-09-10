package logica;

import java.util.ArrayList;

import datatypes.DtActividadDep;
import datatypes.DtClase;
import interfaces.ICrankingdeactividades;

public class Crankingdeactividades implements ICrankingdeactividades {

	
	public Crankingdeactividades() {
		super();
	}
	
	@Override
	public ArrayList<Object[]> obtRankActividades() {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtActividadDep> dtad = m.obtRankActividades();
		ArrayList<Object[]> r = new ArrayList<>();
		int i = 1;
		for(DtActividadDep dt: dtad) {
			Object[] o = {i,dt.getNombre(),dt.getCosto(),dt.getDescripcion()};
			r.add(o);
			i++;
		}
		return r;
	}

	
}
