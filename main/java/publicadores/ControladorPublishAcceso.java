/**
 * ControladorPublishAcceso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublishAcceso extends java.rmi.Remote {
    public void killInstancia() throws java.rmi.RemoteException;
    public publicadores.DtProfesor getP() throws java.rmi.RemoteException;
    public publicadores.DtClase getclase() throws java.rmi.RemoteException;
    public publicadores.DtActividadDep getActividad() throws java.rmi.RemoteException;
    public publicadores.DtSocio getS() throws java.rmi.RemoteException;
    public void setInstitucion(publicadores.DtInstitucionDep arg0) throws java.rmi.RemoteException;
    public void setP(publicadores.DtProfesor arg0) throws java.rmi.RemoteException;
    public boolean isModal() throws java.rmi.RemoteException;
    public void setModal(boolean arg0) throws java.rmi.RemoteException;
    public publicadores.DtInstitucionDep getInstitucion() throws java.rmi.RemoteException;
    public void setModalErr(boolean arg0) throws java.rmi.RemoteException;
    public boolean pIsNull() throws java.rmi.RemoteException;
    public void setModalAux(boolean arg0) throws java.rmi.RemoteException;
    public boolean iIsNull() throws java.rmi.RemoteException;
    public boolean aIsNull() throws java.rmi.RemoteException;
    public boolean cIsNull() throws java.rmi.RemoteException;
    public boolean isModalErr() throws java.rmi.RemoteException;
    public boolean sIsNull() throws java.rmi.RemoteException;
    public void setS(publicadores.DtSocio arg0) throws java.rmi.RemoteException;
    public boolean isModalAux() throws java.rmi.RemoteException;
    public void setActividad(publicadores.DtActividadDep arg0) throws java.rmi.RemoteException;
    public void setclase(publicadores.DtClase arg0) throws java.rmi.RemoteException;
}
