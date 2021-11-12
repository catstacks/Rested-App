package com.qa.rested.rest;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController extends AbstractController {
	
	@PostMapping("/userpassword")
    public LoginResponse doLogin(
            @RequestBody final Map<String, Object> payload,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        // Validate inputs
        final LoginResponse loginResponse = new LoginResponse();
        if (payload.get("username") == null || !(payload.get("username") instanceof String)
                || payload.get("password") == null || !(payload.get("password") instanceof String)) {
            loginResponse.setError("Valid username and password required");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return loginResponse;
        }

}
