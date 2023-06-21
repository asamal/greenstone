package com.samal.greenstone.gateway.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;

@ConfigurationProperties(prefix = "modules-config")
@Validated
@Setter
public class ModulesConfiguration {

    public static final String HTTP = "http://";
    @NotEmpty
    private String host;

    @NotEmpty
    private String port;

    @NotEmpty
    private String gsUserHost;

    @NotEmpty
    private String gsUserPort;

    @NotEmpty
    private String gsUserQHost;

    @NotEmpty
    private String gsUserQPort;

    public String getCoreUrl() {
        return HTTP + host + ":" + port;
    }

    public String getGsUserUrl() {
        return HTTP + gsUserHost + ":" + gsUserPort;
    }

    public String getGsUserQUrl() {
        return HTTP + gsUserQHost + ":" + gsUserQPort;
    }
}
