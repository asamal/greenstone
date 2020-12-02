package com.samal.greenstone.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties(prefix = "core-url")
@Validated
public class CoreUrlConfiguration {

    @NotEmpty
    private String host;

    @NotEmpty
    private String port;

    public String getCoreUrl() {
        return "http://" + host + ":" + port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
