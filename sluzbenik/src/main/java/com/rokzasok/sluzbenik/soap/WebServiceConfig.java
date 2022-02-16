package com.rokzasok.sluzbenik.soap;

import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.DostupneDoze;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "dostupneDoze")
    public DefaultWsdl11Definition dostupneDozeWsdlDefinition(XsdSchema dostupneDozeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DostupneDozePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.rokzasok.rs/soap/dostupne_doze");
        wsdl11Definition.setSchema(dostupneDozeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema dostupneDozeSchema() {
        String currentPath = System.getProperty("user.dir");
        return new SimpleXsdSchema(new ClassPathResource("dostupne_doze_soap.xsd"));
    }

    @Bean
    public XsdSchema korisniciSchema() {
        return new SimpleXsdSchema(new ClassPathResource("dostupne_doze_soap.xsd"));
    }
}
