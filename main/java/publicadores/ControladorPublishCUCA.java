/**
 * ControladorPublishCUCA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublishCUCA extends java.rmi.Remote {
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public java.lang.String[] listarClases(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarRegistrosC(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarActividadesI(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarActividadesP(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtActividadDep getDtad() throws java.rmi.RemoteException;
    public void buscarActividad(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarRegistros(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClasesN(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClasesS(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClasesA(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase getDtc() throws java.rmi.RemoteException;
    public void buscarClase(java.lang.String arg0) throws java.rmi.RemoteException;
}
