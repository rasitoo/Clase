<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="tienda">
		<html>
			<body>
				<h3>COLECCIÓN DE RAQUETAS</h3>
				<img src="{img}" width="{img/@size}" />
				<br />
				<br />
				<br />
				<table border="1">
					<tr bgcolor="#CCEEFF">
						<th>MARCA</th>
						<th>MODELO</th>
						<th>ANO</th>
					</tr>
					<xsl:for-each select="raqueta">
						<tr>
							<td>
								<xsl:value-of select="marca" />
							</td>

							<xsl:choose>
								<xsl:when test="year > 2000">
									<td bgcolor="#C61A09">
										<xsl:value-of select="modelo" />
									</td>
								</xsl:when>
								<xsl:otherwise>
									<td bgcolor="#CCEEFF">
										<xsl:value-of select="modelo" />
									</td>
								</xsl:otherwise>
							</xsl:choose>

							<td>
								<xsl:value-of select="year" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>