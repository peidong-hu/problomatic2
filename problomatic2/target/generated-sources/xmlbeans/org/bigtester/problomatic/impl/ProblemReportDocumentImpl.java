/*
 * An XML document type.
 * Localname: problem-report
 * Namespace: http://www.bigtester.org/problomatic
 * Java type: org.bigtester.problomatic.ProblemReportDocument
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic.impl;
/**
 * A document containing one problem-report(@http://www.bigtester.org/problomatic) element.
 *
 * This is a complex type.
 */
public class ProblemReportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.bigtester.problomatic.ProblemReportDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProblemReportDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROBLEMREPORT$0 = 
        new javax.xml.namespace.QName("http://www.bigtester.org/problomatic", "problem-report");
    
    
    /**
     * Gets the "problem-report" element
     */
    public org.apache.xmlbeans.XmlObject getProblemReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(PROBLEMREPORT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "problem-report" element
     */
    public void setProblemReport(org.apache.xmlbeans.XmlObject problemReport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(PROBLEMREPORT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(PROBLEMREPORT$0);
            }
            target.set(problemReport);
        }
    }
    
    /**
     * Appends and returns a new empty "problem-report" element
     */
    public org.apache.xmlbeans.XmlObject addNewProblemReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(PROBLEMREPORT$0);
            return target;
        }
    }
}
