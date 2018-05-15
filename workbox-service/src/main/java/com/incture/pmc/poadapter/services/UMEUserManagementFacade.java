/**
 * UMEUserManagementFacade.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public interface UMEUserManagementFacade extends java.rmi.Remote {
    public com.incture.pmc.poadapter.services.UserDetailsDto getUserDetailsByUserId(java.lang.String userId) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserGroupDto[] getAllUserGroup() throws java.rmi.RemoteException;
    public java.lang.String[] getUsersAssignedInGroup(java.lang.String userGroup) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.GroupInfoDto[] getUserGroupByuserId(java.lang.String userUniqueId) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.RoleInfoDto[] getUserRoleByuserId(java.lang.String userUniqueId) throws java.rmi.RemoteException;
    public java.lang.String getUserEmailByuserId(java.lang.String userUniqueId) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserDetailsDto getLoggedInUser() throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserDto[] getAllUsers(java.lang.String userSearch) throws java.rmi.RemoteException;
    public java.lang.String[] getAllGroupsOfRole(java.lang.String roleId) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.RoleInfoDto[] getAllUserRole() throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserDto[] getUserDetailsAssignedInGroup(java.lang.String groupName) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.UserDetailsDto[] getUsersByRole(java.lang.String role) throws java.rmi.RemoteException;
}
