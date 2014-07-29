/*
 * XML Type:  problomatic-configuration
 * Namespace: http://www.bigtester.org/problomatic2
 * Java type: org.bigtester.problomatic2.ProblomaticConfiguration
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic2.impl;
/**
 * An XML problomatic-configuration(@http://www.bigtester.org/problomatic2).
 *
 * This is a complex type.
 */
public class ProblomaticConfigurationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bigtester.problomatic2.ProblomaticConfiguration
{
    private static final long serialVersionUID = 1L;
    
    public ProblomaticConfigurationImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULTPROPERTIES$0 = 
        new javax.xml.namespace.QName("http://www.bigtester.org/problomatic2", "default-properties");
    private static final javax.xml.namespace.QName DEFINECHAIN$2 = 
        new javax.xml.namespace.QName("http://www.bigtester.org/problomatic2", "define-chain");
    
    
    /**
     * Gets array of all "default-properties" elements
     */
    public org.bigtester.problomatic2.DefaultProperties[] getDefaultPropertiesArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DEFAULTPROPERTIES$0, targetList);
            org.bigtester.problomatic2.DefaultProperties[] result = new org.bigtester.problomatic2.DefaultProperties[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "default-properties" element
     */
    public org.bigtester.problomatic2.DefaultProperties getDefaultPropertiesArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefaultProperties target = null;
            target = (org.bigtester.problomatic2.DefaultProperties)get_store().find_element_user(DEFAULTPROPERTIES$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "default-properties" element
     */
    public int sizeOfDefaultPropertiesArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DEFAULTPROPERTIES$0);
        }
    }
    
    /**
     * Sets array of all "default-properties" element
     */
    public void setDefaultPropertiesArray(org.bigtester.problomatic2.DefaultProperties[] defaultPropertiesArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(defaultPropertiesArray, DEFAULTPROPERTIES$0);
        }
    }
    
    /**
     * Sets ith "default-properties" element
     */
    public void setDefaultPropertiesArray(int i, org.bigtester.problomatic2.DefaultProperties defaultProperties)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefaultProperties target = null;
            target = (org.bigtester.problomatic2.DefaultProperties)get_store().find_element_user(DEFAULTPROPERTIES$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(defaultProperties);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "default-properties" element
     */
    public org.bigtester.problomatic2.DefaultProperties insertNewDefaultProperties(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefaultProperties target = null;
            target = (org.bigtester.problomatic2.DefaultProperties)get_store().insert_element_user(DEFAULTPROPERTIES$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "default-properties" element
     */
    public org.bigtester.problomatic2.DefaultProperties addNewDefaultProperties()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefaultProperties target = null;
            target = (org.bigtester.problomatic2.DefaultProperties)get_store().add_element_user(DEFAULTPROPERTIES$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "default-properties" element
     */
    public void removeDefaultProperties(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DEFAULTPROPERTIES$0, i);
        }
    }
    
    /**
     * Gets array of all "define-chain" elements
     */
    public org.bigtester.problomatic2.DefineChain[] getDefineChainArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DEFINECHAIN$2, targetList);
            org.bigtester.problomatic2.DefineChain[] result = new org.bigtester.problomatic2.DefineChain[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "define-chain" element
     */
    public org.bigtester.problomatic2.DefineChain getDefineChainArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefineChain target = null;
            target = (org.bigtester.problomatic2.DefineChain)get_store().find_element_user(DEFINECHAIN$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "define-chain" element
     */
    public int sizeOfDefineChainArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DEFINECHAIN$2);
        }
    }
    
    /**
     * Sets array of all "define-chain" element
     */
    public void setDefineChainArray(org.bigtester.problomatic2.DefineChain[] defineChainArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(defineChainArray, DEFINECHAIN$2);
        }
    }
    
    /**
     * Sets ith "define-chain" element
     */
    public void setDefineChainArray(int i, org.bigtester.problomatic2.DefineChain defineChain)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefineChain target = null;
            target = (org.bigtester.problomatic2.DefineChain)get_store().find_element_user(DEFINECHAIN$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(defineChain);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "define-chain" element
     */
    public org.bigtester.problomatic2.DefineChain insertNewDefineChain(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefineChain target = null;
            target = (org.bigtester.problomatic2.DefineChain)get_store().insert_element_user(DEFINECHAIN$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "define-chain" element
     */
    public org.bigtester.problomatic2.DefineChain addNewDefineChain()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.DefineChain target = null;
            target = (org.bigtester.problomatic2.DefineChain)get_store().add_element_user(DEFINECHAIN$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "define-chain" element
     */
    public void removeDefineChain(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DEFINECHAIN$2, i);
        }
    }
}
