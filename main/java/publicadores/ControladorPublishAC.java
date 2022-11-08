/**
 * ControladorPublishAC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublishAC extends java.rmi.Remote {
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public java.lang.String[] listarActividades(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarProfesores(java.lang.String arg0) throws java.rmi.RemoteException;
    public void altaClase(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException;
    public java.lang.String[] listarClases() throws java.rmi.RemoteException;
    public publicadores.DtActividadDep getDtad() throws java.rmi.RemoteException;
    public void buscarActividad(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean existeClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtInstitucionDep buscarInsti(java.lang.String arg0) throws java.rmi.RemoteException;
}
