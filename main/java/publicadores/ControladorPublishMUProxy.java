package publicadores;

public class ControladorPublishMUProxy implements publicadores.ControladorPublishMU {
  private String _endpoint = null;
  private publicadores.ControladorPublishMU controladorPublishMU = null;
  
  public ControladorPublishMUProxy() {
    _initControladorPublishMUProxy();
  }
  
  public ControladorPublishMUProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishMUProxy();
  }
  
  private void _initControladorPublishMUProxy() {
    try {
      controladorPublishMU = (new publicadores.ControladorPublishMUServiceLocator()).getControladorPublishMUPort();
      if (controladorPublishMU != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishMU)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishMU)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishMU != null)
      ((javax.xml.rpc.Stub)controladorPublishMU)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishMU getControladorPublishMU() {
    if (controladorPublishMU == null)
      _initControladorPublishMUProxy();
    return controladorPublishMU;
  }
  
  public publicadores.DtSocio obtenerSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishMU == null)
      _initControladorPublishMUProxy();
    return controladorPublishMU.obtenerSocio(arg0);
  }
  
  public publicadores.DtProfesor obtenerProfesor(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishMU == null)
      _initControladorPublishMUProxy();
    return controladorPublishMU.obtenerProfesor(arg0);
  }
  
  public void modSocio(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3, byte[] arg4) throws java.rmi.RemoteException{
    if (controladorPublishMU == null)
      _initControladorPublishMUProxy();
    controladorPublishMU.modSocio(arg0, arg1, arg2, arg3, arg4);
  }
  
  public void modProfesor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException{
    if (controladorPublishMU == null)
      _initControladorPublishMUProxy();
    controladorPublishMU.modProfesor(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  
}