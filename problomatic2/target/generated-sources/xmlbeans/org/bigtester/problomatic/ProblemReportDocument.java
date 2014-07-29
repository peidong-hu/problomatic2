/*
 * An XML document type.
 * Localname: problem-report
 * Namespace: http://www.bigtester.org/problomatic
 * Java type: org.bigtester.problomatic.ProblemReportDocument
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic;


/**
 * A document containing one problem-report(@http://www.bigtester.org/problomatic) element.
 *
 * This is a complex type.
 */
public interface ProblemReportDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProblemReportDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s6E2DE3BD1A39A3327F11C564FD172AD5").resolveHandle("problemreportb6e4doctype");
    
    /**
     * Gets the "problem-report" element
     */
    org.apache.xmlbeans.XmlObject getProblemReport();
    
    /**
     * Sets the "problem-report" element
     */
    void setProblemReport(org.apache.xmlbeans.XmlObject problemReport);
    
    /**
     * Appends and returns a new empty "problem-report" element
     */
    org.apache.xmlbeans.XmlObject addNewProblemReport();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.bigtester.problomatic.ProblemReportDocument newInstance() {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bigtester.problomatic.ProblemReportDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bigtester.problomatic.ProblemReportDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bigtester.problomatic.ProblemReportDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bigtester.problomatic.ProblemReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
