package com.oup.camelhttpdemo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UploadFileRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub
        from("direct:uploadFile").routeId("id_uploadFile")
        .log(LoggingLevel.INFO,log,"UploadFileRoute Called.................")
        //.process("springManagedUploadFilePreProcessor")
        .setHeader("Exchange.HTTP_METHOD").simple("POST").setHeader("Content-Type").simple("application/json")
        .setHeader("X-CSRF").simple("${exchangeProperty.csrftoken}")
        .setHeader("com.bottomline.auth.token").simple("${exchangeProperty.authtoken}")
        .setBody().simple("{\n  \"entity\": {\n    \"name\": \"Applications\",\n    \"symbol\": \"com.bottomline.cpay.model.applications\",\n    \"key\": \"com.bottomline.cpay.model.applications\"\n  },\n  \"resultFields\": [\n    {\n      \"name\": \"All Applications Minimal\",\n      \"symbol\": \"com.bottomline.cpay.model.AllApplicationsMinimal\",\n      \"fieldType\": \"OBJECT\",\n      \"key\": false\n    },\n    {\n      \"name\": \"rowCount\",\n      \"symbol\": \"com.bottomline.query.count\",\n      \"fieldType\": \"LONG\",\n      \"key\": false\n    }\n  ],\n  \"resultsPage\": {\n    \"firstResult\": 0,\n    \"maxResults\": 500\n  }\n}")
        .to("log:com.oup.camelhttpdemo.route.UploadFileRoute?showBody=true&showHeaders=true")
        //.to("https://payments.cat.uk.pt-x.com/payments-service/api/file/upload/28804?cookieHandler=#springManagedexchangeCookieHandler");
        .to("https://payments.cat.uk.pt-x.com/payments-service/api/query/execute?cookieHandler=#springManagedexchangeCookieHandler&throwExceptionOnFailure=false")
        .convertBodyTo(String.class)
        .log("${body}")
        .to("log:com.oup.camelhttpdemo.route.UploadFileRoute?showBody=true&showHeaders=true");


        
    }
    
}
