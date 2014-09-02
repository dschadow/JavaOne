package de.dominikschadow.javasecurity.servlets;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dos on 02.09.14.
 */
@WebServlet(name = "OutputEscapedServlet", urlPatterns = {"/escaped"})
public class OutputEscapedServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("outputEscapedName");

        logger.info("Received {} as name", name);

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title>XSS - Output Escaping</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>XSS - Output Escaping</h1>");
            out.println("<p><strong>For HTML </strong>");
            Encode.forHtml(out, name);
            out.println("</p>");
            out.println("<p><strong>For HTML Content </strong>");
            Encode.forHtmlContent(out, name) ;
            out.println("</p>");
            out.println("<p><strong>For HTML Attribute </strong>");
            Encode.forHtmlAttribute(out, name);
            out.println("</p>");
            out.println("<p><strong>For CSS  </strong>");
            Encode.forCssString(out, name);
            out.println("</p>");
            out.println("<p><strong>For URI </strong>");
            Encode.forUri(out, name);
            out.println("</p>");
            out.println("<p><a href=\"index.jsp\">Home</a></p>");
            out.println("</body></html>");
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
