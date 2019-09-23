package com.blog2.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //使用配置类注解
//@EnableSwagger2 //启用这个配置类
public class Swagger2Config {
    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean //配置这个bean是为了让swagger扫描到controller
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("goodtimp blog2.0")
                        .description("goodtimp的博客")
                        .version("2.0.0")
                        .contact(new Contact("goodtimp", null, null))
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blog2.backend.controller"))
                .paths(PathSelectors.any())
                .build();

    }


}
