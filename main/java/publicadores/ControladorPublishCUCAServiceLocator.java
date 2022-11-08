/**
 * ControladorPublishCUCAServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorPublishCUCAServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorPublishCUCAService {

    public ControladorPublishCUCAServiceLocator() {
    }


    public ControladorPublishCUCAServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorPublishCUCAServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorPublishCUCAPort
    private java.lang.String ControladorPublishCUCAPort_address = "http://127.0.0.1:8091/controladorCUCA";

    public java.lang.String getControladorPublishCUCAPortAddress() {
        return ControladorPublishCUCAPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorPublishCUCAPortWSDDServiceName = "ControladorPublishCUCAPort";

    public java.lang.String getControladorPublishCUCAPortWSDDServiceName() {
        return ControladorPublishCUCAPortWSDDServiceName;
    }

    public void setControladorPublishCUCAPortWSDDServiceName(java.lang.String name) {
        ControladorPublishCUCAPortWSDDServiceName = name;
    }

    public publicadores.ControladorPublishCUCA getControladorPublishCUCAPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorPublishCUCAPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorPublishCUCAPort(endpoint);
    }

    public publicadores.ControladorPublishCUCA getControladorPublishCUCAPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorPublishCUCAPortBindingStub _stub = new publicadores.ControladorPublishCUCAPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorPublishCUCAPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorPublishCUCAPortEndpointAddress(java.lang.String address) {
        ControladorPublishCUCAPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorPublishCUCA.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorPublishCUCAPortBindingStub _stub = new publicadores.ControladorPublishCUCAPortBindingStub(new java.net.URL(ControladorPublishCUCAPort_address), this);
                _stub.setPortName(getControladorPublishCUCAPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ControladorPublishCUCAPort".equals(inputPortName)) {
            return getControladorPublishCUCAPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorPublishCUCAService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorPublishCUCAPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorPublishCUCAPort".equals(portName)) {
            setControladorPublishCUCAPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
