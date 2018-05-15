package com.incture.pmc.poadapter.services;

public class UMEUserManagementFacadeProxy implements com.incture.pmc.poadapter.services.UMEUserManagementFacade {
  private String _endpoint = null;
  private com.incture.pmc.poadapter.services.UMEUserManagementFacade uMEUserManagementFacade = null;
  
  public UMEUserManagementFacadeProxy() {
    _initUMEUserManagementFacadeProxy();
  }
  
  public UMEUserManagementFacadeProxy(String endpoint) {
    _endpoint = endpoint;
    _initUMEUserManagementFacadeProxy();
  }
  
  private void _initUMEUserManagementFacadeProxy() {
    try {
      uMEUserManagementFacade = (new com.incture.pmc.poadapter.services.UMEUserManagementFacadeServiceLocator()).getUMEUserManagementFacadePort();
      if (uMEUserManagementFacade != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uMEUserManagementFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uMEUserManagementFacade)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uMEUserManagementFacade != null)
      ((javax.xml.rpc.Stub)uMEUserManagementFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.incture.pmc.poadapter.services.UMEUserManagementFacade getUMEUserManagementFacade() {
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade;
  }
  
  public com.incture.pmc.poadapter.services.UserDetailsDto getUserDetailsByUserId(java.lang.String userId) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUserDetailsByUserId(userId);
  }
  
  public com.incture.pmc.poadapter.services.UserGroupDto[] getAllUserGroup() throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getAllUserGroup();
  }
  
  public java.lang.String[] getUsersAssignedInGroup(java.lang.String userGroup) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUsersAssignedInGroup(userGroup);
  }
  
  public com.incture.pmc.poadapter.services.GroupInfoDto[] getUserGroupByuserId(java.lang.String userUniqueId) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUserGroupByuserId(userUniqueId);
  }
  
  public com.incture.pmc.poadapter.services.RoleInfoDto[] getUserRoleByuserId(java.lang.String userUniqueId) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUserRoleByuserId(userUniqueId);
  }
  
  public java.lang.String getUserEmailByuserId(java.lang.String userUniqueId) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUserEmailByuserId(userUniqueId);
  }
  
  public com.incture.pmc.poadapter.services.UserDetailsDto getLoggedInUser() throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getLoggedInUser();
  }
  
  public com.incture.pmc.poadapter.services.UserDto[] getAllUsers(java.lang.String userSearch) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getAllUsers(userSearch);
  }
  
  public java.lang.String[] getAllGroupsOfRole(java.lang.String roleId) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getAllGroupsOfRole(roleId);
  }
  
  public com.incture.pmc.poadapter.services.RoleInfoDto[] getAllUserRole() throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getAllUserRole();
  }
  
  public com.incture.pmc.poadapter.services.UserDto[] getUserDetailsAssignedInGroup(java.lang.String groupName) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUserDetailsAssignedInGroup(groupName);
  }
  
  public com.incture.pmc.poadapter.services.UserDetailsDto[] getUsersByRole(java.lang.String role) throws java.rmi.RemoteException{
    if (uMEUserManagementFacade == null)
      _initUMEUserManagementFacadeProxy();
    return uMEUserManagementFacade.getUsersByRole(role);
  }
  
  
}