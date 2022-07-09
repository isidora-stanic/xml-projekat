<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:zh="www.rokzasok.rs/gradjanin/zahtev-za-sertifikat"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

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

                    .info-table tbody::after {
                    content: '';
                    display: table-row;
                    height: 15pt;
                    }

                    .info-table td {
                    padding-right: 10pt;
                    padding-bottom: 7pt;
                    }

                </style>
            </head>
            <body>
                <div class="center">
                    <div class="wrapper">
                        <div class="heading">
                            <h1>Zahtev za sertifikat
                                <xsl:choose>
                                    <xsl:when test="//zh:status='true'">
                                        <span id="status">[Odobren]</span>
                                    </xsl:when>
                                    <xsl:when test="//zh:status='false'">
                                        <span id="status">[Odbijen]</span>
                                    </xsl:when>
                                    <xsl:otherwise>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </h1>
                            <h3>Certificate request</h3>

                        </div>

                        <div class="info">
                            <p id="idKorisnika" style="display: none; color: white; font-size: 4pt;">ID korisnika: <xsl:value-of select="//zh:id"/></p>
                            <table class="info-table">
                                <tbody class="document-info">
                                    <tr>
                                        <td>
                                            <small>Broj dokumenta / Document no.: <strong>
                                                <xsl:value-of select="//zh:dokument_id"/></strong></small>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <small>Datum zahteva / Request issuing date: <strong>
                                                <xsl:value-of select="//zh:datum"/>
                                            </strong></small>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="last">
                                            <small>Mesto zahteva / Request issuing place: <strong>
                                                <xsl:value-of select="//zh:mesto"/></strong></small>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <hr/>
                            <table class="info-table">
                                <tbody class="person-info">
                                    <tr>
                                        <td>
                                            Ime i prezime / Name and surname:
                                        <strong><xsl:value-of select="concat(//zh:ime, ' ', //zh:prezime)"/></strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Datum rodjenja / Birth date:
                                        <strong><xsl:value-of select="//zh:datum_rodjenja"/></strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            JMBG:
                                        <strong><xsl:value-of select="//zh:jmbg"/></strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Broj pasosa / Passport number:
                                        <strong><xsl:value-of select="//zh:broj_pasosa"/></strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Pol / Sex:
                                        <strong><xsl:value-of select="//zh:pol"/></strong>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                           <hr/>
                            <table class="info-table">
                                <tbody class="person-info">
                                    <tr>
                                        <td>
                                            Razlog / Request reason:
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <xsl:value-of select="//zh:razlog_podnosenja" disable-output-escaping="yes"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>