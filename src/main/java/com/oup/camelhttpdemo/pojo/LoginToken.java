package com.oup.camelhttpdemo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class LoginToken {
    @JsonProperty("key") 
    public String getKey() { 
		 return this.key; } 
    public void setKey(String key) { 
		 this.key = key; } 
    String key;
    @JsonProperty("value") 
    public String getValue() { 
		 return this.value; } 
    public void setValue(String value) { 
		 this.value = value; } 
    String value;
}
