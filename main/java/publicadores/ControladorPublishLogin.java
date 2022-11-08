package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import configuraciones.WebServiceConfiguracion;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.Fabrica;
import interfaces.IClogin;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishLogin {
	private Fabrica f;
	private IClogin ICl;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublishLogin() {
		f = Fabrica.getInstancia();
		ICl = f.getIClogin();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorL", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorL");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Login
	@WebMethod
	public boolean existeSBoolean(String nickname, String pass) {
		return ICl.existeSBoolean(nickname, pass);
	}
	@WebMethod
	public boolean existePBoolean(String nickname, String pass) {
		return ICl.existePBoolean(nickname, pass);
	}
	@WebMethod
	public DtSocio existeS(String nickname, String pass) {
		return ICl.existeS(nickname, pass);
	}
	@WebMethod
	public DtProfesor existeP(String nickname, String pass) {
		return ICl.existeP(nickname, pass);
	}
}