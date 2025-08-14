<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="tienda">  
		<html>
			<body>
				<h3>COLECCIÓN DE RAQUETAS</h3>
				<img src="{img}" width="{img/@size}"/>
				<br/><br/><br/>
				<ol >
					<li >
						<ol >
						 <li>MARCA</li>
						 <li>MODELO</li>
						 <li>ANO</li>
					    </ol>
					</li>

					<xsl:for-each select="raqueta[ marca = 'YONEX' or marca = 'BABOLAT' ]">
<li >
						<ol>
							<li>
								<xsl:value-of select="marca"/> 
							</li>
							<li>
								<xsl:value-of select="modelo"/>
							</li>
							<li>
								<xsl:value-of select="year"/>
							</li>
						</ol>
</li>
					</xsl:for-each>
				</ol>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
