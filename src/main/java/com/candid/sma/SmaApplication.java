package com.candid.sma;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.candid.sma.model.Course;
import com.candid.sma.model.User;
import com.candid.sma.repository.UserRepositoryCustom;
import com.candid.sma.repository.UserRepository;
import com.candid.sma.service.UserService;

@SpringBootApplication
public class SmaApplication implements CommandLineRunner {
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserService userService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		
		Set<Course> course=new HashSet<Course>();
		course.add(new Course("JAVA"));
		course.add(new Course("SPRING"));
		//userService.saveUser(new User("RoshMohan","rosh@gm.com"));
		userService.saveUser(new User("RosMohan", "rosh@gm.com", "77777777", "25/10/1980", 32, "m", "online", "chrompet","chrompet","TN",true,course));
		userService.saveUser(new User("RajaGuru", "raj@gm.com", "88888888", "25/10/1980", 38, "m", "online", "chrompet","chrompet","TN",false,course));
		userService.saveUser(new User("Candid", "candid@gm.com", "9999999", "25/10/1980", 18, "m", "online", "chrompet","chrompet","TN",true,course));
		userService.saveUser(new User("Sajid", "sajid@gm.com", "666666666", "25/10/1980", 22, "m", "online", "chrompet","chrompet","TN",true,course));
		

		// save a couple of users
		//repository.save(new User("Job", "job@gm.com"));
		//repository.save(new User("Bob", "bob@gm.com"));

		// fetch all customers
		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("User found with findByFullName('RajaGuru'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFullName("RajaGuru"));

		System.out.println("User found with findByEmail('raj@gm.com')");
		System.out.println("--------------------------------");

		System.out.println(repository.findByEmail("raj@gm.com"));

		System.out.println("------------Updating UserPhone--------------------");

		System.out.print(repository.updateUserPhone("RoshMohan", "77"));

		// fetch an individual customer
		System.out.println("new Phone Number Updated found by phone:");
		System.out.println("--------------------------------");
		System.out.println(repository.findByPrimaryMobile("77"));
		
		
		
		
		// fetch all Active Users
				System.out.println("-------------------------------");
				for (User user : repository.findAllActiveUsers()) {
					System.out.println(user);
				}
				System.out.println();
				
				
				repository.deleteById("11");
		

	}
}
