package com.oup.camelhttpdemo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class LoginField {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    @JsonProperty("key")
    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String key;

    @JsonProperty("length")
    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    int length;

    @JsonProperty("maskedField")
    public boolean getMaskedField() {
        return this.maskedField;
    }

    public void setMaskedField(boolean maskedField) {
        this.maskedField = maskedField;
    }

    boolean maskedField;
}
