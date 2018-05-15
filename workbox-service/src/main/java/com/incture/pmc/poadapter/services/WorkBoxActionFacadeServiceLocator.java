/**
 * WorkBoxActionFacadeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class WorkBoxActionFacadeServiceLocator extends org.apache.axis.client.Service implements com.incture.pmc.poadapter.services.WorkBoxActionFacadeService {

    public WorkBoxActionFacadeServiceLocator() {
    }


    public WorkBoxActionFacadeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WorkBoxActionFacadeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WorkBoxActionFacadePort
    private java.lang.String WorkBoxActionFacadePort_address = "http://incturecwd:50000/WorkBoxActionFacadeService/WorkBoxActionFacade";

    public java.lang.String getWorkBoxActionFacadePortAddress() {
        return WorkBoxActionFacadePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WorkBoxActionFacadePortWSDDServiceName = "WorkBoxActionFacadePort";

    public java.lang.String getWorkBoxActionFacadePortWSDDServiceName() {
        return WorkBoxActionFacadePortWSDDServiceName;
    }

    public void setWorkBoxActionFacadePortWSDDServiceName(java.lang.String name) {
        WorkBoxActionFacadePortWSDDServiceName = name;
    }

    public com.incture.pmc.poadapter.services.WorkBoxActionFacade getWorkBoxActionFacadePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WorkBoxActionFacadePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWorkBoxActionFacadePort(endpoint);
    }

    public com.incture.pmc.poadapter.services.WorkBoxActionFacade getWorkBoxActionFacadePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.incture.pmc.poadapter.services.WorkBoxActionFacadeBindingStub _stub = new com.incture.pmc.poadapter.services.WorkBoxActionFacadeBindingStub(portAddress, this);
            _stub.setPortName(getWorkBoxActionFacadePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWorkBoxActionFacadePortEndpointAddress(java.lang.String address) {
        WorkBoxActionFacadePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.incture.pmc.poadapter.services.WorkBoxActionFacade.class.isAssignableFrom(serviceEndpointInterface)) {
                com.incture.pmc.poadapter.services.WorkBoxActionFacadeBindingStub _stub = new com.incture.pmc.poadapter.services.WorkBoxActionFacadeBindingStub(new java.net.URL(WorkBoxActionFacadePort_address), this);
                _stub.setPortName(getWorkBoxActionFacadePortWSDDServiceName());
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
        if ("WorkBoxActionFacadePort".equals(inputPortName)) {
            return getWorkBoxActionFacadePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "WorkBoxActionFacadeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "WorkBoxActionFacadePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WorkBoxActionFacadePort".equals(portName)) {
            setWorkBoxActionFacadePortEndpointAddress(address);
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
