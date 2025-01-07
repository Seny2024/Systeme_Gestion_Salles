
package com.example.sallereservation;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "homePage", value = "/hello-servlet")
public class HomePage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Rediriger vers index.jsp
        response.sendRedirect("index.jsp");
    }
}