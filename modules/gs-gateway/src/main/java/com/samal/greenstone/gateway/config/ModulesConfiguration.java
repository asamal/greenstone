package com.samal.greenstone.gateway.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties(prefix = "modules-config")
@Validated
@Setter
public class ModulesConfiguration {

    @NotEmpty
    private String host;

    @NotEmpty
    private String port;

    @NotEmpty
    private String gsUserHost;

    @NotEmpty
    private String gsUserPort;

    public String getCoreUrl() {
        return "http://" + host + ":" + port;
    }

    public String getGsUserUrl() {
        return "http://" + gsUserHost + ":" + gsUserPort;
    }
}
