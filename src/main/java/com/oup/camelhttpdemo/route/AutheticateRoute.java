package com.oup.camelhttpdemo.route;

import com.oup.camelhttpdemo.pojo.AutheticateRequest;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AutheticateRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:autheticate").routeId("id_Autheticate").log(LoggingLevel.INFO, log, "Inside AutheticateRoute.....")
                .setHeader("Exchange.HTTP_METHOD").simple("POST")
                .setHeader("Content-Type").simple("application/json")
                .setHeader("X-CSRF").simple("${exchangeProperty.csrftoken}")
                //.setHeader("Cookie").simple("${exchangeProperty.jsessionid}")
                .process("springManagedHandAutheticatePreProcessor").marshal()
                .json(JsonLibrary.Jackson, AutheticateRequest.class).convertBodyTo(String.class)
                //.log(LoggingLevel.INFO, log, "${headers.X-CSRF}").log(LoggingLevel.INFO, log, "Cookie: ${headers.Cookie}").log("Request to Login: ${body}")
                //.to("log:com.oup.camelhttpdemo.route.AutheticateRoute")
                .to("https://payments.cat.uk.pt-x.com/payments-service/api/security/login?cookieHandler=#springManagedexchangeCookieHandler")
                //.to("https://payments.cat.uk.pt-x.com/payments-service/api/security/login")
                //.log(LoggingLevel.INFO, log, "${headers.Set-Cookie}")
                //.log(LoggingLevel.INFO, log, "response Code : ${header.CamelHttpResponseCode}")
                //.log(LoggingLevel.INFO, log, "Auth Token : ${header.com.bottomline.auth.token}")
                .setProperty("authtoken", simple("${headers.com.bottomline.auth.token}"))
                //.to("log:com.oup.camelhttpdemo.route.AutheticateRoute?showBody=true&showHeaders=true")
                //.convertBodyTo(String.class).log(LoggingLevel.INFO, log, "${body}")
                .setProperty("csrftoken", simple("${headers.X-CSRF}"))
                .to("direct:uploadFile");

    }

}
