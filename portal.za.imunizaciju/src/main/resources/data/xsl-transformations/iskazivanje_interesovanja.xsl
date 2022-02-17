<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:is="http://www.rokzasok.rs/gradjanin/iskazivanje-interesovanja">

    <xsl:template match="/">
        <html>

            <head>
                <style>
                    #page{
                    padding-left: 300px;
                    padding-right: 300px;
                    }

                    #title{
                    text-align: center;
                    }

                    #grupa{
                    padding-left: 50px;
                    }

                    .form-control {
                    border: none; border-bottom: 2px solid; border-bottom-style: dotted; width: 100%;
                    }
                </style>
            </head>

            <body>
                <div id="page">
                    <h2 id="title">Исказивање интересовања за вакцинисање против COVID-19</h2>
                    <form name="interesovanje">
                    <div>
                        <br />
                        Одаберите опцију: <br />

                        <div id="grupa">
                            <xsl:value-of select="//is:drzavljanstvo" />
                            <input type="radio" name="radio3" value="Pfizer-BioNtech">
                                <xsl:if test="//is:drzavljanstvo='Pfizer-BioNtech'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Pfizer-BioNTech
                            <br/>
                            <input type="radio" name="radio3" value="Sputnik V (Gamaleya istraživački centar)">
                                <xsl:if test="//is:drzavljanstvo='Sputnik V (Gamaleya istraživački centar)'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Sputnik V (Gamaleya истраживачки центар) <br/>
                            <input type="radio" name="radio3" value="Sinopharm">
                                <xsl:if test="//is:drzavljanstvo='Sinopharm'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Sinopharm <br/>
                        </div>

                        ЈМБГ:
                        <xsl:value-of select="//is:JMBG" />
                        <br />
                        Име:
                        <xsl:value-of select="//is:ime" />

                        Презиме:
                        <xsl:value-of select="//is:prezime" />
                        <br />

                        Адреса електронске поште:
                        <xsl:value-of select="//is:email" />
                        <br />

                        Број мобилног телефона (навести број у формату 06X..... без размака и
                        цртица):
                        <xsl:value-of select="//is:broj_mobilnog_telefona" />
                        <br />

                        Број фиксног телефона (навести број у формату нпр. 011..... без размака и
                        цртица):
                        <xsl:value-of select="//is:broj_fiksnog_telefona" />
                        <br />Одаберите локацију где желите да примите вакцину (унесите општину):
                        <xsl:value-of select="//is:lokacija_opstina" />

                        <br />Исказујем интересовање да примим искључиво вакцину следећих
                        произвођача за који Агенција за лекове и медицинска средства потврди
                        безбедност, ефикасност и квалитет и изда дозволу за употребу лека: <br />
                        <div id="grupa">
                            <input type="radio" name="radio2" value="Pfizer-BioNtech">
                                <xsl:if test="//is:tip_vakcine='Pfizer-BioNtech'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Pfizer-BioNTech
                            <br/>
                            <input type="radio" name="radio2" value="Sputnik V (Gamaleya istraživački centar)">
                                <xsl:if test="//is:tip_vakcine='Sputnik V (Gamaleya istraživački centar)'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Sputnik V (Gamaleya истраживачки центар) <br/>
                            <input type="radio" name="radio2" value="Sinopharm">
                                <xsl:if test="//is:tip_vakcine='Sinopharm'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Sinopharm <br/>

                            <input type="radio" name="radio2" value="AstraZeneca">
                                <xsl:if test="//is:tip_vakcine='AstraZeneca'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>AstraZeneca <br/>
                            <input type="radio" name="radio2" value="Moderna">
                                <xsl:if test="//is:tip_vakcine='Moderna'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Moderna <br/>

                            <input type="radio" name="radio2" value="Bilo koja">
                                <xsl:if test="//is:tip_vakcine='Bilo koja'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                                <xsl:else>
                                    <xsl:attribute name="checked">false</xsl:attribute></xsl:else>

                            </input>Било која

                        </div>
                        <br />
                        Да ли сте добровољни давалац крви? <br />
                        <div id="grupa">

                            <input type="radio" name="radio1" value="true">
                                <xsl:if test="//is:davalac_krvi='true'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Да <br/>

                            <input type="radio" name="radio1" value="false">
                                <xsl:if test="//is:davalac_krvi='false'">
                                    <xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
                            </input>Не

                            <br />
                        </div>
                        <br /><br /><br /><br /><br />
                        <xsl:value-of select="//is:datum_podnosenja" /> <br /><br /><br />

                </div>
            </form>
        </div>

    </body>

        </html>
    </xsl:template>

</xsl:stylesheet>