package com.oup.camelhttpdemo.processor;

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
        HandshakeResponse body=exchange.getIn().getBody(HandshakeResponse.class);
        log.info(body.toString());
        
        
    }
    
}
