package com.example.botsceduleapp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class BotSceduleAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(BotSceduleAppApplication.class, args);
    }

}
