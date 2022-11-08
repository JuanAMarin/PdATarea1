package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDep;
import datatypes.DtClase;
import datatypes.DtInstitucionDep;
import exceptions.SocioYaEliminadoException;
import exceptions.SocioYaRegistradoException;
import interfaces.Fabrica;
import interfaces.ICaltadictadoclase;
import interfaces.ICconsultaclase;
import interfaces.ICregistrodeclases;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishRSC {
	private Fabrica fabrica;
	private ICregistrodeclases ICreg;
	private ICaltadictadoclase ICac;
	private ICconsultaclase ICcc;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishRSC() {
		fabrica = Fabrica.getInstancia();
		ICreg = fabrica.getICregistrodeclases();
		ICac = fabrica.getICaltadictadoclase();
		ICcc = fabrica.getICconsultaclase();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRSC", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRSC");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Registro a Clase
	@WebMethod
	public String[] listarActividades(String nombre) {
		return ICreg.listarActividades(nombre);
	}
	
	@WebMethod
	public String[] listarInstituciones() {
		return ICreg.listarInstituciones();
	}
	
	@WebMethod
	public DtClase buscarClase(String clase) {
		return ICreg.buscarClase(clase);
	}
	
	@WebMethod
	public String[] listarClases(String actividad){
		return ICreg.listarClases(actividad);
	}
	
	@WebMethod
	public String[] listarSocios() {
		return ICreg.listarSocios();
	}

	
	@WebMethod
	public void buscarActividad (String actividad){
		ICac.buscarActividad(actividad);
	}
	
	@WebMethod
	public DtActividadDep getDtad (){
		return ICac.getDtad();
	}
	
	@WebMethod
	public DtInstitucionDep buscarInsti (String insti){
		return ICac.buscarInsti(insti);
	}
	
	@WebMethod
	public void Registro (String clase, String socio){
		try {
			ICreg.Registro(clase, socio);
		} catch (SocioYaRegistradoException e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void eliminarRegistro (String clase, String socio){
		try {
			ICreg.eliminarRegistro(clase, socio);
		} catch (SocioYaEliminadoException e) {
			e.printStackTrace();
		}
	}
	@WebMethod
	public DtClase getDtc (){
		return ICcc.getDtc();
	}
	@WebMethod
	public boolean socioYaRegistrado (String clase, String socio){
		return ICreg.socioYaRegistrado(clase, socio);
	}
	
}
