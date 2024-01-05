package com.riffs.listnr;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.riffs.listnr.domain.User;
import com.riffs.listnr.service.UserService;

@SpringBootApplication
public class ListnrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListnrApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new ParameterNamesModule());
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/JSON/personData.json");
			try {
				List<User> users = mapper.readValue(inputStream, typeReference);
				System.out.println(users);
				userService.save(users);
				System.out.println("Users Saved");
			} catch (IOException e) {
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}

}
