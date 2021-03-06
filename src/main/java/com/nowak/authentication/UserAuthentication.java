package com.nowak.authentication;

import com.nowak.dao.UserDao;
import com.nowak.db_entities.User;
import com.nowak.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class UserAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    private UserDetailsService userDetailsService;

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession httpSession = httpServletRequest.getSession();
        String username = authentication.getName();
        User user = userDetailsService.findUserByUsername(username);
        httpSession.setAttribute("users",user);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/");
    }
}
