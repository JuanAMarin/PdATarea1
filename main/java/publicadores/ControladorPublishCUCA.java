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
import interfaces.ICconsultaactividad;
import interfaces.ICconsultaclase;
import interfaces.ICconsultausuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishCUCA {
	private Fabrica f;
	private ICconsultausuario ICcu;
	private ICconsultaclase ICcc;
	private ICconsultaactividad ICca;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublishCUCA() {
		f = Fabrica.getInstancia();
		ICcu = f.getICconsultausuario();
		ICcc = f.getICconsultaclase();
		ICca = f.getICconsultaactividad();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorCUCA", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorCUCA");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Consulta Usuario, Actividad, Clase
	@WebMethod
	public String[] listarClasesS(String s) {
		ArrayList<Object[]> arr = ICcu.listarClasesS(s);
		String[] clases = new String[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			Object[] o = arr.get(i);
			clases[i]=(String) o[0];
		}
		return clases;
	}
	@WebMethod
	public void buscarClase(String c) {
		ICcc.buscarClase(c);
	}
	@WebMethod
	public DtClase getDtc() {
		return ICcc.getDtc();
	}
	@WebMethod
	public String[] listarActividadesP(String p) {
		ArrayList<Object[]> arr = ICcu.listarActividades(p);
		String[] actividades = new String[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			Object[] o = arr.get(i);
			actividades[i]=(String) o[0];
		}
		return actividades;
	}
	@WebMethod
	public void buscarActividad(String a) {
		ICca.buscarActividad(a);
	}
	@WebMethod
	public DtActividadDep getDtad() {
		return ICca.getDtad();
	}
	@WebMethod
	public String[] listarClasesA(String a) {
		ArrayList<Object[]> arr = ICcu.listarClasesA(a);
		String[] clases = new String[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			Object[] o = arr.get(i);
			clases[i]=(String) o[0];
		}
		return clases;
	}
	@WebMethod
	public String[] listarRegistros(String r) {
		ArrayList<Object[]> arr = ICcu.listarRegistros(r);
		String[] registros = new String[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			Object[] o = arr.get(i);
			registros[i]=(String) o[0];
		}
		return registros;
	}
	@WebMethod
	public String[] listarClasesN(String a) {
		ArrayList<String> arr = ICca.listarClasesN(a);
		String[] clases = new String[arr.size()];
		int i=0;
		for(String act: arr) {
			clases[i]=act;
			i++;
		}
		return clases;
	}
	@WebMethod
	public String[] listarInstituciones() {
		return ICca.listarInstituciones();
	}
	@WebMethod
	public String[] listarActividadesI(String p) {
		return ICca.listarActividades(p);
	}
	@WebMethod
	public String[] listarRegistrosC(String c) {
		ArrayList<Object[]> arr = ICcc.listarRegistros(c);
		String[] registros = new String[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			Object[] o = arr.get(i);
			registros[i]=(String) o[0];
		}
		return registros;
	}
	@WebMethod
	public String[] listarClases(String a) {
		return ICcc.listarClases(a);
	}
	
}
