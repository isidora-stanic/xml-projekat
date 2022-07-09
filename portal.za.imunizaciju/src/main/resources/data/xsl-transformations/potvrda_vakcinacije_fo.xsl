<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:po="http://www.rokzasok.rs/zdravstveni-radnik/potvrda-vakcinacije"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bookstore-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="bookstore-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="sans-serif" font-size="x-large" font-weight="bold" padding="10px 10px 0px 10px">
                        Potvrda vakcinacije
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="medium" font-weight="bold" padding="10px 10px 0px 10px">
                        Vaccination certificate
                    </fo:block>

                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>

                    <fo:block>
                        <fo:table font-family="sans-serif">
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell font-family="sans-serif" padding-right="10px" padding-bottom="15px" font-size="small">
                                        <fo:block>
                                            Broj dokumenta / Document no.:
                                            <fo:inline font-weight="bold"><xsl:value-of select="//po:dokument_id" /></fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell font-family="sans-serif" padding-right="10px" padding-bottom="15px" font-size="small">
                                        <fo:block>
                                            Datum izdavanja / Certificate issuing date:
                                            <fo:inline font-weight="bold"><xsl:value-of select="//po:datum_izdavanja"/></fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-family="sans-serif" padding-right="10px" padding-bottom="7px" >
                                        <fo:block>
                                            <fo:inline font-weight="bold">Ime i prezime / Name and surname: </fo:inline>
                                            <xsl:value-of select="concat(//po:ime, ' ', //po:prezime)" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-family="sans-serif" padding-right="10px" padding-bottom="7px" >
                                        <fo:block>
                                            <fo:inline font-weight="bold">Datum rodjenja / Birth date: </fo:inline>
                                            <xsl:value-of select="//po:datum_rodjenja"/>
                                        </fo:block>
                                    </fo:table-cell>

                                    <fo:table-cell font-family="sans-serif" padding-right="10px" padding-bottom="7px" >
                                        <fo:block>
                                            <fo:inline font-weight="bold">JMBG: </fo:inline>
                                            <xsl:value-of select="//po:jmbg" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-family="sans-serif">
                                        <fo:block>
                                            <fo:inline font-weight="bold">Pol / Sex: </fo:inline>
                                            <xsl:value-of select="//po:pol" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="large" font-weight="bold" padding="7px 7px 0px 7px">
                        Vakcinacije / Vaccinations
                    </fo:block>
                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>

                    <fo:block>
                        <xsl:for-each select="//po:doza">
                            <xsl:sort select="po:broj_doze"/>
                            <fo:table font-family="sans-serif" font-size="small">
                                <fo:table-body>
                                    <fo:table-row border-top="1px dashed black">
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                DOZA / DOSE:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                <xsl:value-of select="po:broj_doze"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                Datum primanja / Immunization date:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block>
                                                <xsl:value-of select="po:datum"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                Tip / Type:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block>
                                                <xsl:value-of select="po:tip"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                Proizvodjac / Manufacturer:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block>
                                                <xsl:value-of select="po:proizvodjac"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                Broj serije / Batch number:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block>
                                                <xsl:value-of select="po:broj_serije"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                Ustanova primanja / Immunized at:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block>
                                                <xsl:value-of select="po:ustanova/po:naziv"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row border-bottom="1px dashed black">
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block font-weight="bold">
                                                Mesto / Place:
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding-left="15px" padding-top="5px">
                                            <fo:block>
                                                <xsl:value-of select="po:ustanova/po:mesto"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </xsl:for-each>
                    </fo:block>

                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>
                    <fo:block font-family="sans-serif" font-size="large" font-weight="bold" padding="7px 7px 0px 7px">
                        Razlog izdavanja / Issuing purpose
                    </fo:block>
                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>

                    <fo:block>
                        <fo:inline font-weight="bold">Razlog / Purpose: </fo:inline>
                        <xsl:value-of select="//po:razlog"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
