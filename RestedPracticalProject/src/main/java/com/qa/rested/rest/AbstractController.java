package com.qa.rested.rest;

import com.qa.rested.dto.RestedDTO;
import com.qa.rested.service.RestedUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.LocalTime;
import java.time.LocalDate;

public abstract class AbstractController {

    static final String SLEEP_TEMPLATE = "sleep";
    static final String REPORT_TEMPLATE = "report";

    final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    RestedUserService restedService;

    final RestedDTO currentAuthenticatedUser(final HttpServletRequest request) {
        return restedService.findByEmail((String) request.getAttribute("email"));
    }

    final java.sql.Date stringToSqlDate(final String dateString) {
        java.sql.Date date;
        try {
            date = java.sql.Date.valueOf(dateString);
        } catch (final IllegalArgumentException e) {
            e.printStackTrace();
            date = new java.sql.Date(new Date().getTime());
        }
        return date;
    }

    final java.sql.Date todaySqlDateForUser(final RestedDTO user) {
        if (user == null) {
            return new java.sql.Date(new Date().getTime());
        } else {
            final ZoneId timeZone = ZoneId.of(user.getTimeZone());
            final ZonedDateTime zonedDateTime = ZonedDateTime.now(timeZone);
            return new java.sql.Date(zonedDateTime.toLocalDate().atStartOfDay(timeZone).toInstant().toEpochMilli());
        }
    }

}
