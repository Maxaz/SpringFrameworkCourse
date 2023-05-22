package guru.springframework.spring6section3.controllers.i18n;

import guru.springframework.spring6section3.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class My18NController {
    private final GreetingService greetingService;

    public My18NController(@Qualifier("i18NService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
