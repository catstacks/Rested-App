package com.qa.rested;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rested.domain.RestedUser;

@SpringBootTest 
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test") 
public class ScreenTimeIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		RestedUser requestBody = new RestedUser("Rex 2", "G. Shepherd", 44);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/puppy/create").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON); // sets up the test request

		RestedUser responseBody = new RestedUser(2, "Rex 2", "G. Shepherd", 44);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated(); // check the status code is 201
		ResultMatcher checkBody = content().json(responseBodyAsJSON); // check the body matches the example

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs request and checks the
																				// response
	}

	@Test
	void testRestedUserNotFound() throws Exception {
		this.mvc.perform(get("/puppy/get/9999999")).andExpect(status().isNotFound());
	}

	@Test
	void testGetAll() throws Exception {

		RequestBuilder request = get("/puppy/getAll");

		ResultMatcher checkStatus = status().isOk();

		RestedUser user = new RestedUser(1, "1999-01-01", 22, 1, "test.user@domain", "password", "test", "user");
		List<RestedUser> users = List.of(user);
		String responseBody = this.mapper.writeValueAsString(users);
		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGet() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new RestedUser(1, "1999-01-01", 22, 1, "test.user@domain", "password", "test", "user"));
		this.mvc.perform(get("/users/getUser/1")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(responseBody));
	}

	@Test
	void testReplace() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new RestedUser(2, "1981-06-09", 40, 1, "bob.user@domain", "password", "bob", "user"));

		RequestBuilder request = put("/puppy/replace/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/puppy/remove/1")).andExpect(status().isNoContent());
	}

}
