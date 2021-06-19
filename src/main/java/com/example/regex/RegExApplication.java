package com.example.regex;

import com.company.regex.test.RegExTest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegExApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RegExApplication.class, args);
    }

    @Override
    public void run(String... args) {
        RegExTest.checkFromConsole();
    }
}
