/*
 * XML Type:  problomatic-configuration
 * Namespace: http://www.bigtester.org/problomatic2
 * Java type: org.bigtester.problomatic2.ProblomaticConfiguration
 *
 * Automatically generated - do not modify.
 */
package org.bigtester.problomatic2;


/**
 * An XML problomatic-configuration(@http://www.bigtester.org/problomatic2).
 *
 * This is a complex type.
 */
public interface ProblomaticConfiguration extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProblomaticConfiguration.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s6E2DE3BD1A39A3327F11C564FD172AD5").resolveHandle("problomaticconfiguration1db5type");
    
    /**
     * Gets array of all "default-properties" elements
     */
    org.bigtester.problomatic2.DefaultProperties[] getDefaultPropertiesArray();
    
    /**
     * Gets ith "default-properties" element
     */
    org.bigtester.problomatic2.DefaultProperties getDefaultPropertiesArray(int i);
    
    /**
     * Returns number of "default-properties" element
     */
    int sizeOfDefaultPropertiesArray();
    
    /**
     * Sets array of all "default-properties" element
     */
    void setDefaultPropertiesArray(org.bigtester.problomatic2.DefaultProperties[] defaultPropertiesArray);
    
    /**
     * Sets ith "default-properties" element
     */
    void setDefaultPropertiesArray(int i, org.bigtester.problomatic2.DefaultProperties defaultProperties);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "default-properties" element
     */
    org.bigtester.problomatic2.DefaultProperties insertNewDefaultProperties(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "default-properties" element
     */
    org.bigtester.problomatic2.DefaultProperties addNewDefaultProperties();
    
    /**
     * Removes the ith "default-properties" element
     */
    void removeDefaultProperties(int i);
    
    /**
     * Gets array of all "define-chain" elements
     */
    org.bigtester.problomatic2.DefineChain[] getDefineChainArray();
    
    /**
     * Gets ith "define-chain" element
     */
    org.bigtester.problomatic2.DefineChain getDefineChainArray(int i);
    
    /**
     * Returns number of "define-chain" element
     */
    int sizeOfDefineChainArray();
    
    /**
     * Sets array of all "define-chain" element
     */
    void setDefineChainArray(org.bigtester.problomatic2.DefineChain[] defineChainArray);
    
    /**
     * Sets ith "define-chain" element
     */
    void setDefineChainArray(int i, org.bigtester.problomatic2.DefineChain defineChain);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "define-chain" element
     */
    org.bigtester.problomatic2.DefineChain insertNewDefineChain(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "define-chain" element
     */
    org.bigtester.problomatic2.DefineChain addNewDefineChain();
    
    /**
     * Removes the ith "define-chain" element
     */
    void removeDefineChain(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.bigtester.problomatic2.ProblomaticConfiguration newInstance() {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.bigtester.problomatic2.ProblomaticConfiguration parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.bigtester.problomatic2.ProblomaticConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
