package com.candid.sma.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.candid.sma.controller.UserController;
import com.candid.sma.model.User;
import com.candid.sma.repository.UserRepository;
import com.candid.sma.repository.UserRepositoryCustomImpl;
import com.candid.sma.service.UserService;
import com.candid.sma.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
/**
 * 
 * @author ROSH MOHAN
 * This is Used to test UserController.For testing we are mocking Service Layer
 *
 */
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserServiceImpl userService;

	
		
	@Test()
	public void retriveAllStudents() throws Exception {
		User user=new User();
		
		when(userService.findAllUsers()).thenReturn( Arrays.asList(new User("RosMohan", "rosh@gm.com", "77777777", "m"),
				new User("Rajaguru", "raja@gm.com", "77777777","m")));
		
		RequestBuilder request=MockMvcRequestBuilders
				.get("/getAllUsers") 
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{fullName:RosMohan,email:rosh@gm.com}, {fullName:Rajaguru,email:raja@gm.com}]"))
				.andReturn();
		JSONAssert.assertEquals("[{fullName:RosMohan,email:rosh@gm.com}, {fullName:Rajaguru,email:raja@gm.com}]", result.getResponse().getContentAsString(), false);
		
	}
}
