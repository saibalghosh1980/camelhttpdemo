package com.oup.camelhttpdemo.processor;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import lombok.extern.slf4j.Slf4j;

@Component("springManagedUploadFilePreProcessor")
@Slf4j
public class UploadFilePreProcessor implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {

        MultipartEntityBuilder multiPartEntityBuilder=MultipartEntityBuilder.create();
        multiPartEntityBuilder.addBinaryBody("file", new File("/Users/kumarghs/Desktop/skgtest.txt"));
        exchange.getMessage().setBody(multiPartEntityBuilder.build());
        
    }
    
}
