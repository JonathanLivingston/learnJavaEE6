package main.webapp.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import main.webapp.util.Constants;

@SuppressWarnings("serial")
public class MultipleValueFieldHandlerServlet extends HttpServlet {

	private static final String OPTIONS_PARAM_NAME = "options";

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> checkedOptionsList = null;

		response.setContentType(MediaType.TEXT_HTML);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());

		String[] selectedOptions = request
				.getParameterValues(OPTIONS_PARAM_NAME);
		if (selectedOptions != null) {
			checkedOptionsList = new ArrayList<String>(selectedOptions.length);
			for (String selectedOption : selectedOptions) {
				byte[] originalString = selectedOption
						.getBytes(StandardCharsets.ISO_8859_1);
				checkedOptionsList.add(new String(originalString,
						StandardCharsets.UTF_8));
			}
		}

		request.setAttribute(Constants.CHECKED_LABELS_PARAM_NAME,
				checkedOptionsList);
		request.getRequestDispatcher(
				Constants.CONFIRMATION_SERVLET_URL_PATTERN_NAME).forward(
				request, response);
	}

}
