<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:tp="http://www.rokzasok.rs/tipovi"
                xmlns:is="http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    #page{
                    }

                    #title{
                    text-align: center;
                    }

                    #grupa{
                    padding-left: 50px;
                    }

                    .form-control {
                    border: none; border-bottom: 2px solid; border-bottom-style: dotted; width: 100%; margin-bottom: 20px;
                    }
                </style>
            </head>
            <body>
                <div id="page">
                    <h2 id="title">Iskazivanje interesovanja za vakcinisanje protiv COVID-19</h2>
                    <form name="interesovanje">
                    <div>
                        <br />
                        Državljanstvo: <br />
                        <b><xsl:value-of select="//is:drzavljanstvo" /></b>
                        <hr class="form-control"/>
                        <xsl:choose>
                            <xsl:when test="//is:drzavljanstvo='Državljanin Republike Srbije'">
                                JMBG:
                            </xsl:when>
                            <xsl:otherwise>
                                Broj pasoša:
                            </xsl:otherwise>
                        </xsl:choose>
                        <br/><b><xsl:value-of select="//tp:JMBG" /></b>
                        <hr class="form-control"/>
                        Ime:<br/><b>
                        <xsl:value-of select="//is:ime" /></b>
                        <hr class="form-control"/>
                        Prezime:<br/><b>
                        <xsl:value-of select="//is:prezime" /></b>
                        <hr class="form-control"/>
                        Adresa elektronske pošte:<br/><b>
                        <xsl:value-of select="//is:email" /></b>
                        <hr class="form-control"/>
                        Broj mobilnog telefona (navesti broju formatu 06X..... bez razmaka i
                        crtica):<br /><b>
                        <xsl:value-of select="//is:broj_mobilnog_telefona" /></b>
                        <hr class="form-control"/>
                        Broj fiksnog telefona (navesti broju formatu 011..... bez razmaka i
                        crtica):<br /><b>
                        <xsl:value-of select="//is:broj_fiksnog_telefona" /></b>
                        <hr class="form-control"/>
                        Odaberite lokaciju gde želite da primitevakcinu (unesite opštinu):<br/>
                        <b><xsl:value-of select="//is:lokacija_opstina" /></b>
                        <hr class="form-control"/>

                        Iskazujem interesovanje da primim isključivo vakcinu sledećih
                        proizvođača za koji Agencija za lekove i medicinska sredstva potvrdi
                        bezbednost, efikasnost i kvalitet i izda dozvolu za upotrebu leka: <br />
                        <b><xsl:value-of select="//is:tip_vakcine"/></b><hr class="form-control"/>
<!--                        <div id="grupa">-->
<!--                            <input type="radio" name="radio2" value="Pfizer-BioNtech" disabled="true">-->
<!--                                <xsl:if test="//is:tip_vakcine='Pfizer-BioNtech'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>Pfizer-BioNTech-->
<!--                            <br/>-->
<!--                            <input type="radio" name="radio2" value="Sputnik V (Gamaleya istraživački centar)" disabled="true">-->
<!--                                <xsl:if test="//is:tip_vakcine='Sputnik V (Gamaleya istraživački centar)'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>Sputnik V (Gamaleya истраживачки центар) <br/>-->
<!--                            <input type="radio" name="radio2" value="Sinopharm" disabled="true">-->
<!--                                <xsl:if test="//is:tip_vakcine='Sinopharm'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>Sinopharm <br/>-->

<!--                            <input type="radio" name="radio2" value="AstraZeneca" disabled="true">-->
<!--                                <xsl:if test="//is:tip_vakcine='AstraZeneca'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>AstraZeneca <br/>-->
<!--                            <input type="radio" name="radio2" value="Moderna" disabled="true">-->
<!--                                <xsl:if test="//is:tip_vakcine='Moderna'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>Moderna <br/>-->

<!--                            <input type="radio" name="radio2" value="Bilo koja" disabled="true">-->
<!--                                <xsl:choose>-->
<!--                                    <xsl:when test="//is:tip_vakcine='Bilo koja'">-->
<!--                                        <xsl:attribute name="checked">checked</xsl:attribute>-->
<!--                                    </xsl:when>-->
<!--                                    <xsl:otherwise>-->
<!--                                        <xsl:attribute name="checked">false</xsl:attribute>-->
<!--                                    </xsl:otherwise>-->
<!--                                </xsl:choose>-->

<!--                            </input>Bilo koja-->

<!--                        </div>-->
<!--                        <br />-->
                        Da li ste dobrovoljni davalac krvi? <br />
                        <xsl:choose>
                            <xsl:when test="//is:davalac_krvi='true'">
                                <b>Da</b>
                            </xsl:when>
                            <xsl:otherwise>
                                <b>Ne</b>
                            </xsl:otherwise>
                        </xsl:choose><hr class="form-control"/>
<!--                        <div id="grupa">-->

<!--                            <input type="radio" name="radio1" value="true" disabled="true">-->
<!--                                <xsl:if test="//is:davalac_krvi='true'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>Da <br/>-->

<!--                            <input type="radio" name="radio1" value="false" disabled="true">-->
<!--                                <xsl:if test="//is:davalac_krvi='false'">-->
<!--                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>-->
<!--                            </input>Ne-->

<!--                            <br />-->
<!--                        </div>-->
                        <br /><br />
                        Datum <xsl:value-of select="//is:datum_podnosenja" />. <br /><br /><br />
                </div>
            </form>
        </div>

    </body>

        </html>
    </xsl:template>
</xsl:stylesheet>