package com.dtpsy.notifyservice.service;

import com.dtpsy.notifyservice.dto.SendStatusDto;
import com.dtpsy.notifyservice.config.MailConfig;
import com.dtpsy.notifyservice.service.i.IEmailSendService;
import jakarta.mail.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.Transport;

@Service
@AllArgsConstructor
public class EmailSendService implements IEmailSendService {

    private MailConfig mailconfiguration;
    private Session session;

    private final RedisLoggerService redisLoggerService;


    public SendStatusDto sendEmail(String email, String content) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(mailconfiguration.getUserhost()));
            InternetAddress[] addresses = {new InternetAddress(email)};
            msg.setRecipients(Message.RecipientType.TO, addresses);
            msg.setContent(content, "text/html");
            Transport.send(msg);
            redisLoggerService.saveContent(content);
            return new SendStatusDto(true, "EMAIL sent successfully.");
        } catch (MessagingException e) {
            return new SendStatusDto(false, "Error sending EMAIL: " + e.getMessage());
        }
    }


}



