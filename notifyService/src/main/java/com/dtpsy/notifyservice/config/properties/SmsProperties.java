package com.dtpsy.notifyservice.config.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "greensms")
public class SmsProperties {

    private String api;
    private String user;
    private String pass;
    private String from;
}
