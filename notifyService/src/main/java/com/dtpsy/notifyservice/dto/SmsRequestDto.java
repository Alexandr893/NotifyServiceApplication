package com.dtpsy.notifyservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequestDto {

    @NotEmpty(message = "Номер телефона не может быть пустым")
    private String phone;

    @NotEmpty(message = "Содержимое не может быть пустым")
    private String content;

}
