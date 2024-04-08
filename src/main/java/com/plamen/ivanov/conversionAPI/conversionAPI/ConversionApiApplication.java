package com.plamen.ivanov.conversionAPI.conversionAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
        info = @Info(title = "conversionAPI REST API", version = "1.0.0"),
        servers = {
                @Server(url = "http://localhost:8080"),
        },
        tags = {
                @Tag(name = "Conversion", description = "Operations related to the Conversion model available in the API.")
        }
)
@SpringBootApplication
public class ConversionApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConversionApiApplication.class, args);
    }


}
