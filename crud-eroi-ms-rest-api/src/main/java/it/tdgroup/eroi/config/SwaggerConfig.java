package it.tdgroup.eroi.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Created by p.b on 25/06/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${enableSwagger}")
    private boolean enableSwagger;


    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("crud-eroi-ms")
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("it.tdgroup.eroi.controller")).paths(postPaths())
                .paths(postPaths())
                .build();
    }


    private Predicate<String> postPaths() {
        return regex("/*.*");
    }

    private ApiKey apiKey() {
        return new ApiKey("AUTHORIZATION", "X_RTSYSID", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("crud-eroi-ms Ms API").contact(buildContact())
                .description("API per il colloquio con il microservizio crud-eroi-ms")
                .termsOfServiceUrl("http://www.regione.toscana.it").version("1.0.0").build();
    }

    private Contact buildContact() {
        return new Contact("Regione Toscana", "http://www.regione.toscana.it", "");
    }

    @Bean
    @ConditionalOnProperty(name = "disableSwaggerTryOut", havingValue = "true", matchIfMissing = false)
    UiConfiguration uiConfig() {
        return new UiConfiguration(null, "none", "alpha", "schema",
                new String[]{}, false, true, 60000L);
    }
}

