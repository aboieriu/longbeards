package ro.longbeards.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aboieriu on 7/11/16.
 */
@Configuration
@ComponentScan(basePackages = {"ro.longbeards"})
@EnableAutoConfiguration
public class ApplicationContext {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext ctx = SpringApplication.run(ApplicationContext.class, args);
    }
}
