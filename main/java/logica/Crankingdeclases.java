package logica;

import java.util.List;

import interfaces.ICrankingdeclases;

public class Crankingdeclases implements ICrankingdeclases{

	public Crankingdeclases() {
		super();
	}
	
	public List<String> obtenerRankingC(){
		ManejadorClases mcla = ManejadorClases.getInstancia();
		return mcla.obtenerRanking();
	}

}
