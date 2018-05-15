/**
 * UMEUserManagementFacadeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class UMEUserManagementFacadeServiceLocator extends org.apache.axis.client.Service implements com.incture.pmc.poadapter.services.UMEUserManagementFacadeService {

    public UMEUserManagementFacadeServiceLocator() {
    }


    public UMEUserManagementFacadeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UMEUserManagementFacadeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UMEUserManagementFacadePort
    private java.lang.String UMEUserManagementFacadePort_address = "http://incturecwd:50000/UMEUserManagementFacadeService/UMEUserManagementFacade";

    public java.lang.String getUMEUserManagementFacadePortAddress() {
        return UMEUserManagementFacadePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UMEUserManagementFacadePortWSDDServiceName = "UMEUserManagementFacadePort";

    public java.lang.String getUMEUserManagementFacadePortWSDDServiceName() {
        return UMEUserManagementFacadePortWSDDServiceName;
    }

    public void setUMEUserManagementFacadePortWSDDServiceName(java.lang.String name) {
        UMEUserManagementFacadePortWSDDServiceName = name;
    }

    public com.incture.pmc.poadapter.services.UMEUserManagementFacade getUMEUserManagementFacadePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UMEUserManagementFacadePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUMEUserManagementFacadePort(endpoint);
    }

    public com.incture.pmc.poadapter.services.UMEUserManagementFacade getUMEUserManagementFacadePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.incture.pmc.poadapter.services.UMEUserManagementFacadeBindingStub _stub = new com.incture.pmc.poadapter.services.UMEUserManagementFacadeBindingStub(portAddress, this);
            _stub.setPortName(getUMEUserManagementFacadePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUMEUserManagementFacadePortEndpointAddress(java.lang.String address) {
        UMEUserManagementFacadePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.incture.pmc.poadapter.services.UMEUserManagementFacade.class.isAssignableFrom(serviceEndpointInterface)) {
                com.incture.pmc.poadapter.services.UMEUserManagementFacadeBindingStub _stub = new com.incture.pmc.poadapter.services.UMEUserManagementFacadeBindingStub(new java.net.URL(UMEUserManagementFacadePort_address), this);
                _stub.setPortName(getUMEUserManagementFacadePortWSDDServiceName());
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
        if ("UMEUserManagementFacadePort".equals(inputPortName)) {
            return getUMEUserManagementFacadePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "UMEUserManagementFacadeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "UMEUserManagementFacadePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UMEUserManagementFacadePort".equals(portName)) {
            setUMEUserManagementFacadePortEndpointAddress(address);
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
