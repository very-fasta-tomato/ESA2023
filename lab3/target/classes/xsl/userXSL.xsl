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
                        <a href="/xsl/post">Posts</a>
                    </body>
                </head>
            </html>
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>id</strong>
                    </td>
                    <td>
                        <strong>username</strong>
                    </td>
                </tr>
                <xsl:for-each select="userList/user">
                    <tr>
                        <td>
                            <xsl:value-of select="id"/>
                        </td>
                        <td>
                            <xsl:value-of select="username"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>
    </xsl:template>
</xsl:stylesheet>
