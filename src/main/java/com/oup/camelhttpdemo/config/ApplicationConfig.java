package com.oup.camelhttpdemo.config;

import org.apache.camel.CamelContext;
import org.apache.camel.http.base.cookie.ExchangeCookieHandler;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ApplicationConfig {

    @Bean("springManagedexchangeCookieHandler")
    public ExchangeCookieHandler getCookieHandler() {
        return new ExchangeCookieHandler();
    }

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {

                log.info("################### Before Application Start ############################");
                //context.setTracing(true);
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                log.info("################### After Application Start ############################");
            }
        };
    }

}
