/*
 * XML Type:  define-chain
 * Namespace: http://www.bigtester.org/problomatic2
 * Java type: org.bigtester.problomatic2.DefineChain
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic2.impl;
/**
 * An XML define-chain(@http://www.bigtester.org/problomatic2).
 *
 * This is a complex type.
 */
public class DefineChainImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bigtester.problomatic2.DefineChain
{
    private static final long serialVersionUID = 1L;
    
    public DefineChainImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHAINLINK$0 = 
        new javax.xml.namespace.QName("http://www.bigtester.org/problomatic2", "chain-link");
    private static final javax.xml.namespace.QName PROBLEM$2 = 
        new javax.xml.namespace.QName("", "problem");
    
    
    /**
     * Gets array of all "chain-link" elements
     */
    public org.bigtester.problomatic2.ChainLink[] getChainLinkArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CHAINLINK$0, targetList);
            org.bigtester.problomatic2.ChainLink[] result = new org.bigtester.problomatic2.ChainLink[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "chain-link" element
     */
    public org.bigtester.problomatic2.ChainLink getChainLinkArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ChainLink target = null;
            target = (org.bigtester.problomatic2.ChainLink)get_store().find_element_user(CHAINLINK$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "chain-link" element
     */
    public int sizeOfChainLinkArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CHAINLINK$0);
        }
    }
    
    /**
     * Sets array of all "chain-link" element
     */
    public void setChainLinkArray(org.bigtester.problomatic2.ChainLink[] chainLinkArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(chainLinkArray, CHAINLINK$0);
        }
    }
    
    /**
     * Sets ith "chain-link" element
     */
    public void setChainLinkArray(int i, org.bigtester.problomatic2.ChainLink chainLink)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ChainLink target = null;
            target = (org.bigtester.problomatic2.ChainLink)get_store().find_element_user(CHAINLINK$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(chainLink);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "chain-link" element
     */
    public org.bigtester.problomatic2.ChainLink insertNewChainLink(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ChainLink target = null;
            target = (org.bigtester.problomatic2.ChainLink)get_store().insert_element_user(CHAINLINK$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "chain-link" element
     */
    public org.bigtester.problomatic2.ChainLink addNewChainLink()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ChainLink target = null;
            target = (org.bigtester.problomatic2.ChainLink)get_store().add_element_user(CHAINLINK$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "chain-link" element
     */
    public void removeChainLink(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CHAINLINK$0, i);
        }
    }
    
    /**
     * Gets the "problem" attribute
     */
    public java.lang.String getProblem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROBLEM$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "problem" attribute
     */
    public org.apache.xmlbeans.XmlString xgetProblem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROBLEM$2);
            return target;
        }
    }
    
    /**
     * Sets the "problem" attribute
     */
    public void setProblem(java.lang.String problem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROBLEM$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROBLEM$2);
            }
            target.setStringValue(problem);
        }
    }
    
    /**
     * Sets (as xml) the "problem" attribute
     */
    public void xsetProblem(org.apache.xmlbeans.XmlString problem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROBLEM$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROBLEM$2);
            }
            target.set(problem);
        }
    }
}
