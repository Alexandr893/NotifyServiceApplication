package com.dtpsy.notifyservice.controller;

import com.dtpsy.notifyservice.dto.SmsRequestDto;
import com.dtpsy.notifyservice.dto.EmailRequestDto;
import com.dtpsy.notifyservice.service.SmsSendService;
import com.dtpsy.notifyservice.service.EmailSendService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/send")
@AllArgsConstructor
public class SendController {
    private final SmsSendService smsSendService;
    private final EmailSendService emailSendService;


    @PostMapping("/email")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailRequestDto emailRequest) {
        emailSendService.sendEmail(emailRequest.getEmail(), emailRequest.getContent());
        return ResponseEntity.ok().build();
    }


    @PostMapping("/sms")
    public ResponseEntity<Void> sendSms(@Valid @RequestBody SmsRequestDto smsRequestDTO) {
        smsSendService.sendSms(smsRequestDTO.getPhone(), smsRequestDTO.getContent());
        return ResponseEntity.ok().build();
    }
}
