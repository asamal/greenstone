package com.samal.greenstone.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties
@Validated
public class UriConfiguration {

    @NotEmpty
    private String coreUrl;// = "http://localhost:8082";

    public String getCoreUrl() {
        return coreUrl;
    }

    public void setCoreUrl(String coreUrl) {
        this.coreUrl = coreUrl;
    }
}
