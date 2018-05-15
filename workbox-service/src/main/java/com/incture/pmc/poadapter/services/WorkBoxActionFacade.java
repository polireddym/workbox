/**
 * WorkBoxActionFacade.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public interface WorkBoxActionFacade extends java.rmi.Remote {
    public boolean claimTask(java.lang.String taskInstanceId) throws java.rmi.RemoteException;
    public boolean release(java.lang.String taskInstanceId) throws java.rmi.RemoteException;
    public boolean delegate(java.lang.String taskInstanceId, java.lang.String userId) throws java.rmi.RemoteException;
    public java.lang.String addNote(java.lang.String taskInstanceId, java.lang.String content) throws java.rmi.RemoteException;
    public boolean complete(java.lang.String taskInstanceId, java.lang.String action) throws java.rmi.RemoteException;
    public com.incture.pmc.poadapter.services.NoteDto[] getNotes(java.lang.String taskInstanceId) throws java.rmi.RemoteException;
    public java.lang.String claimAndDelegate(java.lang.String taskInstanceId, java.lang.String userId) throws java.rmi.RemoteException;
    public java.lang.String nominate(java.lang.String taskInstanceId, java.lang.String userId) throws java.rmi.RemoteException;
}
