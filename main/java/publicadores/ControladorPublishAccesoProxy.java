package publicadores;

public class ControladorPublishAccesoProxy implements publicadores.ControladorPublishAcceso {
  private String _endpoint = null;
  private publicadores.ControladorPublishAcceso controladorPublishAcceso = null;
  
  public ControladorPublishAccesoProxy() {
    _initControladorPublishAccesoProxy();
  }
  
  public ControladorPublishAccesoProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishAccesoProxy();
  }
  
  private void _initControladorPublishAccesoProxy() {
    try {
      controladorPublishAcceso = (new publicadores.ControladorPublishAccesoServiceLocator()).getControladorPublishAccesoPort();
      if (controladorPublishAcceso != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublishAcceso)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublishAcceso)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublishAcceso != null)
      ((javax.xml.rpc.Stub)controladorPublishAcceso)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublishAcceso getControladorPublishAcceso() {
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso;
  }
  
  public void killInstancia() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.killInstancia();
  }
  
  public publicadores.DtProfesor getP() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.getP();
  }
  
  public publicadores.DtClase getclase() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.getclase();
  }
  
  public publicadores.DtActividadDep getActividad() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.getActividad();
  }
  
  public publicadores.DtSocio getS() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.getS();
  }
  
  public void setInstitucion(publicadores.DtInstitucionDep arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setInstitucion(arg0);
  }
  
  public void setP(publicadores.DtProfesor arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setP(arg0);
  }
  
  public boolean isModal() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.isModal();
  }
  
  public void setModal(boolean arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setModal(arg0);
  }
  
  public publicadores.DtInstitucionDep getInstitucion() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.getInstitucion();
  }
  
  public void setModalErr(boolean arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setModalErr(arg0);
  }
  
  public boolean pIsNull() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.pIsNull();
  }
  
  public void setModalAux(boolean arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setModalAux(arg0);
  }
  
  public boolean iIsNull() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.iIsNull();
  }
  
  public boolean aIsNull() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.aIsNull();
  }
  
  public boolean cIsNull() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.cIsNull();
  }
  
  public boolean isModalErr() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.isModalErr();
  }
  
  public boolean sIsNull() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.sIsNull();
  }
  
  public void setS(publicadores.DtSocio arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setS(arg0);
  }
  
  public boolean isModalAux() throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    return controladorPublishAcceso.isModalAux();
  }
  
  public void setActividad(publicadores.DtActividadDep arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setActividad(arg0);
  }
  
  public void setclase(publicadores.DtClase arg0) throws java.rmi.RemoteException{
    if (controladorPublishAcceso == null)
      _initControladorPublishAccesoProxy();
    controladorPublishAcceso.setclase(arg0);
  }
  
  
}