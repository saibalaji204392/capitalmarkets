package com.apexon.capitalMarkets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.apexon.capitalMarkets"})
public class CapitalMarketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalMarketsApplication.class, args);
	}

}
