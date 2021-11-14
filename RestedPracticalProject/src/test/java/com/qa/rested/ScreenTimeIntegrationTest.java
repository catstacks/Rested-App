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
import org.springframework.test.web.client.RequestMatcher;
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
	void testAddUser() throws Exception {
		RestedUser requestBody = new RestedUser(1, "1999-01-01", 22, 1, "test.user@domain", "password", "test", "user");
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/user/addUser").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		RestedUser responseBody = new RestedUser(2, "1989-01-01", 32, 3, "bob.user@domain", "password", "bob", "user");
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		RequestMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect((ResultMatcher) checkBody);
	}

	@Test
	void testRestedUserNotFound() throws Exception {
		this.mvc.perform(get("/user/getUser/9999999")).andExpect(status().isNotFound());
	}

	@Test
	void testGetUser() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new RestedUser(1, "1999-01-01", 22, 1, "test.user@domain", "password", "test", "user"));
		this.mvc.perform(get("/users/getUser/1")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(responseBody));
	}


	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/user/removeUser/1")).andExpect(status().isNoContent());
	}

}
