package com.oup.camelhttpdemo.processor;

import java.util.ArrayList;

import com.oup.camelhttpdemo.pojo.AutheticateRequest;
import com.oup.camelhttpdemo.pojo.LoginToken;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component("springManagedHandAutheticatePreProcessor")
@Slf4j
public class AutheticatePreProcessor implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {
        // TODO Auto-generated method stub

        AutheticateRequest autheticateRequest=new AutheticateRequest();
        autheticateRequest.setApiVersion("{\"major\": \"1\",\"minor\": \"0\",\"patch\": \"0\",\"build\": \"0\"}\"");
        autheticateRequest.setTokenLocation("HEADER");
        autheticateRequest.setPurpose("cpay-auth");
        LoginToken loginToken_1=new LoginToken();
        loginToken_1.setKey("com.bottomline.security.provider.login.email");
        loginToken_1.setValue("");
        LoginToken loginToken_2=new LoginToken();
        loginToken_2.setKey("com.bottomline.security.provider.login.password");
        loginToken_2.setValue("");
        ArrayList<LoginToken> loginTokens=new ArrayList<LoginToken>();
        loginTokens.add(loginToken_1);
        loginTokens.add(loginToken_2);
        autheticateRequest.setLoginTokens(loginTokens);
        exchange.getMessage().setBody(autheticateRequest,AutheticateRequest.class);

        
    }
    
}
