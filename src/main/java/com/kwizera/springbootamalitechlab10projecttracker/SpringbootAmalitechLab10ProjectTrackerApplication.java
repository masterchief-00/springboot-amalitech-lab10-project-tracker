package com.kwizera.springbootamalitechlab10projecttracker;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAmalitechLab10ProjectTrackerApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        // Set properties to be picked up by Spring Boot
        System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("DB_URL"));
        System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("DB_USER"));
        System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("SPRING_DATA_MONGODB_URI", dotenv.get("MONGODB_URI"));

        SpringApplication.run(SpringbootAmalitechLab10ProjectTrackerApplication.class, args);
    }

}
