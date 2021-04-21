package com.oup.camelhttpdemo.processor;

import java.util.ArrayList;

import com.oup.camelhttpdemo.pojo.HandshakeResponse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component("springManagedHandShakePostProcessor")
@Slf4j
public class HandShakePostProcessor implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {
        // TODO Auto-generated method stub
        log.info("The cookie is:"+exchange.getIn().getHeader("Set-Cookie"));
        String jsessionId=(String)((ArrayList)exchange.getIn().getHeader("Set-Cookie")).get(0);
        //jsessionId=jsessionId.split(";")[0].split("=")[1];
        log.info(jsessionId);
        exchange.setProperty("jsessionid", jsessionId);
        HandshakeResponse body=exchange.getIn().getBody(HandshakeResponse.class);
        log.info(body.toString());
        
        
    }
    
}
