package com.qa.rested.config;

import java.io.IOException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class JWT extends GenericFilterBean{
	
	final static private List<String> EXCLUDED_URIS = Arrays.asList("/login.html", "/api/auth/userpass","/favicon.ico");
	
	@Override
    public void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain
    ) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        
        if (
                EXCLUDED_URIS.contains(httpServletRequest.getRequestURI())
                    || httpServletRequest.getRequestURI().startsWith("/static")
        ) {
            chain.doFilter(request, response);
            return;
        }
        
        final String token =
                Optional.ofNullable(httpServletRequest.getHeader("Authorization")).orElse("").startsWith("Bearer ")
                    ? httpServletRequest.getHeader("Authorization").substring(7)
                    : Arrays.stream(Optional.ofNullable(httpServletRequest.getCookies()).orElse(new Cookie[0]))
                        .filter(cookie -> cookie.getName().equals("Authorization"))
                        .findFirst()
                        .orElse(new Cookie("Authorization", ""))
                        .getValue();
            if (token.isEmpty()) {
                logger.error("No valid Authorization header or cookie value found");
                ((HttpServletResponse) response).sendRedirect("/login.html");
                return;
            }
            
		}


	}
	

