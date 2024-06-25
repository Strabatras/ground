package ru.dedus.ground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.dedus.ground.listener.UserService;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		UserService userService = context.getBean(UserService.class);

		logger.atInfo().setMessage("From string").log();
		userService.createUser("James");

		logger.atInfo().setMessage("From list").log();
		var names = Arrays.asList("Michael", "Robert", "John", "David", "William");
		userService.createUser(names);
	}
}
