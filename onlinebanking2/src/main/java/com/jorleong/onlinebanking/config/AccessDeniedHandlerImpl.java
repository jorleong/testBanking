package com.jorleong.onlinebanking.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		Authentication authenticaction = SecurityContextHolder.getContext().getAuthentication();
		if(authenticaction != null) {
			//anything that has to do with authentication
			System.out.println(authenticaction.getName() + " is not allowed to access " + request.getRequestURI());
		}
		response.sendRedirect(request.getContextPath() + "/accessDenied");
	}

}
