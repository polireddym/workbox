/**
 * CustomAttributeDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class CustomAttributeDto  implements java.io.Serializable {
    private com.incture.pmc.poadapter.services.CustomAttributeDtoCustomAttributeEntry[] customAttribute;

    public CustomAttributeDto() {
    }

    public CustomAttributeDto(
           com.incture.pmc.poadapter.services.CustomAttributeDtoCustomAttributeEntry[] customAttribute) {
           this.customAttribute = customAttribute;
    }


    /**
     * Gets the customAttribute value for this CustomAttributeDto.
     * 
     * @return customAttribute
     */
    public com.incture.pmc.poadapter.services.CustomAttributeDtoCustomAttributeEntry[] getCustomAttribute() {
        return customAttribute;
    }


    /**
     * Sets the customAttribute value for this CustomAttributeDto.
     * 
     * @param customAttribute
     */
    public void setCustomAttribute(com.incture.pmc.poadapter.services.CustomAttributeDtoCustomAttributeEntry[] customAttribute) {
        this.customAttribute = customAttribute;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomAttributeDto)) return false;
        CustomAttributeDto other = (CustomAttributeDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customAttribute==null && other.getCustomAttribute()==null) || 
             (this.customAttribute!=null &&
              java.util.Arrays.equals(this.customAttribute, other.getCustomAttribute())));
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
        if (getCustomAttribute() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomAttribute());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomAttribute(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomAttributeDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "customAttributeDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customAttribute");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customAttribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", ">>customAttributeDto>customAttribute>entry"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "entry"));
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
