package com.dtpsy.notifyservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import com.dtpsy.notifyservice.config.properties.SmsProperties;
import java.util.Collections;

@Configuration
public class SmsConfig {

    private SmsProperties smsProperties;


    public SmsConfig(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(smsProperties.getApi())
                .defaultUriVariables(Collections.singletonMap("user", smsProperties.getUser()))
                .defaultUriVariables(Collections.singletonMap("pass", smsProperties.getPass()))
                .defaultUriVariables(Collections.singletonMap("from", smsProperties.getFrom()))
                .build();
    }
}
