/**
 * RoleInfoDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class RoleInfoDto  implements java.io.Serializable {
    private java.lang.String roleDescription;

    private java.lang.String roleUniqName;

    public RoleInfoDto() {
    }

    public RoleInfoDto(
           java.lang.String roleDescription,
           java.lang.String roleUniqName) {
           this.roleDescription = roleDescription;
           this.roleUniqName = roleUniqName;
    }


    /**
     * Gets the roleDescription value for this RoleInfoDto.
     * 
     * @return roleDescription
     */
    public java.lang.String getRoleDescription() {
        return roleDescription;
    }


    /**
     * Sets the roleDescription value for this RoleInfoDto.
     * 
     * @param roleDescription
     */
    public void setRoleDescription(java.lang.String roleDescription) {
        this.roleDescription = roleDescription;
    }


    /**
     * Gets the roleUniqName value for this RoleInfoDto.
     * 
     * @return roleUniqName
     */
    public java.lang.String getRoleUniqName() {
        return roleUniqName;
    }


    /**
     * Sets the roleUniqName value for this RoleInfoDto.
     * 
     * @param roleUniqName
     */
    public void setRoleUniqName(java.lang.String roleUniqName) {
        this.roleUniqName = roleUniqName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RoleInfoDto)) return false;
        RoleInfoDto other = (RoleInfoDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.roleDescription==null && other.getRoleDescription()==null) || 
             (this.roleDescription!=null &&
              this.roleDescription.equals(other.getRoleDescription()))) &&
            ((this.roleUniqName==null && other.getRoleUniqName()==null) || 
             (this.roleUniqName!=null &&
              this.roleUniqName.equals(other.getRoleUniqName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRoleDescription() != null) {
            _hashCode += getRoleDescription().hashCode();
        }
        if (getRoleUniqName() != null) {
            _hashCode += getRoleUniqName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RoleInfoDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "roleInfoDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleUniqName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleUniqName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
