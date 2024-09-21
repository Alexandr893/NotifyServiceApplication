package com.dtpsy.notifyservice.service.i;

import com.dtpsy.notifyservice.dto.SendStatusDto;

public interface ISmsSendService {
    SendStatusDto sendSms(String phone, String content);
}
