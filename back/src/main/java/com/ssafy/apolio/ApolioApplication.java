package com.ssafy.apolio;

import com.ssafy.apolio.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class ApolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolioApplication.class, args);
    }

}
