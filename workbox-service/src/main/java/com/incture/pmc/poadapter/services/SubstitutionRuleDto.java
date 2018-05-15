/**
 * SubstitutionRuleDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.incture.pmc.poadapter.services;

public class SubstitutionRuleDto  implements java.io.Serializable {
    private boolean active;

    private java.lang.String displayStatus;

    private boolean enabled;

    private java.util.Calendar endDate;

    private java.lang.String mode;

    private java.lang.String ruleId;

    private java.util.Calendar startDate;

    private java.lang.String substitutedUser;

    private java.lang.String substitutedUserName;

    private java.lang.String substitutingUser;

    private java.lang.String substitutingUserName;

    private java.lang.String substitutionProfileId;

    private boolean takenOver;

    public SubstitutionRuleDto() {
    }

    public SubstitutionRuleDto(
           boolean active,
           java.lang.String displayStatus,
           boolean enabled,
           java.util.Calendar endDate,
           java.lang.String mode,
           java.lang.String ruleId,
           java.util.Calendar startDate,
           java.lang.String substitutedUser,
           java.lang.String substitutedUserName,
           java.lang.String substitutingUser,
           java.lang.String substitutingUserName,
           java.lang.String substitutionProfileId,
           boolean takenOver) {
           this.active = active;
           this.displayStatus = displayStatus;
           this.enabled = enabled;
           this.endDate = endDate;
           this.mode = mode;
           this.ruleId = ruleId;
           this.startDate = startDate;
           this.substitutedUser = substitutedUser;
           this.substitutedUserName = substitutedUserName;
           this.substitutingUser = substitutingUser;
           this.substitutingUserName = substitutingUserName;
           this.substitutionProfileId = substitutionProfileId;
           this.takenOver = takenOver;
    }


    /**
     * Gets the active value for this SubstitutionRuleDto.
     * 
     * @return active
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Sets the active value for this SubstitutionRuleDto.
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Gets the displayStatus value for this SubstitutionRuleDto.
     * 
     * @return displayStatus
     */
    public java.lang.String getDisplayStatus() {
        return displayStatus;
    }


    /**
     * Sets the displayStatus value for this SubstitutionRuleDto.
     * 
     * @param displayStatus
     */
    public void setDisplayStatus(java.lang.String displayStatus) {
        this.displayStatus = displayStatus;
    }


    /**
     * Gets the enabled value for this SubstitutionRuleDto.
     * 
     * @return enabled
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Sets the enabled value for this SubstitutionRuleDto.
     * 
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    /**
     * Gets the endDate value for this SubstitutionRuleDto.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this SubstitutionRuleDto.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the mode value for this SubstitutionRuleDto.
     * 
     * @return mode
     */
    public java.lang.String getMode() {
        return mode;
    }


    /**
     * Sets the mode value for this SubstitutionRuleDto.
     * 
     * @param mode
     */
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }


    /**
     * Gets the ruleId value for this SubstitutionRuleDto.
     * 
     * @return ruleId
     */
    public java.lang.String getRuleId() {
        return ruleId;
    }


    /**
     * Sets the ruleId value for this SubstitutionRuleDto.
     * 
     * @param ruleId
     */
    public void setRuleId(java.lang.String ruleId) {
        this.ruleId = ruleId;
    }


    /**
     * Gets the startDate value for this SubstitutionRuleDto.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this SubstitutionRuleDto.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the substitutedUser value for this SubstitutionRuleDto.
     * 
     * @return substitutedUser
     */
    public java.lang.String getSubstitutedUser() {
        return substitutedUser;
    }


    /**
     * Sets the substitutedUser value for this SubstitutionRuleDto.
     * 
     * @param substitutedUser
     */
    public void setSubstitutedUser(java.lang.String substitutedUser) {
        this.substitutedUser = substitutedUser;
    }


    /**
     * Gets the substitutedUserName value for this SubstitutionRuleDto.
     * 
     * @return substitutedUserName
     */
    public java.lang.String getSubstitutedUserName() {
        return substitutedUserName;
    }


    /**
     * Sets the substitutedUserName value for this SubstitutionRuleDto.
     * 
     * @param substitutedUserName
     */
    public void setSubstitutedUserName(java.lang.String substitutedUserName) {
        this.substitutedUserName = substitutedUserName;
    }


    /**
     * Gets the substitutingUser value for this SubstitutionRuleDto.
     * 
     * @return substitutingUser
     */
    public java.lang.String getSubstitutingUser() {
        return substitutingUser;
    }


    /**
     * Sets the substitutingUser value for this SubstitutionRuleDto.
     * 
     * @param substitutingUser
     */
    public void setSubstitutingUser(java.lang.String substitutingUser) {
        this.substitutingUser = substitutingUser;
    }


    /**
     * Gets the substitutingUserName value for this SubstitutionRuleDto.
     * 
     * @return substitutingUserName
     */
    public java.lang.String getSubstitutingUserName() {
        return substitutingUserName;
    }


    /**
     * Sets the substitutingUserName value for this SubstitutionRuleDto.
     * 
     * @param substitutingUserName
     */
    public void setSubstitutingUserName(java.lang.String substitutingUserName) {
        this.substitutingUserName = substitutingUserName;
    }


    /**
     * Gets the substitutionProfileId value for this SubstitutionRuleDto.
     * 
     * @return substitutionProfileId
     */
    public java.lang.String getSubstitutionProfileId() {
        return substitutionProfileId;
    }


    /**
     * Sets the substitutionProfileId value for this SubstitutionRuleDto.
     * 
     * @param substitutionProfileId
     */
    public void setSubstitutionProfileId(java.lang.String substitutionProfileId) {
        this.substitutionProfileId = substitutionProfileId;
    }


    /**
     * Gets the takenOver value for this SubstitutionRuleDto.
     * 
     * @return takenOver
     */
    public boolean isTakenOver() {
        return takenOver;
    }


    /**
     * Sets the takenOver value for this SubstitutionRuleDto.
     * 
     * @param takenOver
     */
    public void setTakenOver(boolean takenOver) {
        this.takenOver = takenOver;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubstitutionRuleDto)) return false;
        SubstitutionRuleDto other = (SubstitutionRuleDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.active == other.isActive() &&
            ((this.displayStatus==null && other.getDisplayStatus()==null) || 
             (this.displayStatus!=null &&
              this.displayStatus.equals(other.getDisplayStatus()))) &&
            this.enabled == other.isEnabled() &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.mode==null && other.getMode()==null) || 
             (this.mode!=null &&
              this.mode.equals(other.getMode()))) &&
            ((this.ruleId==null && other.getRuleId()==null) || 
             (this.ruleId!=null &&
              this.ruleId.equals(other.getRuleId()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.substitutedUser==null && other.getSubstitutedUser()==null) || 
             (this.substitutedUser!=null &&
              this.substitutedUser.equals(other.getSubstitutedUser()))) &&
            ((this.substitutedUserName==null && other.getSubstitutedUserName()==null) || 
             (this.substitutedUserName!=null &&
              this.substitutedUserName.equals(other.getSubstitutedUserName()))) &&
            ((this.substitutingUser==null && other.getSubstitutingUser()==null) || 
             (this.substitutingUser!=null &&
              this.substitutingUser.equals(other.getSubstitutingUser()))) &&
            ((this.substitutingUserName==null && other.getSubstitutingUserName()==null) || 
             (this.substitutingUserName!=null &&
              this.substitutingUserName.equals(other.getSubstitutingUserName()))) &&
            ((this.substitutionProfileId==null && other.getSubstitutionProfileId()==null) || 
             (this.substitutionProfileId!=null &&
              this.substitutionProfileId.equals(other.getSubstitutionProfileId()))) &&
            this.takenOver == other.isTakenOver();
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
        _hashCode += (isActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDisplayStatus() != null) {
            _hashCode += getDisplayStatus().hashCode();
        }
        _hashCode += (isEnabled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getMode() != null) {
            _hashCode += getMode().hashCode();
        }
        if (getRuleId() != null) {
            _hashCode += getRuleId().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getSubstitutedUser() != null) {
            _hashCode += getSubstitutedUser().hashCode();
        }
        if (getSubstitutedUserName() != null) {
            _hashCode += getSubstitutedUserName().hashCode();
        }
        if (getSubstitutingUser() != null) {
            _hashCode += getSubstitutingUser().hashCode();
        }
        if (getSubstitutingUserName() != null) {
            _hashCode += getSubstitutingUserName().hashCode();
        }
        if (getSubstitutionProfileId() != null) {
            _hashCode += getSubstitutionProfileId().hashCode();
        }
        _hashCode += (isTakenOver() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubstitutionRuleDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://incture.com/pmc/poadapter/services/", "substitutionRuleDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "displayStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enabled");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ruleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ruleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutedUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "substitutedUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutedUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "substitutedUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutingUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "substitutingUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutingUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "substitutingUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutionProfileId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "substitutionProfileId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("takenOver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "takenOver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
