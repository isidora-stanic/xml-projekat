package com.rokzasok.portal.za.imunizaciju;

import com.rokzasok.portal.za.imunizaciju.exception.EntityNotFoundException;
import com.rokzasok.portal.za.imunizaciju.model.dto.CreateKorisnikDTO;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_korisnika.SpisakKorisnika;
import com.rokzasok.portal.za.imunizaciju.model.ostalo.spisak_termina.SpisakTermina;
import com.rokzasok.portal.za.imunizaciju.service.SpisakKorisnikaService;
import com.rokzasok.portal.za.imunizaciju.service.SpisakTerminaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4201", "http://localhost:9090"));
				corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
						"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
						"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	public CommandLineRunner initUsers(SpisakKorisnikaService korisnikService, SpisakTerminaService terminService) {
		return args -> {
			try {
				SpisakKorisnika korisnici = korisnikService.findById(1L);
				if (korisnici != null) {
					System.out.println("Vec postoje korisnici u bazi");
				}
			} catch (EntityNotFoundException e) {
				korisnikService.initDefaultSpisakKorisnika();
			}

			try {
				SpisakTermina termini = terminService.findById(1L);
				if (termini != null) {
					System.out.println("Vec postoji spisak termina u bazi");
				}
			} catch (EntityNotFoundException e) {
				terminService.initEmptySpisak();
			}
		};
	}

}

