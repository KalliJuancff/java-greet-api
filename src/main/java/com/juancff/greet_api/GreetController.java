package com.juancff.greet_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
public class GreetController {

    @GetMapping(value = "/greet", produces = "text/plain")
    public String greet(@RequestParam(name = "lang", required = false, defaultValue = "ES") String lang) {
        Locale locale = "EN".equalsIgnoreCase(lang) ? Locale.ENGLISH : Locale.forLanguageTag("es-ES");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        if ("EN".equalsIgnoreCase(lang)) {
            return "Hello world!\n" +
                    "Current date/time: " + formattedDateTime;
        } else {
            return "¡Hola mundo!\n" +
                    "Fecha/hora actual: " + formattedDateTime;
        }
    }
}
