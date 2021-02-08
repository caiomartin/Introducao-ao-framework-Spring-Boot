package com.digitalinovationone.springboot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configurable
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class BDConfiguration {
    private String driverClasseName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB connection for dev - H2");
        System.out.println(driverClasseName);
        System.out.println(url);
        return "DB Connetion to H2_TESTE - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection() {
        System.out.println("DB connection for dev - MySQL");
        System.out.println(driverClasseName);
        System.out.println(url);
        return "DB Connetion to MYSQL_PROD - Production instance";
    }
    
    
}