package com.dtpsy.notifyservice.config;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import java.util.Properties;
import jakarta.mail.Session;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "smtp")
public class MailConfig {

    private String host;
    private String userhost;
    private String passwordhost;
    private int port;


    @Bean
    public Session smtpSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userhost, passwordhost);}
        });
    }

}