package org.spring.panda.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		return "/dashboard";
	}
}
