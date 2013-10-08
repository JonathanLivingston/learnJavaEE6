package main.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import main.webapp.util.Constants;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/formhandlerservlet"})
public class FormHandlerServlet extends HttpServlet {

	private static final String ENTERED_VALUE_PARAM_NAME = "enteredValue";

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String enteredValue = new String(
				request.getParameter(ENTERED_VALUE_PARAM_NAME).getBytes(
						StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		response.setContentType(MediaType.TEXT_HTML);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		try (PrintWriter writer = response.getWriter()) {
			writer.println(Constants.HTML_TAG_P_OPEN);
			writer.println("Вы ввели: ");
			writer.println(enteredValue);
			writer.println(Constants.HTML_TAG_P_CLOSE);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

}
