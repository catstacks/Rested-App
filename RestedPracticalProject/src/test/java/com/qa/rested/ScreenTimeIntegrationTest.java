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
import com.qa.rested.domain.ScreenTime;

@SpringBootTest 
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:screen-schema.sql",
		"classpath:screen-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test") 
public class ScreenTimeIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddScreen() throws Exception {
		ScreenTime requestBody = new ScreenTime();
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/screen/addScreen").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		ScreenTime responseBody = new ScreenTime();
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		RequestMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect((ResultMatcher) checkBody);
	}

	@Test
	void testScreenNotFound() throws Exception {
		this.mvc.perform(get("/screen/getScreen/9999999")).andExpect(status().isNotFound());
	}

	@Test
	void testGetScreen() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new ScreenTime());
		this.mvc.perform(get("/screens/getScreen/1")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(responseBody));
	}
	
	@Test
	void testReplaceScreen() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new ScreenTime());

		RequestBuilder request = put("/screen/replaceScreen/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = (ResultMatcher) content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}



	@Test
	void testDeleteScreen() throws Exception {
		this.mvc.perform(delete("/screen/removeScreen/1")).andExpect(status().isNoContent());
	}
}
