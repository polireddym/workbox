/**
 * SubstitutionManagementFacade.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public interface SubstitutionManagementFacade extends java.rmi.Remote {
    public com.incture.pmc.poadapter.services.ResponseDto createRule(com.incture.pmc.poadapter.services.SubstitutionRuleDto ruleDto) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserDto[] getSubstitutedUsers(java.lang.String substitutingUserString) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserDto[] getSubstituteUsers(java.lang.String substituteUserString) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getActiveRulesBySubstitute(java.lang.String substitutingUser) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getActiveRulesBySubstitutedUser(java.lang.String substitutedUser) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getInactiveRulesBySubstitute(java.lang.String substitutingUser) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getInactiveRulesBySubstitutedUser(java.lang.String substitutedUser) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getRulesBySubstitutedUser(java.lang.String user) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.SubstitutionRuleDto[] getRulesBySubstitute(java.lang.String user) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.ResponseDto updateRule(com.incture.pmc.poadapter.services.SubstitutionRuleDto ruleDto) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.ResponseDto deleteRule(com.incture.pmc.poadapter.services.SubstitutionRuleDto ruleDto) throws java.rmi.RemoteException;
}
