package publicadores;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.Fabrica;
import interfaces.ICmodusuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishMU {
	private Fabrica f;
	private ICmodusuario ICmu;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublishMU() {
		f = Fabrica.getInstancia();
		ICmu = f.getICmodusuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorMU", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorMU");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Ranking de Actividades
	@WebMethod
	public void modProfesor(String nickname, String nombre, String apellido, Date f, String desc, String biografia, String sw, byte[] foto) {
		ICmu.modProfesor(nickname, nombre, apellido, f, desc, biografia, sw, foto);
	}
	@WebMethod
	public void modSocio(String nickname, String nombre, String apellido, Date f, byte[] foto) {
		ICmu.modSocio(nickname, nombre, apellido, f, foto);
	}
	@WebMethod
	public DtProfesor obtenerProfesor(String nickname) {
		return ICmu.obtenerProfesor(nickname);
	}
	@WebMethod
	public DtSocio obtenerSocio(String nickname) {
		return ICmu.obtenerSocio(nickname);
	}
	
}

