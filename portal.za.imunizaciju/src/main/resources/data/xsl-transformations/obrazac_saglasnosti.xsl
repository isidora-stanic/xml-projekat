<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:tp="http://www.rokzasok.rs/tipovi"
                xmlns:os="http://www.rokzasok.rs/gradjanin/obrazac-saglasnosti">
    <xsl:template match="/">
        <html>
            <head>
                <title>Obrazac saglasnosti</title>
                <style>
                    body {
                    font-family: Verdana, Geneva, Tahoma, sans-serif;
                    }

                    .center {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    }

                    .dokument-info {
                    margin-bottom: 10pt;
                    }

                    .agreement-info td {
                    padding-left: 15pt;
                    }

                    .citizenship-info::after {
                    content: '';
                    display: table-row;
                    height: 15pt;
                    }

                    .medic-info td {
                    padding-left: 15pt;
                    }

                    .previous-vaccinations-info {
                    margin-top: 15pt;
                    margin-left: 10pt;
                    }

                    .previous-vaccinations-info table{
                    border-collapse: collapse;
                    border: 1px solid black;
                    }

                    .previous-vaccinations-info th, .previous-vaccinations-info td {
                    padding: 5px;
                    margin-bottom: 5px; margin-right: 5px;
                    border: 1px solid black;
                    }
                </style>
            </head>
            <body>

                <div class="center">
                    <div class="wrapper">
                        <div class="heading">
                            <h1>Obrazac saglasnosti</h1>
                            <hr />
                        </div>

                        <div class="dokument-info">
                            <p><small>Br. dokumenta: <b><xsl:value-of select="//os:dokument_id" /></b></small></p>
                        </div>

                        <div class="agreement-info">
                            <table>
                                <tbody class="citizenship-info">
                                    <tr>
                                        <td><b>Drzavljanstvo:</b></td>
                                        <td>Republika Srbija</td>
                                        <td><b>JMBG: </b><xsl:value-of select="//tp:JMBG" /></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td><b>Broj pasosa: </b></td>
                                    </tr>
                                </tbody>
                                <tbody class="patient-info">
                                    <tr>
                                        <td><b>Prezime: </b><xsl:value-of select="//os:pacijent_info/os:prezime" /></td>
                                        <td><b>Ime: </b><xsl:value-of select="//os:pacijent_info/os:ime" /></td>
                                        <td><b>Ime roditelja: </b><xsl:value-of select="//os:ime_roditelja" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Adresa: </b><xsl:value-of select="//os:adresa/os:Mesto" />, <xsl:value-of select="//os:adresa/os:Opstina" /></td>
                                        <td><b>Ulica: </b><xsl:value-of select="//os:adresa/os:Ulica" /></td>
                                        <td><b>Broj: </b><xsl:value-of select="//os:adresa/os:Broj" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>E-mail: </b><xsl:value-of select="//os:kontakt/os:email" /></td>
                                        <td><b>Mobilni: </b><xsl:value-of select="//os:kontakt/os:tel_mobilni" /></td>
                                        <td><b>Fiksni: </b><xsl:value-of select="//os:kontakt/os:tel_fiksni" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Pol: </b><xsl:value-of select="//os:pol" /></td>
                                        <td><b>Datum rojdenja: </b><xsl:value-of select="//os:datum_rodjenja" /></td>
                                        <td><b>Mesto rodjenja: </b><xsl:value-of select="//os:pacijent/os:mesto_rodjenja" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Socijalna zastita: </b>
                                            <xsl:choose>
                                                <xsl:when test="//os:socijalna_zastita/os:korisnik = 'true'">&#9745;</xsl:when>
                                                <xsl:otherwise>&#9746;</xsl:otherwise>
                                            </xsl:choose></td>
                                        <td><b>Naziv ustanove: </b>
                                            <xsl:value-of select="//os:sediste/os:naziv"/></td>
                                        <td><b>Opstina: </b>
                                            <xsl:value-of select="//os:sediste/os:opstina"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>


                        <hr />

                        <div class="medic-info">
                            <table>
                                <tr>
                                    <td colspan="2"><b>Ustanova: </b><xsl:value-of select="//os:evidencija_vakcinacija/os:ustanova/os:naziv" /></td>
                                    <td><b>Punkt: </b><xsl:value-of select="//os:evidencija_vakcinacija/os:ustanova/os:punkt" /></td>
                                </tr>
                                <tr>
                                    <td><b>Lekar: </b><xsl:value-of select="concat(//os:lekar/os:ime, ' ', //os:lekar/os:prezime)" /></td>
                                    <td><b>Telefon: </b><xsl:value-of select="//os:lekar/os:telefon" /></td>
                                    <td><b>Fax: </b><xsl:value-of select="//os:lekar/os:fax"></xsl:value-of></td>
                                </tr>
                            </table>
                        </div>


                        <div class="previous-vaccinations-info">
                            <table>
                                <tr>
                                    <th><b>Doza</b></th>
                                    <th><b>Datum</b></th>
                                    <th><b>Tip</b></th>
                                    <th><b>Proizvodjac</b></th>
                                    <th><b>Br. serije</b></th>
<!--                                    <th><b>Ustanova</b></th>-->
<!--                                    <th><b>Punkt</b></th>-->
                                </tr>

                                <xsl:for-each select="//os:doza">
                                    <xsl:sort select="os:broj_doze" order="ascending" />
                                    <tr>
                                        <td><b><xsl:value-of select="os:broj_doze" /></b></td>
                                        <td><xsl:value-of select="os:datum" /></td>
                                        <td><xsl:value-of select="os:tip" />alo</td>
                                        <td><xsl:value-of select="os:proizvodjac" /></td>
                                        <td><xsl:value-of select="os:broj_serije" /></td>
<!--                                        <td><xsl:value-of select="os:ustanova/os:naziv" /></td>-->
<!--                                        <td><xsl:value-of select="os:ustanova/os:punkt" /></td>-->
                                    </tr>
                                </xsl:for-each>

                            </table>
                        </div>

                        <div class="countereffect-info">
                            <table>
                                <tr>
                                    <th colspan="2"><b>Privremene kontraindikacije</b></th>
                                </tr>
                                <tr>
                                    <td><b>Dijagnoza:</b></td>
                                    <td><xsl:value-of select="//os:privremene_kontraindikacije/os:dijagnoza" /></td>
                                </tr>
                                <tr>
                                    <td><b>Datum:</b></td>
                                    <td><xsl:value-of select="//os:privremene_kontraindikacije/os:datum" /></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>