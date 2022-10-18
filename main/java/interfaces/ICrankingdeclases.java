package interfaces;

import java.util.ArrayList;

import datatypes.DtClase;

public interface ICrankingdeclases {
	public abstract ArrayList<Object[]> obtRankClases();
	public ArrayList<DtClase> obtRankClasesDT();
	public ArrayList<Object[]> obtRankClasesO(ArrayList<DtClase> a);
	public ArrayList<Integer> obtCantRegistros();
}