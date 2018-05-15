package com.incture.pmc.poadapter.services;

public class ProcessActionFacadeProxy implements com.incture.pmc.poadapter.services.ProcessActionFacade {
  private String _endpoint = null;
  private com.incture.pmc.poadapter.services.ProcessActionFacade processActionFacade = null;
  
  public ProcessActionFacadeProxy() {
    _initProcessActionFacadeProxy();
  }
  
  public ProcessActionFacadeProxy(String endpoint) {
    _endpoint = endpoint;
    _initProcessActionFacadeProxy();
  }
  
  private void _initProcessActionFacadeProxy() {
    try {
      processActionFacade = (new com.incture.pmc.poadapter.services.ProcessActionFacadeServiceLocator()).getprocessActionFacadePort();
      if (processActionFacade != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)processActionFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)processActionFacade)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (processActionFacade != null)
      ((javax.xml.rpc.Stub)processActionFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.incture.pmc.poadapter.services.ProcessActionFacade getProcessActionFacade() {
    if (processActionFacade == null)
      _initProcessActionFacadeProxy();
    return processActionFacade;
  }
  
  public java.lang.String cancelProcess(java.lang.String processInstanceId) throws java.rmi.RemoteException{
    if (processActionFacade == null)
      _initProcessActionFacadeProxy();
    return processActionFacade.cancelProcess(processInstanceId);
  }
  
  
}