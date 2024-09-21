package com.dtpsy.notifyservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class SendStatusDto {
    private boolean success;
    private String description;
}
