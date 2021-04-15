package com.oup.camelhttpdemo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class Version {

    @JsonProperty("major")
    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    String major;

    @JsonProperty("minor")
    public String getMinor() {
        return this.minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    String minor;

    @JsonProperty("patch")
    public String getPatch() {
        return this.patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    String patch;

    @JsonProperty("build")
    public String getBuild() {
        return this.build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    String build;
}
