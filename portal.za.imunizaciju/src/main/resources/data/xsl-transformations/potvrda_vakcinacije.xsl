<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:po="http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije">
    
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
                    
                </style>
            </head>

            <body>
                <div class="center">
                    <div class="wrapper">

                        <div class="header">
                            <h1>Potvrda vakcinacije</h1>
                            <h3>Vaccination certificate</h3>
                        </div>

                        <hr />

                        <div class="info">
                            <table class="info-table">
                                <tbody class="document-info">
                                    <tr>
                                        <td>
                                            <small>
                                                Broj dokumenta / Document no.: <strong><xsl:value-of select="//po:dokument_id" /></strong>
                                            </small>
                                        </td>
                                        <td class="last">
                                            <small>
                                                Datum izdavanja / Certificate issuing date: <strong><xsl:value-of select="//po:datum_izdavanja" /></strong>
                                            </small>
                                        </td>
                                    </tr> 
                                </tbody>
                                <tbody class="person-info">
                                    <tr>
                                        <td>
                                            <strong>Ime i prezime / Name and surname: </strong>
                                            <xsl:value-of select="concat(//po:ime, ' ', //po:prezime)"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Datum rodjenja / Birth date: </strong>
                                            <xsl:value-of select="//po:datum_rodjenja" />
                                        </td>
                                        <td>
                                            <strong>JMBG: </strong>
                                            <xsl:value-of select="//po:jmbg" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="last">
                                            <strong>Pol / Sex: </strong>
                                            <xsl:value-of select="//po:pol" />
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="vakcinacije-sep">
                            <hr />
                            <h2><strong>Vakcinacije / Vaccinations</strong></h2>
                            <hr />
                        </div>

                        <xsl:for-each select="//po:doza">
                            <xsl:sort select="po:broj_doze"/>
                            <div class="vakcinacija">
                                <table>
                                    <tr>
                                        <td><strong>DOZA / DOSE: </strong></td>
                                        <td><strong><xsl:value-of select="po:broj_doze" /></strong></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Datum primanja / Immunization date: </strong></td>
                                        <td><xsl:value-of select="po:datum" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Tip / Type: </strong></td>
                                        <td><xsl:value-of select="po:tip" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Proizvodjac / Manufacturer: </strong></td>
                                        <td><xsl:value-of select="po:proizvodjac" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Broj serije / Batch number: </strong></td>
                                        <td><xsl:value-of select="po:broj_serije" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Ustanova primanja / Immunazied at: </strong></td>
                                        <td><xsl:value-of select="po:ustanova/po:naziv" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Mesto / Place: </strong></td>
                                        <td><xsl:value-of select="po:ustanova/po:mesto" /></td>
                                    </tr>
                                </table>
                            </div>
                        </xsl:for-each>

                        <div class="razlog-sep">
                            <hr />
                            <h2><strong>Razlog izdavanja / Issuing purpose</strong></h2>
                            <hr />
                        </div>
                    
                        <table>
                            <tr>
                                <td><strong>Razlog / Purpose: </strong></td>
                                <td><xsl:value-of select="//po:razlog" /></td>
                            </tr>
                        </table>

                    </div>
                </div>
            </body>

        </html>
    </xsl:template>
    
</xsl:stylesheet>