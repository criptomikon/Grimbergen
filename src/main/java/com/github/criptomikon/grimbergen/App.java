package com.github.criptomikon.grimbergen;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.util.Assert;

@Slf4j
@SpringBootApplication
@PropertySources(value = {
        @PropertySource(value = "classpath:app-defaults.properties", ignoreResourceNotFound = true)
})
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(App.class, args);
        Assert.notNull(ctx, "Unable to load application context");
        String[] beanNames = ctx.getBeanDefinitionNames();
        log.info("App ready ({} beans loaded)", beanNames.length);
    }

}
