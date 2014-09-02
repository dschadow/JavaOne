/*
 * Copyright (C) 2014 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of the Java Security project.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.javasecurity.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CSPServlet", urlPatterns = {"/csp"})
public class CSPServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("cspName");

        logger.info("Received {} as name", name);

        response.setContentType("text/html");
        response.setHeader("Content-Security-Policy", "default-src 'self'");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title>XSS - Content Security Policy</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>XSS - Content Security Policy</h1>");
            out.println("<p>[" + name + "]</p>");
            out.println("<p><a href=\"index.jsp\">Home</a></p>");
            out.println("</body></html>");
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
