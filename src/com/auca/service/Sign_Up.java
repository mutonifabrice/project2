package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sign_Up extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email, password;

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        email = req.getParameter("Email");
        password = req.getParameter("password");

        if (email != null && password != null) {
            res.sendRedirect("login.html");
        } else {
            PrintWriter showmes = res.getWriter();
            showmes.println("Enter Values");
        }
    }
}
