package ro.mmountains.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by aboieriu on 7/13/16.
 */
@Configuration
public class ServiceConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {
    private static final String STATIC_FILE_PATH = "src/main/resources/cache-worker.js";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/cache-worker", STATIC_FILE_PATH);
    }
}
