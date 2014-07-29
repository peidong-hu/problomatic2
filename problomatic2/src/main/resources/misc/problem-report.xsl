<?xml version="1.0" encoding="UTF-8"?>

<xsl:transform version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:html="http://www.w3.org/1999/xhtml">

  <xsl:template match="/">

  <html>	
  <body>
    <h1>Problem Report</h1>
    <p>
<xsl:value-of select="/problem/@class-name"/> occured on <xsl:value-of select="/problem/@occuredOn"/>
</p>
	<h2>Underlying Exceptions</h2>
		<xsl:for-each select="/problem/underlying-exceptions/exception">
			<h3>
				<a>
					<xsl:attribute name="href">http://www.google.com/search?q=<xsl:value-of select="@class-name"/></xsl:attribute>
					<xsl:value-of select="@class-name"/>
				</a>	
			</h3>
			<i><xsl:value-of select="message"/></i><br/>
			<xsl:value-of select="stack-trace"/>
			<p/>
		</xsl:for-each>
	<p/>
	
	<h2>Messages</h2>
	<ul>
		<xsl:for-each select="/problem/messages/message">
			<li><xsl:value-of select="text()"/></li>
		</xsl:for-each>
	</ul>
	<p/>
	
	<h2>Attributes</h2>
    <table width="100%" border="1">
      <xsl:for-each select="/problem/attributes/attribute">
        <tr>
          <td>
			<xsl:value-of select="@name"/>
		</td>
         <td>
			<xsl:value-of select="value"/>
		</td>
        </tr>
    </xsl:for-each>
   </table>
   </body>
   </html>
  </xsl:template>

</xsl:transform>
