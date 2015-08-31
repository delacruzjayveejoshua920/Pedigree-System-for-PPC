package com.ppc.common.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationUtil {
	public static Authentication getAuthenticationDetails() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
