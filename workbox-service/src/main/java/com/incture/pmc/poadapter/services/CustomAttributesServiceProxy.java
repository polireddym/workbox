package com.incture.pmc.poadapter.services;

public class CustomAttributesServiceProxy implements com.incture.pmc.poadapter.services.CustomAttributesService {
  private String _endpoint = null;
  private com.incture.pmc.poadapter.services.CustomAttributesService customAttributesService = null;
  
  public CustomAttributesServiceProxy() {
    _initCustomAttributesServiceProxy();
  }
  
  public CustomAttributesServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomAttributesServiceProxy();
  }
  
  private void _initCustomAttributesServiceProxy() {
    try {
      customAttributesService = (new com.incture.pmc.poadapter.services.CustomAttributesServiceServiceLocator()).getCustomAttributesServicePort();
      if (customAttributesService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customAttributesService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customAttributesService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customAttributesService != null)
      ((javax.xml.rpc.Stub)customAttributesService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.incture.pmc.poadapter.services.CustomAttributesService getCustomAttributesService() {
    if (customAttributesService == null)
      _initCustomAttributesServiceProxy();
    return customAttributesService;
  }
  
  public com.incture.pmc.poadapter.services.CustomAttributeDto getCustomAttributes(java.lang.String taskId) throws java.rmi.RemoteException{
    if (customAttributesService == null)
      _initCustomAttributesServiceProxy();
    return customAttributesService.getCustomAttributes(taskId);
  }
  
  
}