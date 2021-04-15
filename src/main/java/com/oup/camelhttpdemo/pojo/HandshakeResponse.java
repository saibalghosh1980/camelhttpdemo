package com.oup.camelhttpdemo.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class HandshakeResponse {
    @JsonProperty("apiSpecification")
    public ApiSpecification getApiSpecification() {
        return this.apiSpecification;
    }

    public void setApiSpecification(ApiSpecification apiSpecification) {
        this.apiSpecification = apiSpecification;
    }

    ApiSpecification apiSpecification;

    @JsonProperty("loginFields")
    public List<LoginField> getLoginFields() {
        return this.loginFields;
    }

    public void setLoginFields(List<LoginField> loginFields) {
        this.loginFields = loginFields;
    }

    List<LoginField> loginFields;
}
