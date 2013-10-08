package main.webapp.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/redirectionservlet"})
public class ResponseRedirectionServlet extends HttpServlet {

	private static final String SEARCH_ENGINE_PARAM_NAME = "searchEngine";

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(MediaType.TEXT_HTML);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		String redirectUrl = request.getParameter(SEARCH_ENGINE_PARAM_NAME);
		if (redirectUrl == null) {
			response.getWriter().println(
					"Ни одна поисковая система не была выбрана");
		} else {
			response.sendRedirect(redirectUrl);
		}
	}

}
