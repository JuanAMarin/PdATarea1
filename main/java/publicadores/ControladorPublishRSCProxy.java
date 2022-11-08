package publicadores;

public class ControladorPublishRSCProxy implements publicadores.ControladorPublishRSC {
  private String _endpoint = null;
  private publicadores.ControladorPublishRSC controladorPublishRSC = null;
  
  public ControladorPublishRSCProxy() {
    _initControladorPublishRSCProxy();
  }
  
  public ControladorPublishRSCProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishRSCProxy();
  }
  
  private void _initControladorPublishRSCProxy() {
    try {
      controladorPublishRSC = (new publicadores.ControladorPublishRSCServiceLocator()).getControladorPublishRSCPort();
      if (controladorPublishRSC != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishRSC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishRSC)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishRSC != null)
      ((javax.xml.rpc.Stub)controladorPublishRSC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishRSC getControladorPublishRSC() {
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC;
  }
  
  public void registro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    controladorPublishRSC.registro(arg0, arg1);
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.listarInstituciones();
  }
  
  public java.lang.String[] listarActividades(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.listarActividades(arg0);
  }
  
  public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.listarClases(arg0);
  }
  
  public publicadores.DtInstitucionDep buscarInsti(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.buscarInsti(arg0);
  }
  
  public publicadores.DtActividadDep getDtad() throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.getDtad();
  }
  
  public publicadores.DtClase buscarClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.buscarClase(arg0);
  }
  
  public publicadores.DtClase getDtc() throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.getDtc();
  }
  
  public void buscarActividad(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    controladorPublishRSC.buscarActividad(arg0);
  }
  
  public boolean socioYaRegistrado(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.socioYaRegistrado(arg0, arg1);
  }
  
  public java.lang.String[] listarSocios() throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    return controladorPublishRSC.listarSocios();
  }
  
  public void eliminarRegistro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublishRSC == null)
      _initControladorPublishRSCProxy();
    controladorPublishRSC.eliminarRegistro(arg0, arg1);
  }
  
  
}