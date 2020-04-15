package com.learn.users;

import com.learn.users.entities.Book;
import com.learn.users.entities.Bundle;
import com.learn.users.entities.User;
import com.learn.users.enums.GenderType;
import com.learn.users.repositories.BookRepository;
import com.learn.users.repositories.BundleRepository;
import com.learn.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	UserRepository userRepository;

	@Autowired
	BundleRepository bundleRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	void CommandLineRunner() {
		/* CREATE PACKAGE */
		Bundle bundle1 = new Bundle().setName("Lifetime Subscription");
		Bundle bundle2 = new Bundle().setName("Free Subscription");

		/* CREATING Users */
		User user1 = new User()
				.setFirstName("Sean")
				.setLastName("Murphy")
				.setEmail("sean@abc.com")
				.setGender(GenderType.MALE);

		User user2 = new User()
				.setFirstName("Barry")
				.setLastName("Johnson")
				.setEmail("barry@abc.com")
				.setGender(GenderType.MALE);

		User user3 = new User()
				.setFirstName("Janet")
				.setLastName("Warren")
				.setEmail("janet@abc.com")
				.setGender(GenderType.MALE);

		User user4 = new User()
				.setFirstName("Pamela")
				.setLastName("Smith")
				.setEmail("pamela@abc.com")
				.setGender(GenderType.FEMALE);

		User user5 = new User()
				.setFirstName("Eric")
				.setLastName("Miller")
				.setEmail("eric@abc.com")
				.setGender(GenderType.MALE);

		user1.setBundle(bundle1);
		user2.setBundle(bundle1);
		user3.setBundle(bundle2);
		user4.setBundle(bundle2);
		user5.setBundle(bundle2);

		/* Create Book */
		Book book1 = new Book().setName("Ramayan")
				.setDescription("Book written on shri ram")
				.setPrice(1000)
				.setPublishedOn(new Date());

		Book book2 = new Book().setName("Perfect tunes")
				.setDescription("Jamie Arther")
				.setPrice(2000)
				.setPublishedOn(new Date());

		book1.setAuthor(user3);
		book2.setAuthor(user4);

		bundleRepository.saveAll(Arrays.asList(bundle1, bundle2));
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
		bookRepository.saveAll(Arrays.asList(book1, book2));
	}
}
