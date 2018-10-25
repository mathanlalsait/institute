package com.candid.sma.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.candid.sma.model.User;
import com.candid.sma.repository.UserRepository;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Test
	public void testFindAllStudents_Size() {
		when(userRepository.findAll())
		.thenReturn( Arrays.asList(new User("RoshMohan", "rosh@gm.com", "77777777", "m"),
				new User("Rajaguru", "raja@gm.com", "77777777","m")));
		assertEquals(2, userService.findAllUsers().size());
		
	}
	
	@Test
	public void testFindStudents_byName() {
		User user=new User("RoshMohan", "rosh@gm.com", "77777777", "m");
		when(userRepository.findByFullName(Mockito.anyString()))
		.thenReturn((user));
		assertEquals(user, userService.findUserByFullName(Mockito.anyString()));
		
	}
	
	

}
