package main.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.webapp.bean.CustomerBean;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/contexttest" })
public class ContextBindServlet extends HttpServlet {

	private static final String ATTRIBUTE_NAME = "customer";
	private static final String CONTEXTTEST_PAGE_NAME = "contexttest.jsp";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CustomerBean beanForRequestContext = new CustomerBean("Steven", "King");
		CustomerBean beanForSessionContext = new CustomerBean("James",
				"Gosling");
		CustomerBean beanForAppContext = new CustomerBean("Viktor", "Tsoy");

		HttpSession session = request.getSession();
		ServletContext servletContext = getServletContext();

		session.setAttribute(ATTRIBUTE_NAME, beanForSessionContext);
		request.setAttribute(ATTRIBUTE_NAME, beanForRequestContext);
		servletContext.setAttribute(ATTRIBUTE_NAME, beanForAppContext);

		request.getRequestDispatcher(CONTEXTTEST_PAGE_NAME).forward(request,
				response);
	}

}
