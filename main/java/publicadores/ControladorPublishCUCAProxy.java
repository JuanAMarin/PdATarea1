package publicadores;

public class ControladorPublishCUCAProxy implements publicadores.ControladorPublishCUCA {
  private String _endpoint = null;
  private publicadores.ControladorPublishCUCA controladorPublishCUCA = null;
  
  public ControladorPublishCUCAProxy() {
    _initControladorPublishCUCAProxy();
  }
  
  public ControladorPublishCUCAProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishCUCAProxy();
  }
  
  private void _initControladorPublishCUCAProxy() {
    try {
      controladorPublishCUCA = (new publicadores.ControladorPublishCUCAServiceLocator()).getControladorPublishCUCAPort();
      if (controladorPublishCUCA != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishCUCA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishCUCA)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishCUCA != null)
      ((javax.xml.rpc.Stub)controladorPublishCUCA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishCUCA getControladorPublishCUCA() {
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA;
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarInstituciones();
  }
  
  public java.lang.String[] listarClasesS(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarClasesS(arg0);
  }
  
  public java.lang.String[] listarRegistros(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarRegistros(arg0);
  }
  
  public java.lang.String[] listarClasesA(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarClasesA(arg0);
  }
  
  public publicadores.DtActividadDep getDtad() throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.getDtad();
  }
  
  public java.lang.String[] listarClasesN(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarClasesN(arg0);
  }
  
  public void buscarActividad(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    controladorPublishCUCA.buscarActividad(arg0);
  }
  
  public void buscarClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    controladorPublishCUCA.buscarClase(arg0);
  }
  
  public publicadores.DtClase getDtc() throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.getDtc();
  }
  
  public java.lang.String[] listarActividadesI(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarActividadesI(arg0);
  }
  
  public java.lang.String[] listarActividadesP(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarActividadesP(arg0);
  }
  
  public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarClases(arg0);
  }
  
  public java.lang.String[] listarRegistrosC(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublishCUCA == null)
      _initControladorPublishCUCAProxy();
    return controladorPublishCUCA.listarRegistrosC(arg0);
  }
  
  
}