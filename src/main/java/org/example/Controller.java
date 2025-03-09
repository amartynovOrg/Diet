package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Указывает, что это REST-контроллер
@RequestMapping("/api") // Базовый URL для запросов
public class Controller {

    @GetMapping("/hello") // Обрабатывает GET-запрос на /api/hello
    public String sayHello() {
        return "Привет, Spring Boot!";
    }
}