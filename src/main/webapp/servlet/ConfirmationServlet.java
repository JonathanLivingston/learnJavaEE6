package main.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import main.webapp.util.Constants;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/confirmationservlet"})
public class ConfirmationServlet extends HttpServlet {

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(MediaType.TEXT_HTML);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		try (PrintWriter writer = response.getWriter()) {
			List<String> checkedLabels = (List<String>) request
					.getAttribute(Constants.CHECKED_LABELS_PARAM_NAME);

			if (checkedLabels == null) {
				writer.println("Не было выбрано ни одной опции");
			} else {
				writer.println("Были выбраны следующие опции: ");
				for (String checkedLabel : checkedLabels) {
					writer.println(Constants.HTML_TAG_BR);
					writer.println(checkedLabel);
				}
			}
			writer.println(Constants.HTML_TAG_P_CLOSE);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
