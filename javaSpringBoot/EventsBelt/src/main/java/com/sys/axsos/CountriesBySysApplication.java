package com.sys.axsos;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CountriesBySysApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesBySysApplication.class, args);
	}
	
}
