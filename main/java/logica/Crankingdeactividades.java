package logica;

import java.util.ArrayList;

import datatypes.DtActividadDep;
import interfaces.ICrankingdeactividades;

public class Crankingdeactividades implements ICrankingdeactividades {

	
	public Crankingdeactividades() {
		super();
	}
	
	@Override
	public ArrayList<DtActividadDep> RankActividadesDT() {
		Manejador m = Manejador.getInstancia();
		return m.obtRankActividades();
	}
	
	@Override
	public ArrayList<Object[]> obtRankActividadesO(ArrayList<DtActividadDep> a) {
		ArrayList<Object[]> r = new ArrayList<>();
		int i = 1;
		for(DtActividadDep dt: a) {
			Object[] o = {i,dt.getNombre(),dt.getCosto(),dt.getDescripcion()};
			r.add(o);
			i++;
		}
		return r;
	}
	
	@Override
	public ArrayList<Object[]> obtRankActividades() {
		return obtRankActividadesO(RankActividadesDT());
	}
	
}
