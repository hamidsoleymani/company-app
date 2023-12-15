package com.boostmedia.Company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCompanyAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(CompanyAppApplication::main).with(TestCompanyAppApplication.class).run(args);
	}

}
