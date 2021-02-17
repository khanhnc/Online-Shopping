package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OnlineShoppingApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository) throws Exception {
		return (String[] args) -> {
//			Role adminRole = new Role("ADMIN");
//			Role userRole = new Role("USER");
//			roleRespository.save(adminRole);
//			roleRespository.save(userRole);
//
//			Set<Role> userRoleSet = new HashSet<>();
//			userRoleSet.add(userRole);
//			Set<Role> adminRoleSet = new HashSet<>();
//			adminRoleSet.add(adminRole);

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String adminPass = encoder.encode("admin");
			String userPass = encoder.encode("admin");
			User admin = new User("admin", adminPass, "admin@admin.com");
			User user = new User("test", userPass ,"user2@admin.com");
//			user.setRoles(userRoleSet);
//			admin.setRoles(adminRoleSet);
			userRepository.save(admin);
			userRepository.save(user);
		};
	}
}
