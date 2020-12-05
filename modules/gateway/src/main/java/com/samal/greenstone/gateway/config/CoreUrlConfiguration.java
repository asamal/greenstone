package com.samal.greenstone.gateway.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties(prefix = "core-url")
@Validated
@Setter
public class CoreUrlConfiguration {

    @NotEmpty
    private String host;

    @NotEmpty
    private String port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCoreUrl() {
        return "http://" + host + ":" + port;
    }
}
