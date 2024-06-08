package com.boostmedia.Company;

import org.junit.Ignore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@Ignore
//@TestConfiguration(proxyBeanMethods = false)
public class TestCompanyAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(CompanyAppApplication::main).with(TestCompanyAppApplication.class).run(args);
	}

}
