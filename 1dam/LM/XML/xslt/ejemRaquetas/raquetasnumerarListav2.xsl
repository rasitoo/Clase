<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/tienda/raqueta">  
				Raqueta:
				<br/>
					<xsl:number count="raqueta" from="raqueta[2]" 
					format="i."/>
					<xsl:value-of select="modelo"/> 
	</xsl:template>
</xsl:stylesheet>
