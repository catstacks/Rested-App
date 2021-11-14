package com.qa.rested;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.qa.rested.domain.DailySleep;

@SpringBootTest 
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test") 
public class SleepIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddSleep() throws Exception {
		DailySleep requestBody = new DailySleep();
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/user/addSleep").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		DailySleep responseBody = new DailySleep();
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		RequestMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect((ResultMatcher) checkBody);
	}

	@Test
	void testSleepNotFound() throws Exception {
		this.mvc.perform(get("/user/getSleep/9999999")).andExpect(status().isNotFound());
	}

	@Test
	void testGetSleep() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new DailySleep());
		this.mvc.perform(get("/users/getSleep/1")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(responseBody));
	}
	
	@Test
	void testReplaceSleep() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new DailySleep());

		RequestBuilder request = put("/sleep/replaceSleep/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = (ResultMatcher) content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}



	@Test
	void testDeleteSleep() throws Exception {
		this.mvc.perform(delete("/user/removeSleep/1")).andExpect(status().isNoContent());
	}

}
