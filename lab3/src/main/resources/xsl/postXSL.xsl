<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <div class="container" align="center" valign="middle">
            <html>
                <head>
                    <body>
                        <p><center>Welcome on my lab 3</center></p>
                    </body>
                    <body>
                        <a href="/xsl/user">Users</a>
                    </body>
                </head>
            </html>
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>id</strong>
                    </td>
                    <td>
                        <strong>title</strong>
                    </td>
                    <td>
                        <strong>content</strong>
                    </td>
                    <td>
                        <strong>user_id</strong>
                    </td>
                </tr>
                <xsl:for-each select="postList/post">
                <tr>
                    <td>
                        <xsl:value-of select="id"/>
                    </td>
                    <td>
                        <xsl:value-of select="title"/>
                    </td>
                    <td>
                        <xsl:value-of select="content"/>
                    </td>
                    <td>
                        <xsl:value-of select="user_id"/>
                    </td>
                </tr>
                </xsl:for-each>
            </table>
        </div>
    </xsl:template>
</xsl:stylesheet>