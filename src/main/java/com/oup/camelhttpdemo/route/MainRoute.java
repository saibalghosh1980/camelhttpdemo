package com.oup.camelhttpdemo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MainRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub
        from("timer://foo?repeatCount=1").routeId("id_MainRoute")
				.log(LoggingLevel.INFO, log, "Route started .....................................")
				.to("direct:handShake");
				//.to("bean:springManagedDeleteFilesBL?method=deleteOldFilesFolders()");
        
    }
    
}
