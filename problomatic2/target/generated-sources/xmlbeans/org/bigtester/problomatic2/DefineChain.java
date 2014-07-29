/*
 * XML Type:  define-chain
 * Namespace: http://www.bigtester.org/problomatic2
 * Java type: org.bigtester.problomatic2.DefineChain
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic2;


/**
 * An XML define-chain(@http://www.bigtester.org/problomatic2).
 *
 * This is a complex type.
 */
public interface DefineChain extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DefineChain.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s6E2DE3BD1A39A3327F11C564FD172AD5").resolveHandle("definechain344btype");
    
    /**
     * Gets array of all "chain-link" elements
     */
    org.bigtester.problomatic2.ChainLink[] getChainLinkArray();
    
    /**
     * Gets ith "chain-link" element
     */
    org.bigtester.problomatic2.ChainLink getChainLinkArray(int i);
    
    /**
     * Returns number of "chain-link" element
     */
    int sizeOfChainLinkArray();
    
    /**
     * Sets array of all "chain-link" element
     */
    void setChainLinkArray(org.bigtester.problomatic2.ChainLink[] chainLinkArray);
    
    /**
     * Sets ith "chain-link" element
     */
    void setChainLinkArray(int i, org.bigtester.problomatic2.ChainLink chainLink);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "chain-link" element
     */
    org.bigtester.problomatic2.ChainLink insertNewChainLink(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "chain-link" element
     */
    org.bigtester.problomatic2.ChainLink addNewChainLink();
    
    /**
     * Removes the ith "chain-link" element
     */
    void removeChainLink(int i);
    
    /**
     * Gets the "problem" attribute
     */
    java.lang.String getProblem();
    
    /**
     * Gets (as xml) the "problem" attribute
     */
    org.apache.xmlbeans.XmlString xgetProblem();
    
    /**
     * Sets the "problem" attribute
     */
    void setProblem(java.lang.String problem);
    
    /**
     * Sets (as xml) the "problem" attribute
     */
    void xsetProblem(org.apache.xmlbeans.XmlString problem);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.bigtester.problomatic2.DefineChain newInstance() {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bigtester.problomatic2.DefineChain parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bigtester.problomatic2.DefineChain parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bigtester.problomatic2.DefineChain parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bigtester.problomatic2.DefineChain parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bigtester.problomatic2.DefineChain parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bigtester.problomatic2.DefineChain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
