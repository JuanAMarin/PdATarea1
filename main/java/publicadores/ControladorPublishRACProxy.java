package publicadores;

public class ControladorPublishRACProxy implements publicadores.ControladorPublishRAC {
  private String _endpoint = null;
  private publicadores.ControladorPublishRAC controladorPublishRAC = null;
  
  public ControladorPublishRACProxy() {
    _initControladorPublishRACProxy();
  }
  
  public ControladorPublishRACProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishRACProxy();
  }
  
  private void _initControladorPublishRACProxy() {
    try {
      controladorPublishRAC = (new publicadores.ControladorPublishRACServiceLocator()).getControladorPublishRACPort();
      if (controladorPublishRAC != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishRAC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishRAC)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishRAC != null)
      ((javax.xml.rpc.Stub)controladorPublishRAC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishRAC getControladorPublishRAC() {
    if (controladorPublishRAC == null)
      _initControladorPublishRACProxy();
    return controladorPublishRAC;
  }
  
  public int[] obtCantRegistros() throws java.rmi.RemoteException{
    if (controladorPublishRAC == null)
      _initControladorPublishRACProxy();
    return controladorPublishRAC.obtCantRegistros();
  }
  
  public publicadores.DtClase[] obtRankClasesDT() throws java.rmi.RemoteException{
    if (controladorPublishRAC == null)
      _initControladorPublishRACProxy();
    return controladorPublishRAC.obtRankClasesDT();
  }
  
  public publicadores.DtActividadDep[] rankActividadesDT() throws java.rmi.RemoteException{
    if (controladorPublishRAC == null)
      _initControladorPublishRACProxy();
    return controladorPublishRAC.rankActividadesDT();
  }
  
  public int[] obtCantClases() throws java.rmi.RemoteException{
    if (controladorPublishRAC == null)
      _initControladorPublishRACProxy();
    return controladorPublishRAC.obtCantClases();
  }
  
  
}