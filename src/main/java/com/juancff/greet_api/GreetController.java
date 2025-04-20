package com.juancff.greet_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class GreetController {

    @GetMapping(value = "/greet", produces = "text/plain")
    public String greet() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        return "¡Hola mundo!\n" +
                "Fecha/hora actual: " + formattedDateTime;
    }

}
