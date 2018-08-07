package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Value(value="${WELCOME_MESSAGE:NOT SET}")
    String message;

    public WelcomeController() {

    }
    public WelcomeController(String message) {
        this.message=message;
    }

    public void setMessage(String message) {
        this.message=message;
    }
    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}
