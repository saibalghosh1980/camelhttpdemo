package com.oup.camelhttpdemo.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class AutheticateRequest {
    @JsonProperty("loginTokens")
    public List<LoginToken> getLoginTokens() {
        return this.loginTokens;
    }

    public void setLoginTokens(List<LoginToken> loginTokens) {
        this.loginTokens = loginTokens;
    }

    List<LoginToken> loginTokens;

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return this.apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    String apiVersion;

    @JsonProperty("purpose")
    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    String purpose;

    @JsonProperty("tokenLocation")
    public String getTokenLocation() {
        return this.tokenLocation;
    }

    public void setTokenLocation(String tokenLocation) {
        this.tokenLocation = tokenLocation;
    }

    String tokenLocation;
}
