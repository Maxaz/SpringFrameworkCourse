package guru.springframework.spring6section3.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("EN")
@SpringBootTest
class My18NControllerTestEN {

    @Autowired
    My18NController my18NController;

    @Test
    void sayHello() {
        System.out.println(my18NController.sayHello());
    }
}