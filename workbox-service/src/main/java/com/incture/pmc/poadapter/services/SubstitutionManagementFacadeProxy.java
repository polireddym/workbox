package com.incture.pmc.poadapter.services;

public class SubstitutionManagementFacadeProxy implements com.incture.pmc.poadapter.services.SubstitutionManagementFacade {
  private String _endpoint = null;
  private com.incture.pmc.poadapter.services.SubstitutionManagementFacade substitutionManagementFacade = null;
  
  public SubstitutionManagementFacadeProxy() {
    _initSubstitutionManagementFacadeProxy();
  }
  
  public SubstitutionManagementFacadeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSubstitutionManagementFacadeProxy();
  }
  
  private void _initSubstitutionManagementFacadeProxy() {
    try {
      substitutionManagementFacade = (new com.incture.pmc.poadapter.services.SubstitutionManagementFacadeServiceLocator()).getSubstitutionManagementFacadePort();
      if (substitutionManagementFacade != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)substitutionManagementFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)substitutionManagementFacade)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (substitutionManagementFacade != null)
      ((javax.xml.rpc.Stub)substitutionManagementFacade)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionManagementFacade getSubstitutionManagementFacade() {
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade;
  }
  
  public com.incture.pmc.poadapter.services.ResponseDto createRule(com.incture.pmc.poadapter.services.SubstitutionRuleDto ruleDto) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.createRule(ruleDto);
  }
  
  public com.incture.pmc.poadapter.services.UserDto[] getSubstitutedUsers(java.lang.String substitutingUserString) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getSubstitutedUsers(substitutingUserString);
  }
  
  public com.incture.pmc.poadapter.services.UserDto[] getSubstituteUsers(java.lang.String substituteUserString) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getSubstituteUsers(substituteUserString);
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getActiveRulesBySubstitute(java.lang.String substitutingUser) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getActiveRulesBySubstitute(substitutingUser);
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getActiveRulesBySubstitutedUser(java.lang.String substitutedUser) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getActiveRulesBySubstitutedUser(substitutedUser);
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getInactiveRulesBySubstitute(java.lang.String substitutingUser) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getInactiveRulesBySubstitute(substitutingUser);
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getInactiveRulesBySubstitutedUser(java.lang.String substitutedUser) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getInactiveRulesBySubstitutedUser(substitutedUser);
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getRulesBySubstitutedUser(java.lang.String user) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getRulesBySubstitutedUser(user);
  }
  
  public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getRulesBySubstitute(java.lang.String user) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.getRulesBySubstitute(user);
  }
  
  public com.incture.pmc.poadapter.services.ResponseDto updateRule(com.incture.pmc.poadapter.services.SubstitutionRuleDto ruleDto) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.updateRule(ruleDto);
  }
  
  public com.incture.pmc.poadapter.services.ResponseDto deleteRule(com.incture.pmc.poadapter.services.SubstitutionRuleDto ruleDto) throws java.rmi.RemoteException{
    if (substitutionManagementFacade == null)
      _initSubstitutionManagementFacadeProxy();
    return substitutionManagementFacade.deleteRule(ruleDto);
  }
  
  
}