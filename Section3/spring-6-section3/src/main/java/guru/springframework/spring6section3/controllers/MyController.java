package guru.springframework.spring6section3.controllers;

import guru.springframework.spring6section3.services.GreetingService;
import guru.springframework.spring6section3.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello(){
        System.out.println("I'm in the controller!");

        return greetingService.sayGreeting();
    }
}
