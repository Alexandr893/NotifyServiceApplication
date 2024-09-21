package com.dtpsy.notifyservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
    @Email(message = "Пожалуйста, введите действительный адрес электронной почты")
    private String email;

    @NotEmpty(message = "Содержимое не может быть пустым")
    private String content;
}
