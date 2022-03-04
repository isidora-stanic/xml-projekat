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

                    .vakcinacija {
                    border-bottom: 1pt dashed black;
                    border-top: 1pt dashed black;
                    font-size: small;
                    }

                    .vakcinacija td {
                    padding-left: 30pt;
                    }

                    .reason td {
                    border-top: 1px solid black;
                    }
                </style>
            </head>
            <body>
                <div class="center">
                    <div class="wrapper">
                        <div class="heading">
                            <h1>Zahtev za sertifikat</h1>
                            <h3>Certificate request</h3>
                            <hr />
                        </div>

                        <div class="info">
                            <table class="info-table">
                                <tbody class="document-info">
                                    <tr>
                                        <td>
                                            <small>Broj dokumenta / Document no.: <strong>
                                                <xsl:value-of select="//zh:dokument_id"/></strong></small>
                                        </td>
                                        <td>
                                            <small>Datum zahteva / Request issuing date: <strong>
                                                <xsl:value-of select="//zh:datum"/></strong></small>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="last">
                                            <small>Mesto zahteva / Request issuing place: <strong>
                                                <xsl:value-of select="//zh:mesto"/></strong></small>
                                        </td>
                                    </tr>
                                </tbody>
                                <tbody class="person-info">
                                    <tr>
                                        <td>
                                            <strong>Ime i prezime / Name and surname: </strong>
                                            <xsl:value-of select="concat(//zh:ime, ' ', //zh:prezime)"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Datum rodjenja / Birth date: </strong>
                                            <xsl:value-of select="//zh:datum_rodjenja"/>
                                        </td>
                                        <td>
                                            <strong>JMBG: </strong>
                                            <xsl:value-of select="//zh:jmbg"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Pol / Sex: </strong>
                                            <xsl:value-of select="//zh:pol"/>
                                        </td>
                                        <td>
                                            <strong>Broj pasosa / Passport number: </strong>
                                            <xsl:value-of select="//zh:broj_pasosa"/>
                                        </td>
                                    </tr>
                                    <tr class="reason">
                                        <td class="last">
                                            <strong>Razlog / Request reason: </strong>
                                        </td>
                                        <td class="last">
                                            <xsl:value-of select="//zh:razlog_podnosenja"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                            <hr />
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>