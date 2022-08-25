package logica;

import java.util.List;

import interfaces.ICrankingdeclases;

public class Crankingdeclases implements ICrankingdeclases{

	public Crankingdeclases() {
		super();
	}
	
	public List<Clase> obtenerClases(){
		ManejadorClases mcla = ManejadorClases.getInstancia();
		return mcla.obtenerClases();
	}
	//Crear la funcion que carge los datos de la base, y ordenar la lista, luego enviarla la presentacion

}
