/**
 * ControladorPublishRAC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublishRAC extends java.rmi.Remote {
    public int[] obtCantRegistros() throws java.rmi.RemoteException;
    public publicadores.DtClase[] obtRankClasesDT() throws java.rmi.RemoteException;
    public publicadores.DtActividadDep[] rankActividadesDT() throws java.rmi.RemoteException;
    public int[] obtCantClases() throws java.rmi.RemoteException;
}
