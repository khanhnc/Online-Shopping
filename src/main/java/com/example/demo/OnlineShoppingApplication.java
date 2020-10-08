package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineShoppingApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository) throws Exception {
		return (String[] args) -> {
			User user1 = new User("admin", "admin");
			User user2 = new User("user2", "user2");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
