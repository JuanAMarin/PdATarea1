package publicadores;

public class ControladorPublishLoginProxy implements publicadores.ControladorPublishLogin {
  private String _endpoint = null;
  private publicadores.ControladorPublishLogin controladorPublishLogin = null;
  
  public ControladorPublishLoginProxy() {
    _initControladorPublishLoginProxy();
  }
  
  public ControladorPublishLoginProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishLoginProxy();
  }
  
  private void _initControladorPublishLoginProxy() {
    try {
      controladorPublishLogin = (new publicadores.ControladorPublishLoginServiceLocator()).getControladorPublishLoginPort();
      if (controladorPublishLogin != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishLogin)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishLogin)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishLogin != null)
      ((javax.xml.rpc.Stub)controladorPublishLogin)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishLogin getControladorPublishLogin() {
    if (controladorPublishLogin == null)
      _initControladorPublishLoginProxy();
    return controladorPublishLogin;
  }
  
  public boolean existePBoolean(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishLogin == null)
      _initControladorPublishLoginProxy();
    return controladorPublishLogin.existePBoolean(arg0, arg1);
  }
  
  public publicadores.DtSocio existeS(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishLogin == null)
      _initControladorPublishLoginProxy();
    return controladorPublishLogin.existeS(arg0, arg1);
  }
  
  public publicadores.DtProfesor existeP(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishLogin == null)
      _initControladorPublishLoginProxy();
    return controladorPublishLogin.existeP(arg0, arg1);
  }
  
  public boolean existeSBoolean(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishLogin == null)
      _initControladorPublishLoginProxy();
    return controladorPublishLogin.existeSBoolean(arg0, arg1);
  }
  
  
}