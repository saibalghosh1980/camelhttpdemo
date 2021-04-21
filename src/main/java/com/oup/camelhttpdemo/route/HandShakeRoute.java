package com.oup.camelhttpdemo.route;

import com.oup.camelhttpdemo.pojo.AutheticateRequest;
import com.oup.camelhttpdemo.pojo.HandshakeResponse;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class HandShakeRoute extends RouteBuilder{


    @Override
    public void configure() throws Exception {

        onException(Exception.class)
        .handled(true)
        .maximumRedeliveries(2)
		.setHeader("status").simple("Error")
		.setHeader("errorMessage").simple("Exception occurred in Route ${routeId} . Exception Message: ${exchangeProperty.CamelExceptionCaught}")
		.to("log:com.oup.camelhttpdemo.route.HandShakeRoute?showAll=true&multiline=true")
        .log(LoggingLevel.ERROR,log,"${headers.errorMessage}")
        .log(LoggingLevel.ERROR,log,"${exception.stacktrace}");

        onException(HttpOperationFailedException.class)
        .handled(true)
        .maximumRedeliveries(2)
        .redeliveryDelay(2000)
        .backOffMultiplier(2)
		.setHeader("status").simple("Error")
		.setHeader("errorMessage").simple("Exception occurred in Route ${routeId} . Exception Message: ${exchangeProperty.CamelExceptionCaught}")
		.log(LoggingLevel.ERROR,log,"${headers.errorMessage}");

        from("direct:handShake").routeId("id_HandShakeRoute")
        //.streamCaching()
        .log(LoggingLevel.INFO,log,"HandshakeRouteCalled.................")
        .setHeader("Exchange.HTTP_METHOD").simple("GET")
		.setHeader("Content-Type").simple("application/json")
		//.setHeader("Accept").simple("application/json")
        .to("https://payments123.cat.uk.pt-x.com/payments-service/api/security/handshake?cookieHandler=#springManagedexchangeCookieHandler")
        //.to("https://www.google.com/")
        .convertBodyTo(String.class)
        //.log(LoggingLevel.INFO, log, "${body}")
        .log(LoggingLevel.INFO, log, "${headers.X-CSRF}")
        .log(LoggingLevel.INFO, log, "${headers.Set-Cookie}")
        .setProperty("csrftoken", simple("${headers.X-CSRF}"))
        .unmarshal().json(JsonLibrary.Jackson,HandshakeResponse.class)
        .process("springManagedHandShakePostProcessor")
        .to("direct:autheticate");
        
        //.to("log:com.oup.camelhttpdemo.route.HandShakeRoute");
        
    }
    
}
