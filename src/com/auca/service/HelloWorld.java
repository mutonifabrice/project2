package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        if ("kmlcharles@gmail.com".equals(username) && "12345".equals(password)) {
            try {
                res.sendRedirect("index.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {            
            res.sendRedirect("forgotpassword.html"); 
        }
    }
}
