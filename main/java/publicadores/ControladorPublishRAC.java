package publicadores;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDep;
import datatypes.DtClase;
import interfaces.Fabrica;
import interfaces.ICrankingdeactividades;
import interfaces.ICrankingdeclases;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishRAC {
	private Fabrica f;
	private ICrankingdeactividades ICra;
	private ICrankingdeclases ICrc;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublishRAC() {
		f = Fabrica.getInstancia();
		ICra = f.getICrankingdeactividades();
		ICrc = f.getICrankingdeclases();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRAC", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRAC");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Ranking de Actividades, Clases
	@WebMethod
	public DtActividadDep[] RankActividadesDT() {
		ArrayList<DtActividadDep> arr = ICra.RankActividadesDT();
		DtActividadDep[] rank = new DtActividadDep[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			rank[i]=arr.get(i);
		}
		return rank;
	}
	@WebMethod
	public Integer[] obtCantClases() {
		ArrayList<Integer> arr = ICra.obtCantClases();
		Integer[] puntosRank = new Integer[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			puntosRank[i]=arr.get(i);
		}
		return puntosRank;
	}
	@WebMethod
	public DtClase[] obtRankClasesDT() {
		ArrayList<DtClase> arr = ICrc.obtRankClasesDT();
		DtClase[] rank = new DtClase[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			rank[i]=arr.get(i);
		}
		return rank;
	}
	@WebMethod
	public Integer[] obtCantRegistros() {
		ArrayList<Integer> arr = ICrc.obtCantRegistros();
		Integer[] puntosRank = new Integer[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			puntosRank[i]=arr.get(i);
		}
		return puntosRank;
	}
}
