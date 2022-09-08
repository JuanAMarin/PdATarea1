package logica;

import java.util.List;

import interfaces.ICrankingdeclases;

public class Crankingdeclases implements ICrankingdeclases{

	public Crankingdeclases() {
		super();
	}
	
	public List<String> obtRankClasesC(){
		Manejador m = Manejador.getInstancia();
		return m.obtRankClases();
	}

}

