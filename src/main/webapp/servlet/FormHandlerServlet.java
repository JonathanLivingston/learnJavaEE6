package main.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FormHandlerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String enteredValue = new String(request.getParameter("enteredValue")
				.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter writer = response.getWriter()) {
			writer.println("<p>");
			writer.println("Вы ввели: ");
			writer.println(enteredValue);
			writer.println("</p>");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

}
