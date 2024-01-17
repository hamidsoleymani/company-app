package com.boostmedia.Company.autoconfiguration;

import com.boostmedia.Company.autoconfiguration.conditional.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AutoKonfig {

    @Bean
    @Profile("dev")
    public DevService stringdev(){
        return new DevService();
    }

    @Bean
    @Profile("prod")
    public ProdService stringprod(){
        return new ProdService();
    }

    @Bean
    @Conditional(MySQLDatabaseTypeCondition.class)
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAO();
    }
    @Bean
    @Conditional(MongoDBDatabaseTypeCondition.class)
    public UserDAO mongoUserDAO(){
        return new MongoUserDAO();
    }
}
