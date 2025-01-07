package com.example.sallereservation.util;

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
        if (httpRequest.getSession().getAttribute("user") == null) {
            httpResponse.sendRedirect("login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    public void destroy() {}
}
