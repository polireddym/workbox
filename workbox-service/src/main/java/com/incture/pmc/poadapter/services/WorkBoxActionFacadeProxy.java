package com.incture.pmc.poadapter.services;

public class WorkBoxActionFacadeProxy implements com.incture.pmc.poadapter.services.WorkBoxActionFacade {
  private String _endpoint = null;
  private com.incture.pmc.poadapter.services.WorkBoxActionFacade workBoxActionFacade = null;
  
  public WorkBoxActionFacadeProxy() {
    _initWorkBoxActionFacadeProxy();
  }
  
  public WorkBoxActionFacadeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWorkBoxActionFacadeProxy();
  }
  
  private void _initWorkBoxActionFacadeProxy() {
    try {
      workBoxActionFacade = (new com.incture.pmc.poadapter.services.WorkBoxActionFacadeServiceLocator()).getWorkBoxActionFacadePort();
      if (workBoxActionFacade != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)workBoxActionFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)workBoxActionFacade)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (workBoxActionFacade != null)
      ((javax.xml.rpc.Stub)workBoxActionFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.incture.pmc.poadapter.services.WorkBoxActionFacade getWorkBoxActionFacade() {
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade;
  }
  
  public boolean claimTask(java.lang.String taskInstanceId) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.claimTask(taskInstanceId);
  }
  
  public boolean release(java.lang.String taskInstanceId) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.release(taskInstanceId);
  }
  
  public boolean delegate(java.lang.String taskInstanceId, java.lang.String userId) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.delegate(taskInstanceId, userId);
  }
  
  public java.lang.String addNote(java.lang.String taskInstanceId, java.lang.String content) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.addNote(taskInstanceId, content);
  }
  
  public boolean complete(java.lang.String taskInstanceId, java.lang.String action) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.complete(taskInstanceId, action);
  }
  
  public com.incture.pmc.poadapter.services.NoteDto[] getNotes(java.lang.String taskInstanceId) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.getNotes(taskInstanceId);
  }
  
  public java.lang.String claimAndDelegate(java.lang.String taskInstanceId, java.lang.String userId) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.claimAndDelegate(taskInstanceId, userId);
  }
  
  public java.lang.String nominate(java.lang.String taskInstanceId, java.lang.String userId) throws java.rmi.RemoteException{
    if (workBoxActionFacade == null)
      _initWorkBoxActionFacadeProxy();
    return workBoxActionFacade.nominate(taskInstanceId, userId);
  }
  
  
}