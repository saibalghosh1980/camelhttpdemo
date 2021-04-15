package com.oup.camelhttpdemo.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class ApiSpecification {
    @JsonProperty("versions") 
    public List<Version> getVersions() { 
		 return this.versions; } 
    public void setVersions(List<Version> versions) { 
		 this.versions = versions; } 
    List<Version> versions;
}
