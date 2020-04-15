package com.learn.users;

import com.learn.users.entities.Bundle;
import com.learn.users.entities.User;
import com.learn.users.enums.GenderType;
import com.learn.users.repositories.BundleRepository;
import com.learn.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	UserRepository userRepository;

	@Autowired
	BundleRepository bundleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	void CommandLineRunner() {
		/* CREATE PACKAGE */
		Bundle bundle1 = new Bundle();
//		bundle1.setId(1L);
		bundle1.setName("Lifetime Subscription");

		Bundle bundle2 = new Bundle();
//		bundle2.setId(2L);
		bundle2.setName("Free Subscription");

		/* CREATING Users */
		User user1 = new User();
		user1.setFirstName("Sean");
		user1.setLastName("Murphy");
		user1.setEmail(user1.getEmail() + "@abc.com");
		user1.setGender(GenderType.MALE);

		User user2 = new User();
		user2.setFirstName("Barry");
		user2.setLastName("Johnson");
		user2.setEmail(user2.getEmail() + "@abc.com");
		user2.setGender(GenderType.MALE);

		User user3 = new User();
		user3.setFirstName("Janet");
		user3.setLastName("Warren");
		user3.setEmail(user3.getEmail() + "@abc.com");
		user3.setGender(GenderType.MALE);

		User user4 = new User();
		user4.setFirstName("Pamela");
		user4.setLastName("Smith");
		user4.setEmail(user4.getEmail() + "@abc.com");
		user4.setGender(GenderType.FEMALE);

		User user5 = new User();
		user5.setFirstName("Eric");
		user5.setLastName("Miller");
		user5.setEmail(user5.getEmail() + "@abc.com");
		user5.setGender(GenderType.MALE);

		user1.setBundle(bundle1);
		user2.setBundle(bundle1);
		user3.setBundle(bundle2);
		user4.setBundle(bundle2);
		user5.setBundle(bundle2);

		bundleRepository.saveAll(Arrays.asList(bundle1, bundle2));
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
	}
}
