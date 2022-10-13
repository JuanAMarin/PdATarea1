package interfaces;

import java.util.ArrayList;
import datatypes.DtActividadDep;

public interface ICrankingdeactividades {
	public abstract ArrayList<Object[]> obtRankActividades();
	public ArrayList<DtActividadDep> RankActividadesDT();
	public ArrayList<Object[]> obtRankActividadesO(ArrayList<DtActividadDep> a);
}