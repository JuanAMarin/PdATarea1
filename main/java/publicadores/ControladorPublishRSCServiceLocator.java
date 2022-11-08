/**
 * ControladorPublishRSCServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorPublishRSCServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorPublishRSCService {

    public ControladorPublishRSCServiceLocator() {
    }


    public ControladorPublishRSCServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorPublishRSCServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorPublishRSCPort
    private java.lang.String ControladorPublishRSCPort_address = "http://127.0.0.1:8091/controladorRSC";

    public java.lang.String getControladorPublishRSCPortAddress() {
        return ControladorPublishRSCPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorPublishRSCPortWSDDServiceName = "ControladorPublishRSCPort";

    public java.lang.String getControladorPublishRSCPortWSDDServiceName() {
        return ControladorPublishRSCPortWSDDServiceName;
    }

    public void setControladorPublishRSCPortWSDDServiceName(java.lang.String name) {
        ControladorPublishRSCPortWSDDServiceName = name;
    }

    public publicadores.ControladorPublishRSC getControladorPublishRSCPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorPublishRSCPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorPublishRSCPort(endpoint);
    }

    public publicadores.ControladorPublishRSC getControladorPublishRSCPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorPublishRSCPortBindingStub _stub = new publicadores.ControladorPublishRSCPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorPublishRSCPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorPublishRSCPortEndpointAddress(java.lang.String address) {
        ControladorPublishRSCPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorPublishRSC.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorPublishRSCPortBindingStub _stub = new publicadores.ControladorPublishRSCPortBindingStub(new java.net.URL(ControladorPublishRSCPort_address), this);
                _stub.setPortName(getControladorPublishRSCPortWSDDServiceName());
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
        if ("ControladorPublishRSCPort".equals(inputPortName)) {
            return getControladorPublishRSCPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorPublishRSCService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorPublishRSCPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorPublishRSCPort".equals(portName)) {
            setControladorPublishRSCPortEndpointAddress(address);
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
