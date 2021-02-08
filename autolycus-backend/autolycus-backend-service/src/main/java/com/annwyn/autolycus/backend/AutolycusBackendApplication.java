package com.annwyn.autolycus.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class AutolycusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolycusBackendApplication.class);
    }


}
