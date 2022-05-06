package com.teamk.laube;

import com.teamk.laube.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class LaubeApplication {
    public static void main(String[] args) {
        SpringApplication.run(LaubeApplication.class, args);
    }

}
