/**
 * GroupInfoDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class GroupInfoDto  implements java.io.Serializable {
    private java.lang.String groupDiscription;

    private java.lang.String groupUniqName;

    public GroupInfoDto() {
    }

    public GroupInfoDto(
           java.lang.String groupDiscription,
           java.lang.String groupUniqName) {
           this.groupDiscription = groupDiscription;
           this.groupUniqName = groupUniqName;
    }


    /**
     * Gets the groupDiscription value for this GroupInfoDto.
     * 
     * @return groupDiscription
     */
    public java.lang.String getGroupDiscription() {
        return groupDiscription;
    }


    /**
     * Sets the groupDiscription value for this GroupInfoDto.
     * 
     * @param groupDiscription
     */
    public void setGroupDiscription(java.lang.String groupDiscription) {
        this.groupDiscription = groupDiscription;
    }


    /**
     * Gets the groupUniqName value for this GroupInfoDto.
     * 
     * @return groupUniqName
     */
    public java.lang.String getGroupUniqName() {
        return groupUniqName;
    }


    /**
     * Sets the groupUniqName value for this GroupInfoDto.
     * 
     * @param groupUniqName
     */
    public void setGroupUniqName(java.lang.String groupUniqName) {
        this.groupUniqName = groupUniqName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GroupInfoDto)) return false;
        GroupInfoDto other = (GroupInfoDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.groupDiscription==null && other.getGroupDiscription()==null) || 
             (this.groupDiscription!=null &&
              this.groupDiscription.equals(other.getGroupDiscription()))) &&
            ((this.groupUniqName==null && other.getGroupUniqName()==null) || 
             (this.groupUniqName!=null &&
              this.groupUniqName.equals(other.getGroupUniqName())));
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
        if (getGroupDiscription() != null) {
            _hashCode += getGroupDiscription().hashCode();
        }
        if (getGroupUniqName() != null) {
            _hashCode += getGroupUniqName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GroupInfoDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "groupInfoDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupDiscription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupDiscription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupUniqName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupUniqName"));
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
