<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:ds="http://www.rokzasok.rs/sluzbenik/digitalni-sertifikat"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:param name="qr_link" select="//ds:qr_link"/>
    <xsl:template match="/">

        <html lang="en">
            <head>
                <title>Digitalni sertifikat</title>
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

                    .grayed {
                    background-color: lightgray;
                    }
                </style>
            </head>
            <body>
                <div class="center">
                    <div class="wrapper">
                        <div class="header">
                            <h1>Digitalni sertifikat</h1>
                            <h3>Digital certificate</h3>
                            <img src="https://chart.googleapis.com/chart?cht=qr&amp;chl={$qr_link}&amp;chs=160x160&amp;chld=L|0" class="qr-code img-thumbnail img-responsive"/>
                        </div>
                        <hr />

                        <div class="info">
                            <table class="info-table">
                                <tbody class="document-info">
                                    <p id="idKorisnika" style="display: none; color: white; font-size: 4pt;">ID korisnika: <xsl:value-of select="//ds:id"/></p>
                                    <tr>
                                        <td>
                                            <small>Broj dokumenta / Document no.: <strong>
                                                <xsl:value-of select="//ds:dokument_id"/></strong></small>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <small>Datum izdavanja / Certificate issuing date: <strong>
                                                <xsl:variable name="di" select="//ds:info_o_sertifikatu/ds:datum" />
                                                <xsl:value-of select="substring-before($di,'T')" />,  <xsl:value-of select="substring-before(substring-after($di,'T'), '.')" />
                                            </strong></small>

                                        </td>
                                    </tr>
                                </tbody>
                                <tbody class="person-info">
                                    <tr>
                                        <td>
                                            <strong>Ime i prezime / Name and surname: </strong>
                                            <xsl:value-of select="concat(//ds:ime, ' ', //ds:prezime)"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Datum rodjenja / Birth date: </strong>
                                            <xsl:value-of select="//ds:datum_rodjenja"/>
                                        </td>
                                        <td>
                                            <strong>JMBG: </strong>
                                            <xsl:value-of select="//ds:jmbg"/>
                                        </td>
                                    </tr>
<!--                                    <tr>-->
<!--                                        <td>-->
<!--                                            <strong>Mesto: </strong>-->
<!--                                            <xsl:value-of select="//ds:TAdresa/ds:Mesto"/>-->
<!--                                        </td>-->
<!--                                        <td>-->
<!--                                            <strong>Ulica: </strong>-->
<!--                                            <xsl:value-of-->
<!--                                                    select="concat(//ds:adresa/ds:Ulica, ' ', //ds:adresa/ds:Broj)"/>-->
<!--                                        </td>-->
<!--                                    </tr>-->
                                    <tr>
                                        <td class="last">
                                            <strong>Broj pasosa / Passport no. </strong>
                                            <xsl:value-of select="//ds:broj_pasosa"/>
                                        </td>
                                        <td class="last">
                                            <strong>Pol / Sex: </strong>
                                            <xsl:value-of select="//ds:pol"/>
                                        </td>

                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <hr />
                        <h2><strong>Vakcinacije / Vaccinations</strong></h2>
                        <hr />

                        <xsl:for-each select="//ds:doza">
                            <div class="vakcinacija">
                                <table>
                                    <tr>
                                        <td><strong>DOZA / DOSE: </strong></td>
                                        <td><strong><xsl:value-of select="ds:broj_doze"/></strong></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Datum primanja / Immunization date: </strong></td>
                                        <td><xsl:value-of select="ds:datum"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Tip / Type: </strong></td>
                                        <td><xsl:value-of select="ds:tip"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Proizvodjac / Manufacturer: </strong></td>
                                        <td><xsl:value-of select="ds:proizvodjac"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Broj serije / Batch number: </strong></td>
                                        <td><xsl:value-of select="ds:broj_serije"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Ustanova primanja / Immunazied at: </strong></td>
                                        <td><xsl:value-of select="ds:ustanova/ds:naziv"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Mesto / Place: </strong></td>
                                        <td><xsl:value-of select="ds:ustanova/ds:mesto"/></td>
                                    </tr>
                                </table>
                            </div>
                        </xsl:for-each>



                        <hr />
                        <h2><strong>Testovi / Tests</strong></h2>
                        <hr />

                        <xsl:for-each select="//ds:test">
                            <div class="vakcinacija">
                                <table>
                                    <tr>
                                        <td><strong>Naziv / Name: </strong></td>
                                        <td><xsl:value-of select="ds:naziv"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Opis / Description: </strong></td>
                                        <td><xsl:value-of select="ds:opis"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Vrsta uzorkovanja / Sampling type: </strong></td>
                                        <td><xsl:value-of select="ds:vrsta_uzorka"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Datum uzorkovanja / Sampling date: </strong></td>
                                        <td><xsl:value-of select="ds:datum_i_vreme_uzorkovanja"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Datum izdavanja rezultata / Result date: </strong></td>
                                        <td><xsl:value-of select="ds:datum_i_vreme_rezultata"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Proizvodjac / Manufacturer: </strong></td>
                                        <td><xsl:value-of select="ds:proizvodjac"/></td>
                                    </tr>
                                    <tr class="grayed">
                                        <td><strong>Rezultat / Results: </strong></td>
                                        <td><strong><xsl:value-of select="ds:rezultat"/></strong></td>
                                    </tr>
                                    <tr class="grayed">
                                        <td><strong>Laboratorija / Laboratory: </strong></td>
                                        <td><xsl:value-of select="ds:laboratorija"/></td>
                                    </tr>
                                </table>
                            </div>
                        </xsl:for-each>

                        <hr />
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>