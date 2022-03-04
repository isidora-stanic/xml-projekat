<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                    font-family: Verdana, Geneva, Tahoma, sans-serif;
                    }

                    .center {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    }
                </style>
            </head>
            <body>
                <div class="center">
                    <div class="wrapper">
                        <div class="header">
                            <h1>Izvestaj o vakcinaciji</h1>
                            <hr />
                        </div>

                        <div class="opsti-podaci">
                            <table>
                                <tr>
                                    <td><strong>Broj interesovanja</strong></td>
                                    <td>
                                        <xsl:value-of select="//br_interesovanja"/></td>
                                </tr>
                                <tr>
                                    <td><strong>Broj primljenih zahteva za sertifikat</strong></td>
                                    <td>
                                        <xsl:value-of select="//br_primljenih_zahteva_za_sertifikat"/></td>
                                </tr>
                                <tr>
                                    <td><strong>Broj izdatih zahteva za sertifikat</strong></td>
                                    <td>
                                        <xsl:value-of select="//br_izdatih_zahteva_za_sertifikat"/></td>
                                </tr>
                            </table>

                            <hr />
                        </div>

                        <div class="podaci-doze">
                            <h2>Broj primljenih doza</h2>
                            <table>
                                <xsl:for-each select="//doza">
                                    <xsl:sort select="redni_broj_doze" order="ascending"/>
                                    <tr>
                                        <td><strong>
                                            <xsl:value-of select="redni_broj_doze"/></strong></td>
                                        <td>
                                            <xsl:value-of select="broj_datih"/></td>
                                    </tr>
                                </xsl:for-each>
                            </table>

                            <hr />
                        </div>

                        <div class="podaci-proizvodjaci">
                            <h2>Raspodela po proizvodjacima</h2>
                            <table>
                                <xsl:for-each select="//proizvodjac">
                                    <xsl:sort select="naziv" order="ascending"/>

                                    <tr>
                                        <td><strong>
                                            <xsl:value-of select="naziv"/></strong></td>
                                        <td>
                                            <xsl:value-of select="broj_primljenih_doza"/></td>
                                    </tr>
                                </xsl:for-each>
                            </table>

                            <hr />
                        </div>

                        <div class="datumi">
                            <p><strong>Datum izdavanja: </strong>
                                <xsl:value-of select="//datum_izdavanja"/></p>
                            <p><strong>Period izvestaja: </strong> od <strong>
                                <xsl:value-of select="//period_izvestaja/od"/></strong> do <strong>
                                <xsl:value-of select="//period_izvestaja/do"/></strong></p>
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>