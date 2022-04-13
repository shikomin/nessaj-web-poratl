package com.nessaj.portal;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
@EnableCasClient
public class PortalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PortalApplication.class);
    }

}
