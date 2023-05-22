package guru.springframework.spring6section3.controllers;

import guru.springframework.spring6section3.services.EnvironmentService;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {
    private final EnvironmentService environmentService;

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String getEnvironment(){
        return "The environmnent is : " + environmentService.getEnv();
    }
}
