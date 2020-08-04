package com.ssafy.apolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ApolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolioApplication.class, args);
    }

}
