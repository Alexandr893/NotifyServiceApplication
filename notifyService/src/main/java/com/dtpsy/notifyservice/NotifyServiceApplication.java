package com.dtpsy.notifyservice;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import jakarta.mail.Store;
import jakarta.mail.Session;
import jakarta.mail.Folder;
import jakarta.mail.MessagingException;
import java.security.NoSuchProviderException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotifyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifyServiceApplication.class, args);


	}
}

