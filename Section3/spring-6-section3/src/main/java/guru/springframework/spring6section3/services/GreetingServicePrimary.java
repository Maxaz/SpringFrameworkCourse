package guru.springframework.spring6section3.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class GreetingServicePrimary implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello from the primary bean!";
    }
}