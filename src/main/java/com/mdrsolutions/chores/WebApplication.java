package com.mdrsolutions.chores;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan 
@EnableAutoConfiguration(
    exclude = {
        SecurityAutoConfiguration.class, 
        PersistenceExceptionTranslationAutoConfiguration.class
    }
)

@Import(
    value = { 
        SecurityConfig.class
    }
)
@NoArgsConstructor
public class WebApplication extends SpringBootServletInitializer{
     
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           SpringApplication.run(WebApplication.class, args);
    }
    
    @Bean 
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
