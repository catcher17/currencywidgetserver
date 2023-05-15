package com.catcher.currencywidget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrencywidgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencywidgetApplication.class, args);
	}

}
