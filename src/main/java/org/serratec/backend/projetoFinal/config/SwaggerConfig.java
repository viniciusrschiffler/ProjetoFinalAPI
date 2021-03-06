package org.serratec.backend.projetoFinal.config;

import java.util.ArrayList;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.serratec.backend.projetoFinal.controller"))
                //.paths(regex("/Pedido.*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

	private ApiInfo metaInfo() {

        @SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
                "Ecommerce API REST",
                "API REST de Ecommerce.",
                "1.0",
                "Terms of Service",
                new Contact("Grupo 06","grupo6ff@gmail.com", " "),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
