package com.gestionStock.stockgestion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.gestionStock.stockgestion.utils.Root.APP_ROOT;

//@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket apiConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Stock management Documentation API")
                                .title("API DOC Stock management")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gestionStock.stockgestion"))
                .paths(PathSelectors.ant(APP_ROOT+"/**"))
                .build();
    }

}
