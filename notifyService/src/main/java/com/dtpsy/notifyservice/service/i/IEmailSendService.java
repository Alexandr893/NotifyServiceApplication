package com.dtpsy.notifyservice.service.i;

import com.dtpsy.notifyservice.dto.SendStatusDto;
import com.dtpsy.notifyservice.service.i.IEmailSendService;

public interface IEmailSendService {
    SendStatusDto sendEmail(String email, String content);
}
