/**
 * ControladorPublishRSC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublishRSC extends java.rmi.Remote {
    public void registro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public java.lang.String[] listarActividades(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtInstitucionDep buscarInsti(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtActividadDep getDtad() throws java.rmi.RemoteException;
    public publicadores.DtClase buscarClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase getDtc() throws java.rmi.RemoteException;
    public void buscarActividad(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean socioYaRegistrado(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listarSocios() throws java.rmi.RemoteException;
    public void eliminarRegistro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
