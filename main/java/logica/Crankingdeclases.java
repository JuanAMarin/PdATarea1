package logica;

import java.util.ArrayList;

import datatypes.DtClase;
import interfaces.ICrankingdeclases;
@SuppressWarnings("deprecation")
public class Crankingdeclases implements ICrankingdeclases{

	public Crankingdeclases() {
		super();
	}
	
	public ArrayList<DtClase> obtRankClasesDT() {
		Manejador m = Manejador.getInstancia();
		return m.obtRankClases();
	}
	
	public ArrayList<Object[]> obtRankClasesO(ArrayList<DtClase> a) {
		ArrayList<Object[]> r = new ArrayList<>();
		int i = 1;
		for(DtClase dt: obtRankClasesDT()) {
			Object[] o = {i,dt.getNombre(),dt.getUrl(),dt.getFecha().getDate()+"-"+(dt.getFecha().getMonth()+1)+"-"+(dt.getFecha().getYear()+1900)};
			r.add(o);
			i++;
		}
		return r;
	}
	
	public ArrayList<Object[]> obtRankClases() {
		return obtRankClasesO(obtRankClasesDT());
	}
	
	public ArrayList<Integer> obtCantRegistros(){
		Manejador m = Manejador.getInstancia();
		return m.obtCantRegistros();
	}
}

