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
import com.qa.rested.domain.WeeklyReportData;
import com.qa.rested.domain.Report;

@SpringBootTest 
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test") 
public class WkReportIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddReport() throws Exception {
		WeeklyReportData requestBody = new WeeklyReportData();
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/report/addReport").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		WeeklyReportData responseBody = new WeeklyReportData();
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		RequestMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect((ResultMatcher) checkBody);
	}

	@Test
	void testReportNotFound() throws Exception {
		this.mvc.perform(get("/report/getReport/9999999")).andExpect(status().isNotFound());
	}

	@Test
	void testGetReport() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new WeeklyReportData());
		this.mvc.perform(get("/reports/getReport/1")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(responseBody));
	}
	
	@Test
	void testReplaceReport() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new WeeklyReportData());

		RequestBuilder request = put("/report/replaceReport/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = (ResultMatcher) content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}



	@Test
	void testDeleteReport() throws Exception {
		this.mvc.perform(delete("/report/removeReport/1")).andExpect(status().isNoContent());
	}

}
