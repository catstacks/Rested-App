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
import com.qa.rested.domain.Water;

@SpringBootTest 
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:water-schema.sql",
		"classpath:water-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test") 
public class WaterIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddWater() throws Exception {
		Water requestBody = new Water();
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/water/addWater").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		Water responseBody = new Water();
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		RequestMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect((ResultMatcher) checkBody);
	}

	@Test
	void testWaterNotFound() throws Exception {
		this.mvc.perform(get("/water/getWater/9999999")).andExpect(status().isNotFound());
	}

	@Test
	void testGetWater() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new Water());
		this.mvc.perform(get("/waters/getWater/1")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(responseBody));
	}
	
	@Test
	void testReplaceWater() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new Water());

		RequestBuilder request = put("/water/replaceWater/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = (ResultMatcher) content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}



	@Test
	void testDeleteWater() throws Exception {
		this.mvc.perform(delete("/water/removeWater/1")).andExpect(status().isNoContent());
	}
}
