package com.xpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<EmailFormServlet> emailFormServlet() {
        ServletRegistrationBean<EmailFormServlet> registration =
                new ServletRegistrationBean<>(
                        new EmailFormServlet(), "/EmailFormServlet");

        registration.setName("EmailFormServlet");
        return registration;
    }
}