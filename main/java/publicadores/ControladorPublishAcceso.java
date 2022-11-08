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
import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.Acceso;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublishAcceso {
	private Acceso ac;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublishAcceso() {
		ac = Acceso.getInstancia();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorA", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorA");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//Controlador Acceso
	@WebMethod
	public DtProfesor getP() {
		return ac.getP();
	}
	@WebMethod
	public DtSocio getS() {
		return ac.getS();
	}
	@WebMethod
	public DtClase getclase() {
		return ac.getclase();
	}
	@WebMethod
	public DtActividadDep getActividad() {
		return ac.getActividad();
	}
	@WebMethod
	public DtInstitucionDep getInstitucion() {
		return ac.getInstitucion();
	}
	@WebMethod
	public void setP(DtProfesor p) {
		ac.setP(p);
	}
	@WebMethod
	public void setS(DtSocio s) {
		 ac.setS(s);
	}
	@WebMethod
	public void setclase(DtClase c) {
		 ac.setclase(c);
	}
	@WebMethod
	public void setActividad(DtActividadDep a) {
		 ac.setActividad(a);
	}
	@WebMethod
	public void setInstitucion(DtInstitucionDep i) {
		ac.setInstitucion(i);
	}
	@WebMethod
	public boolean isModal() {
		return ac.isModal();
	}
	@WebMethod
	public void setModal(boolean m) {
		ac.setModal(m);
	}
	@WebMethod
	public boolean isModalErr() {
		return ac.isModalErr();
	}
	@WebMethod
	public void setModalErr(boolean me) {
		ac.setModalErr(me);
	}
	@WebMethod
	public boolean isModalAux() {
		return ac.isModalAux();
	}
	@WebMethod
	public void setModalAux(boolean ma) {
		ac.setModalAux(ma);
	}
	@WebMethod
	public void killInstancia() {
		ac.killInstancia();
	}
	@WebMethod
	public boolean pIsNull() {
		return ac.pIsNull();
	}
	@WebMethod
	public boolean sIsNull() {
		return ac.sIsNull();
	}
	@WebMethod
	public boolean iIsNull() {
		return ac.iIsNull();
	}
	@WebMethod
	public boolean aIsNull() {
		return ac.aIsNull();
	}
	@WebMethod
	public boolean cIsNull() {
		return ac.cIsNull();
	}
}