package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShoppingApplication {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		User user = new User("admin","admin");
		this.userRepository.save(user)
		SpringApplication.run(OnlineShoppingApplication.class, args);
	}

}
