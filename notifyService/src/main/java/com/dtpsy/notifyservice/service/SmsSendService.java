package com.dtpsy.notifyservice.service;

import com.dtpsy.notifyservice.dto.SendStatusDto;
import com.dtpsy.notifyservice.service.i.ISmsSendService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class SmsSendService implements ISmsSendService {
        private final WebClient webClient;
        private final RedisLoggerService redisLoggerService;

        public SendStatusDto sendSms(String phone,String content){
                try {
                        this.webClient.post()
                                .uri(uriBuilder -> uriBuilder
                                        .queryParam("to", phone)
                                        .queryParam("txt", content)
                                        .build())
                                        .retrieve()
                                        .bodyToMono(Void.class)
                                        .doOnSuccess(__ -> redisLoggerService.saveContent(content))
                                        .block();

                        return new SendStatusDto(true, "SMS sent successfully.");
                } catch(Exception e){
                        return new SendStatusDto(false, "Error sending SMS: " + e.getMessage());
                }

        }
}


