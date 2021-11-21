<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Órarend</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:left">id</th>
                        <th style="text-align:left">típus</th>
                        <th style="text-align:left">targy</th>
                        <th style="text-align:left">helyszin</th>
                        <th style="text-align:left">oktato</th>
                        <th style="text-align:left">szak</th>
                        <th style="text-align:left">nap</th>
                        <th style="text-align:left">tol</th>
                        <th style="text-align:left">ig</th>
                    </tr>
                    <xsl:for-each select="napok/hétfő/ora">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@típus"/></td>
                            <td><xsl:value-of select="targy"/></td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>
                            <td><xsl:value-of select="idopont/@nap"/></td>
                            <td><xsl:value-of select="idopont/@tol"/></td>
                            <td><xsl:value-of select="idopont/@ig"/></td>
                        </tr>
                    </xsl:for-each>
                    <xsl:for-each select="napok/kedd/ora">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@típus"/></td>
                            <td><xsl:value-of select="targy"/></td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>
                            <td><xsl:value-of select="idopont/@nap"/></td>
                            <td><xsl:value-of select="idopont/@tol"/></td>
                            <td><xsl:value-of select="idopont/@ig"/></td>
                        </tr>
                    </xsl:for-each>
                    <xsl:for-each select="napok/szerda/ora">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@típus"/></td>
                            <td><xsl:value-of select="targy"/></td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>
                            <td><xsl:value-of select="idopont/@nap"/></td>
                            <td><xsl:value-of select="idopont/@tol"/></td>
                            <td><xsl:value-of select="idopont/@ig"/></td>
                        </tr>
                    </xsl:for-each>
                    <xsl:for-each select="napok/csütörtök/ora">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@típus"/></td>
                            <td><xsl:value-of select="targy"/></td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>
                            <td><xsl:value-of select="idopont/@nap"/></td>
                            <td><xsl:value-of select="idopont/@tol"/></td>
                            <td><xsl:value-of select="idopont/@ig"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>