package com.ioet.supermarket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/message")
public class HelloWorldController {

    @GetMapping("/hello")
    public String messageGodDay() {
        return "Nunca pares de aprender!";
    }
}
