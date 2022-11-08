package publicadores;

public class ControladorPublishACProxy implements publicadores.ControladorPublishAC {
  private String _endpoint = null;
  private publicadores.ControladorPublishAC controladorPublishAC = null;
  
  public ControladorPublishACProxy() {
    _initControladorPublishACProxy();
  }
  
  public ControladorPublishACProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishACProxy();
  }
  
  private void _initControladorPublishACProxy() {
    try {
      controladorPublishAC = (new publicadores.ControladorPublishACServiceLocator()).getControladorPublishACPort();
      if (controladorPublishAC != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishAC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishAC)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishAC != null)
      ((javax.xml.rpc.Stub)controladorPublishAC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishAC getControladorPublishAC() {
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC;
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.listarInstituciones();
  }
  
  public java.lang.String[] listarActividades(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.listarActividades(arg0);
  }
  
  public void altaClase(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    controladorPublishAC.altaClase(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public java.lang.String[] listarProfesores(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.listarProfesores(arg0);
  }
  
  public java.lang.String[] listarClases() throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.listarClases();
  }
  
  public void buscarActividad(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    controladorPublishAC.buscarActividad(arg0);
  }
  
  public publicadores.DtActividadDep getDtad() throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.getDtad();
  }
  
  public publicadores.DtInstitucionDep buscarInsti(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.buscarInsti(arg0);
  }
  
  public boolean existeClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishAC == null)
      _initControladorPublishACProxy();
    return controladorPublishAC.existeClase(arg0);
  }
  
  
}