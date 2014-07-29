/*
 * XML Type:  chain-link
 * Namespace: http://www.bigtester.org/problomatic2
 * Java type: org.bigtester.problomatic2.ChainLink
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic2.impl;
/**
 * An XML chain-link(@http://www.bigtester.org/problomatic2).
 *
 * This is a complex type.
 */
public class ChainLinkImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bigtester.problomatic2.ChainLink
{
    private static final long serialVersionUID = 1L;
    
    public ChainLinkImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTY$0 = 
        new javax.xml.namespace.QName("http://www.bigtester.org/problomatic2", "property");
    private static final javax.xml.namespace.QName HANDLER$2 = 
        new javax.xml.namespace.QName("", "handler");
    
    
    /**
     * Gets array of all "property" elements
     */
    public org.bigtester.problomatic2.Property[] getPropertyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(PROPERTY$0, targetList);
            org.bigtester.problomatic2.Property[] result = new org.bigtester.problomatic2.Property[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "property" element
     */
    public org.bigtester.problomatic2.Property getPropertyArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.Property target = null;
            target = (org.bigtester.problomatic2.Property)get_store().find_element_user(PROPERTY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "property" element
     */
    public int sizeOfPropertyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROPERTY$0);
        }
    }
    
    /**
     * Sets array of all "property" element
     */
    public void setPropertyArray(org.bigtester.problomatic2.Property[] propertyArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(propertyArray, PROPERTY$0);
        }
    }
    
    /**
     * Sets ith "property" element
     */
    public void setPropertyArray(int i, org.bigtester.problomatic2.Property property)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.Property target = null;
            target = (org.bigtester.problomatic2.Property)get_store().find_element_user(PROPERTY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(property);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "property" element
     */
    public org.bigtester.problomatic2.Property insertNewProperty(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.Property target = null;
            target = (org.bigtester.problomatic2.Property)get_store().insert_element_user(PROPERTY$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "property" element
     */
    public org.bigtester.problomatic2.Property addNewProperty()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.Property target = null;
            target = (org.bigtester.problomatic2.Property)get_store().add_element_user(PROPERTY$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "property" element
     */
    public void removeProperty(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROPERTY$0, i);
        }
    }
    
    /**
     * Gets the "handler" attribute
     */
    public java.lang.String getHandler()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HANDLER$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "handler" attribute
     */
    public org.apache.xmlbeans.XmlString xgetHandler()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(HANDLER$2);
            return target;
        }
    }
    
    /**
     * Sets the "handler" attribute
     */
    public void setHandler(java.lang.String handler)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HANDLER$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HANDLER$2);
            }
            target.setStringValue(handler);
        }
    }
    
    /**
     * Sets (as xml) the "handler" attribute
     */
    public void xsetHandler(org.apache.xmlbeans.XmlString handler)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(HANDLER$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(HANDLER$2);
            }
            target.set(handler);
        }
    }
}
