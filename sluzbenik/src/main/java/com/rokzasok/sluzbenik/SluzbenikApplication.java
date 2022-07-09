package com.rokzasok.sluzbenik;

import com.rokzasok.sluzbenik.exception.EntityNotFoundException;
import com.rokzasok.sluzbenik.model.ostalo.dostupne_doze.DostupneDoze;
import com.rokzasok.sluzbenik.model.ostalo.spisak_korisnika.SpisakKorisnika;
import com.rokzasok.sluzbenik.service.DostupneDozeService;
import com.rokzasok.sluzbenik.service.SpisakKorisnikaService;
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
public class SluzbenikApplication {

	public static void main(String[] args) {
		SpringApplication.run(SluzbenikApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:9091"));
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
	public CommandLineRunner initUsers(SpisakKorisnikaService korisnikService, DostupneDozeService dozeService) {
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
				DostupneDoze doze = dozeService.findById(1L);
				if (doze != null) {
					System.out.println("Vec postoji stanje doza u bazi");
				}
			} catch (EntityNotFoundException e) {
				dozeService.initDefaultSpisakDoza();
			}
		};
	}

}
