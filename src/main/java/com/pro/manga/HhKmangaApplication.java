package com.pro.manga;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.pro.manga.config.StorageProperties;
import com.pro.manga.service.StorageService;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
@EnableConfigurationProperties(StorageProperties.class)
public class HhKmangaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HhKmangaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return(arg->{
			storageService.init();
		});
	}
}
