package guru.springframework.spring6section3;

import guru.springframework.spring6section3.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring6Section3Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Spring6Section3Application.class, args);

		MyController controller = ctx.getBean(MyController.class);

		System.out.println("I'm Main Method");

		System.out.println(controller.sayHello());
	}

}
