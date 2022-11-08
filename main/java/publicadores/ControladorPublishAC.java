package publicadores;


import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDep;
import datatypes.DtInstitucionDep;
import exceptions.ClaseRepetidaException;
import exceptions.ErrorFechaException;
import interfaces.Fabrica;
import interfaces.ICaltadictadoclase;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishAC {
	private Fabrica f;
	private ICaltadictadoclase ICac;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublishAC() {
		f = Fabrica.getInstancia();
		ICac = f.getICaltadictadoclase();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAC", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAC");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Alta Clase
	@WebMethod
	public String[] listarInstituciones() {
		return ICac.listarInstituciones();
	}
	
	@WebMethod
	public String[] listarClases() {
		return ICac.listarClases();
	}
	
	@WebMethod
	public String[] listarActividades(String nombre) {
		return ICac.listarActividades(nombre);
	}
	
	@WebMethod
	public void altaClase(String nombre, String url, Date fecha, Date fechaReg, Date HoraInicio, String profesor, String actividad, byte[] image){
		try {
			ICac.altaClase(nombre,url,fecha,fechaReg,HoraInicio,profesor,actividad,image);
		} catch (ClaseRepetidaException e) {
			e.printStackTrace();
		} catch (ErrorFechaException e) {
			e.printStackTrace();
		}
	}

	@WebMethod
	public String[] listarProfesores(String insti) {
		return ICac.listarProfesores(insti);
	}
	
	@WebMethod
	public void buscarActividad(String actividad){
		ICac.buscarActividad(actividad);
	}
	
	@WebMethod
	public DtActividadDep getDtad() {
		return ICac.getDtad();
	}
	
	@WebMethod
	public DtInstitucionDep buscarInsti(String insti){
		return ICac.buscarInsti(insti);
	}
	
	@WebMethod
	public boolean existeClase(String clase){
		return ICac.existeClase(clase);
	}
	
}
