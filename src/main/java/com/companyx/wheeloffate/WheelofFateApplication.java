package com.companyx.wheeloffate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = {"com.companyx"}) 
public class WheelofFateApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WheelofFateApplication.class);
    }  
	
	public static void main(String[] args) {
		SpringApplication.run(WheelofFateApplication.class, args);
	}
}