<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="ies">  
		<html>
			<body>
				<h1>IES Luis Vives</h1>
				<img src="{img}" width="{img/@size}"/>
				<br/>
				<ul>
					<xsl:for-each select="ciclos/ciclo">
						<li>
							<xsl:value-of select="nombre"/>
							(<xsl:value-of select="@id"/>)
						</li>
					</xsl:for-each>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
