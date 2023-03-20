package com.gestionStock.stockgestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockgestionApplication {

	public static void main(String[] args) {

		SpringApplication.run(StockgestionApplication.class, args);
	}

}
