package com.agungfAl.actionlearning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().
            components(new Components())
            .info(new Info()
                .title("Penyerapan Dana Desa API Documentation")
                .description("Penyerapan Dana Desa Tahun 2022")
                .version("1.0.0")
            );
    }
}
