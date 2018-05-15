/**
 * ProcessActionFacadeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class ProcessActionFacadeServiceLocator extends org.apache.axis.client.Service implements com.incture.pmc.poadapter.services.ProcessActionFacadeService {

    public ProcessActionFacadeServiceLocator() {
    }


    public ProcessActionFacadeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProcessActionFacadeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for processActionFacadePort
    private java.lang.String processActionFacadePort_address = "http://incturecwd:50000/processActionFacadeService/processActionFacade";

    public java.lang.String getprocessActionFacadePortAddress() {
        return processActionFacadePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String processActionFacadePortWSDDServiceName = "processActionFacadePort";

    public java.lang.String getprocessActionFacadePortWSDDServiceName() {
        return processActionFacadePortWSDDServiceName;
    }

    public void setprocessActionFacadePortWSDDServiceName(java.lang.String name) {
        processActionFacadePortWSDDServiceName = name;
    }

    public com.incture.pmc.poadapter.services.ProcessActionFacade getprocessActionFacadePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(processActionFacadePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getprocessActionFacadePort(endpoint);
    }

    public com.incture.pmc.poadapter.services.ProcessActionFacade getprocessActionFacadePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.incture.pmc.poadapter.services.ProcessActionFacadeBindingStub _stub = new com.incture.pmc.poadapter.services.ProcessActionFacadeBindingStub(portAddress, this);
            _stub.setPortName(getprocessActionFacadePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setprocessActionFacadePortEndpointAddress(java.lang.String address) {
        processActionFacadePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.incture.pmc.poadapter.services.ProcessActionFacade.class.isAssignableFrom(serviceEndpointInterface)) {
                com.incture.pmc.poadapter.services.ProcessActionFacadeBindingStub _stub = new com.incture.pmc.poadapter.services.ProcessActionFacadeBindingStub(new java.net.URL(processActionFacadePort_address), this);
                _stub.setPortName(getprocessActionFacadePortWSDDServiceName());
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
        if ("processActionFacadePort".equals(inputPortName)) {
            return getprocessActionFacadePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "processActionFacadeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "processActionFacadePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("processActionFacadePort".equals(portName)) {
            setprocessActionFacadePortEndpointAddress(address);
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
