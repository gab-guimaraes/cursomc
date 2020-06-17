package com.johnwick.cursomc.config;

import com.johnwick.cursomc.service.DBService;
import com.johnwick.cursomc.service.EmailService;
import com.johnwick.cursomc.service.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDataBase();
        return true;
    }
}
