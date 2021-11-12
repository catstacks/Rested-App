package com.qa.rested.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qa.rested.domain.RestedUser;
import com.qa.rested.domain.WeeklyReportData;
import com.qa.rested.dto.RestedDTO;
import com.qa.rested.service.WkReportService;

public class WkReportController extends AbstractController {
	
	 private final WkReportService wkReportService;

	    @Autowired
	    public WkReportController(final WkReportService wkReportService) {
	        this.wkReportService = wkReportService;
	    }
	    
	    @GetMapping("/getReport/{id}")
		public WeeklyReportData getReport(@PathVariable Integer id) {
			return this.wkReportService.getReport(id);
		}

	    @GetMapping("/report")
	    public final String viewReport() {
	        return REPORT_TEMPLATE;
	    }

	    @GetMapping("/report/get")
	    @ResponseBody
	    public final List<WeeklyReportData> getReportData(final HttpServletRequest request) {
	        final RestedDTO userDTO = currentAuthenticatedUser(request);
	        return wkReportService.findByUser(userDTO.getId());
	    }


}
