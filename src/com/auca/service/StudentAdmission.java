package com.auca.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class StudentAdmission extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the file parts from the request
        Collection<Part> parts = request.getParts();

        for (Part part : parts) {
            // Process each part
            if (part.getContentType() != null) {
                // This is a file part
                String fileName = getFileName(part);
                
                // Check file type and save to the server
                if (fileName != null && (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".pdf"))) {
                    // Replace "/path/to/your/upload/directory" with your server's actual path
                    String filepath = "D:\\";
                    
                    // Create the directory if it doesn't exist
                    File uploadDir = new File(filepath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }
                    
                    // Save the file to the server
                    part.write(filepath + File.separator + fileName);
                    
                    // Handle successful upload here (e.g., display a success message)
                    PrintWriter out = response.getWriter();
                    out.println("Uploaded Successfully");
                } else {
                    // Handle invalid file type
                	PrintWriter out = response.getWriter();
                    out.println("Uploaded Unsuccessfully");
                }
            }
        }
    }
    
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
