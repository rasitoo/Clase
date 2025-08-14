<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="trayecto">
		<html>
			<body>
				<h2  style="color:#ff0000">Código usuario: <xsl:value-of select="//codigoUsuario"/>
				</h2>
				<h2  style="color:#00ff00">Nombre: <xsl:value-of select="//nombre"/>
				</h2>
				<h3>Ciudad origen: <xsl:value-of select="//puntoOrigen/pais/@ciudad"/>
 ---> Ciudad destino: <xsl:value-of select="//puntoDestino/@ciudad"/>
			</h3>

			<table border="1">
				<legend>Puntos intermedios</legend>
				<tr bgcolor="#CCEEFF">
					<th>Ciudad</th>
					<th>Latitud</th>
					<th>Longitud</th>
				</tr>
				<xsl:for-each select="puntoIntermedio">
					<tr>
						
						<td>
							
							<xsl:value-of select="@ciudad" />
							<xsl:if test="@ciudad = null">
								NA
							</xsl:if>
						</td>
						<td>
							<xsl:value-of select="latitud" />
						</td>
						<td>
							<xsl:value-of select="longitud" />
						</td>
					</tr>
				</xsl:for-each>
			</table>

			<h3>Longitudes de los <xsl:value-of select="count(puntoIntermedio)" /> puntos intermedios</h3>

			<ol>
				<xsl:for-each select="puntoIntermedio">
					<li><xsl:value-of select="longitud" /></li>
				</xsl:for-each>
			</ol>

			<h2>Mejor ciudad: <xsl:value-of select="//mejorCiudad" /></h2>

		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
