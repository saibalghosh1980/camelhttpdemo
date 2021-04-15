package com.oup.camelhttpdemo.route;

import com.oup.camelhttpdemo.pojo.HandshakeResponse;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class HandShakeRoute extends RouteBuilder{


    @Override
    public void configure() throws Exception {
        from("direct:handShake").routeId("id_HandShakeRoute")
        //.streamCaching()
        .log(LoggingLevel.INFO,log,"HandshakeRouteCalled.................")
        .setHeader("Exchange.HTTP_METHOD").simple("GET")
		.setHeader("Content-Type").simple("application/json")
		.setHeader("Accept").simple("application/json")
        .to("https://payments.cat.uk.pt-x.com/payments-service/api/security/handshake")
        //.to("https://www.google.com/")
        .convertBodyTo(String.class)
        .log(LoggingLevel.INFO, log, "${body}")
        .log(LoggingLevel.INFO, log, "${headers.X-CSRF}")
        .log(LoggingLevel.INFO, log, "${headers.Set-Cookie}")
        .unmarshal().json(JsonLibrary.Jackson,HandshakeResponse.class)
		.log(LoggingLevel.INFO, log,"Response Body ${body}")
        .process("springManagedHandShakePostProcessor")
        .to("log:com.oup.camelhttpdemo.route.HandShakeRoute");
        
    }
    
}
