package com.bmonish.springbootmongo;

import com.bmonish.springbootmongo.models.User;
import com.bmonish.springbootmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMongoApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public SpringbootMongoApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findAll().isEmpty()) {
			userRepository.save(new User("Alice", "Johnson"));
			userRepository.save(new User("Bob", "the Builder"));
		}

		for (User user: userRepository.findAll()) {
			System.out.println(user);
		}
	}
}
