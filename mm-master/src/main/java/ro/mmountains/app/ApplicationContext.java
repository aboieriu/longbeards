package ro.mmountains.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aboieriu on 7/11/16.
 */
@Configuration
@ComponentScan(basePackages = {"ro.mmountains"})
@EnableAutoConfiguration
public class ApplicationContext extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationContext.class);
    }
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext ctx = SpringApplication.run(ApplicationContext.class, args);
    }
}
