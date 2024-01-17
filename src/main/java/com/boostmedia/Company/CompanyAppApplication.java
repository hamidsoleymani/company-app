package com.boostmedia.Company;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;

@SpringBootApplication
public class CompanyAppApplication {
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(CompanyAppApplication.class, args);
		 Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(  (t)-> System.out.println("bean: " + t));
	}



}
