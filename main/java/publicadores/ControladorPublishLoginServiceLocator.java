/**
 * ControladorPublishLoginServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorPublishLoginServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorPublishLoginService {

    public ControladorPublishLoginServiceLocator() {
    }


    public ControladorPublishLoginServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorPublishLoginServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorPublishLoginPort
    private java.lang.String ControladorPublishLoginPort_address = "http://127.0.0.1:8091/controladorL";

    public java.lang.String getControladorPublishLoginPortAddress() {
        return ControladorPublishLoginPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorPublishLoginPortWSDDServiceName = "ControladorPublishLoginPort";

    public java.lang.String getControladorPublishLoginPortWSDDServiceName() {
        return ControladorPublishLoginPortWSDDServiceName;
    }

    public void setControladorPublishLoginPortWSDDServiceName(java.lang.String name) {
        ControladorPublishLoginPortWSDDServiceName = name;
    }

    public publicadores.ControladorPublishLogin getControladorPublishLoginPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorPublishLoginPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorPublishLoginPort(endpoint);
    }

    public publicadores.ControladorPublishLogin getControladorPublishLoginPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorPublishLoginPortBindingStub _stub = new publicadores.ControladorPublishLoginPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorPublishLoginPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorPublishLoginPortEndpointAddress(java.lang.String address) {
        ControladorPublishLoginPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorPublishLogin.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorPublishLoginPortBindingStub _stub = new publicadores.ControladorPublishLoginPortBindingStub(new java.net.URL(ControladorPublishLoginPort_address), this);
                _stub.setPortName(getControladorPublishLoginPortWSDDServiceName());
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
        if ("ControladorPublishLoginPort".equals(inputPortName)) {
            return getControladorPublishLoginPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorPublishLoginService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorPublishLoginPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorPublishLoginPort".equals(portName)) {
            setControladorPublishLoginPortEndpointAddress(address);
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
