/*
 * An XML document type.
 * Localname: problomatic-configuration
 * Namespace: http://www.bigtester.org/problomatic2
 * Java type: org.bigtester.problomatic2.ProblomaticConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic2.impl;
/**
 * A document containing one problomatic-configuration(@http://www.bigtester.org/problomatic2) element.
 *
 * This is a complex type.
 */
public class ProblomaticConfigurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bigtester.problomatic2.ProblomaticConfigurationDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProblomaticConfigurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROBLOMATICCONFIGURATION$0 = 
        new javax.xml.namespace.QName("http://www.bigtester.org/problomatic2", "problomatic-configuration");
    
    
    /**
     * Gets the "problomatic-configuration" element
     */
    public org.bigtester.problomatic2.ProblomaticConfiguration getProblomaticConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ProblomaticConfiguration target = null;
            target = (org.bigtester.problomatic2.ProblomaticConfiguration)get_store().find_element_user(PROBLOMATICCONFIGURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "problomatic-configuration" element
     */
    public void setProblomaticConfiguration(org.bigtester.problomatic2.ProblomaticConfiguration problomaticConfiguration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ProblomaticConfiguration target = null;
            target = (org.bigtester.problomatic2.ProblomaticConfiguration)get_store().find_element_user(PROBLOMATICCONFIGURATION$0, 0);
            if (target == null)
            {
                target = (org.bigtester.problomatic2.ProblomaticConfiguration)get_store().add_element_user(PROBLOMATICCONFIGURATION$0);
            }
            target.set(problomaticConfiguration);
        }
    }
    
    /**
     * Appends and returns a new empty "problomatic-configuration" element
     */
    public org.bigtester.problomatic2.ProblomaticConfiguration addNewProblomaticConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.bigtester.problomatic2.ProblomaticConfiguration target = null;
            target = (org.bigtester.problomatic2.ProblomaticConfiguration)get_store().add_element_user(PROBLOMATICCONFIGURATION$0);
            return target;
        }
    }
}
