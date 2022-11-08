/**
 * ControladorPublishMU.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublishMU extends java.rmi.Remote {
    public publicadores.DtSocio obtenerSocio(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtProfesor obtenerProfesor(java.lang.String arg0) throws java.rmi.RemoteException;
    public void modSocio(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3, byte[] arg4) throws java.rmi.RemoteException;
    public void modProfesor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException;
}
