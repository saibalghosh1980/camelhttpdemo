package com.oup.camelhttpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CamelhttpdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelhttpdemoApplication.class, args);
		log.info("Hello");
	}

}
