package com.example.sallereservation.util;

import com.example.sallereservation.model.User;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();

        // Autoriser l'accès à certaines ressources sans authentification
        if (requestURI.endsWith("index.jsp") || requestURI.endsWith("/") ||
                requestURI.contains("login") || requestURI.contains("css") || requestURI.contains("js")) {
            chain.doFilter(request, response);
            return;
        }

        // Vérifier si l'utilisateur est connecté
        User user = (User) httpRequest.getSession().getAttribute("user");
        if (user == null) {
            httpResponse.sendRedirect("login.jsp");
            return;
        }

        // Vérifier le rôle de l'utilisateur pour certaines pages
        if (requestURI.contains("addUser") && !user.getRole().equals("admin")) {
            httpResponse.sendRedirect("accessDenied.jsp");
            return;
        }
        if (requestURI.contains("editUser") && !user.getRole().equals("admin")) {
            httpResponse.sendRedirect("accessDenied.jsp");
            return;
        }
        if (requestURI.contains("deleteUser") && !user.getRole().equals("admin")) {
            httpResponse.sendRedirect("accessDenied.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    public void destroy() {}
}
