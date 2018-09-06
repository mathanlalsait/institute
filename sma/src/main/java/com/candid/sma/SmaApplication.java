package com.candid.sma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.candid.sma.model.User;
import com.candid.sma.repository.CustomizedUserRepository;
import com.candid.sma.service.UserService;

@SpringBootApplication
public class SmaApplication implements CommandLineRunner {
	//@Autowired
	//private CustomRepository repository;
	@Autowired
	private UserService userService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//repository.deleteAll();
		
		//userService.saveUser(new User("RoshMohan","rosh@gm.com"));
		userService.saveUser(new User("RajaGuru", "raja@gm.com", "898989", "25/10/1980", 18, "m", "online", "chrompet","chrompet","TN"));
		// save a couple of users
		//repository.save(new User("Job", "job@gm.com"));
		//repository.save(new User("Bob", "bob@gm.com"));

		// fetch all customers
		/*System.out.println("User found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}*/
		System.out.println();

		// fetch an individual customer
		System.out.println("User found with findByFirstName('RajaGuru'):");
		System.out.println("--------------------------------");
		//System.out.println(repository.findByFullName("RajaGuru"));

		System.out.println("Customers found with findByEmail('raja@gm.com')");
		System.out.println("--------------------------------");

		//System.out.println(repository.findByEmail("raja@gm.com"));

		/*
		 * for (User user : repository.findByEmail("Smith")) { System.out.println(user);
		 * }
		 */

	}
}
