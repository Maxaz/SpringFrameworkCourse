package guru.springframework.spring6section3.services.i18n;

import guru.springframework.spring6section3.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("FR")
@Service("i18NService")
public class FrenchGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Salut Monde - FR";
    }
}
