package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OnlineShoppingApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository) throws Exception {
		return (String[] args) -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String adminPass = encoder.encode("admin");
			String userPass = encoder.encode("admin");
			User user1 = new User("admin", adminPass, "admin@admin.com");
			User user2 = new User("test", userPass ,"user2@admin.com");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
