package com.aslanjavasky.servicefortutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ServicefortutorApplication {

    public static void main(String[] args) {
		ConfigurableApplicationContext ctx=
				SpringApplication.run(ServicefortutorApplication.class, args);

    }
}
