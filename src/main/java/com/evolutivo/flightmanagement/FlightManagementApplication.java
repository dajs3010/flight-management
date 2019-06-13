package com.evolutivo.flightmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightManagementApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FlightManagementApplication.class, args);
    }

}
