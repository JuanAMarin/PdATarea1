package logica;

import java.util.ArrayList;

import datatypes.DtClase;
import interfaces.ICrankingdeclases;
@SuppressWarnings("deprecation")
public class Crankingdeclases implements ICrankingdeclases{

	public Crankingdeclases() {
		super();
	}
	
	public ArrayList<Object[]> obtRankClases() {
		Manejador m = Manejador.getInstancia();
		ArrayList<DtClase> dtc = m.obtRankClases();
		ArrayList<Object[]> r = new ArrayList<>();
		int i = 1;
		for(DtClase dt: dtc) {
			Object[] o = {i,dt.getNombre(),dt.getUrl(),dt.getFecha().getDate()+"-"+(dt.getFecha().getMonth()+1)+"-"+(dt.getFecha().getYear()+1900)};
			r.add(o);
			i++;
		}
		return r;
	}

}

