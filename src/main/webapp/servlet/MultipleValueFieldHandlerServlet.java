package main.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MultipleValueFieldHandlerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter writer = response.getWriter()) {
			String[] selectedOptions = request.getParameterValues("options");
			writer.println("<p>");
			if (selectedOptions == null) {
				writer.println("Не было выбрано ни одной опции");
			} else {
				for (int i = 0; i < selectedOptions.length; i++) {
					byte[] originalString = selectedOptions[i].getBytes(StandardCharsets.ISO_8859_1);
					selectedOptions[i] = new String(originalString, StandardCharsets.UTF_8); 
				}
				writer.println("Были выбраны следующие опции: ");
				for (String string : selectedOptions) {
					writer.println("<br/>");
					writer.println(string);
				}
			}
			writer.println("</p>");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
}
