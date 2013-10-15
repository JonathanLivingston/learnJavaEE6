package main.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.webapp.bean.AddressBean;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/tagtest2" })
public class CustomTagDemoServlet extends HttpServlet {

	private static final String ADDRESS_JSP_ATTRIBUTE_NAME = "address";
	private static final String TAGTEST_PAGE_NAME = "tagtest2.jsp";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AddressBean addressBean = new AddressBean();
		addressBean.setCountry("RUS");
		addressBean.setCity("St. Petersburg");
		addressBean.setStreet("Nevskiy avenue");
		addressBean.setPostalcode("143920");
		request.setAttribute(ADDRESS_JSP_ATTRIBUTE_NAME, addressBean);
		request.getRequestDispatcher(TAGTEST_PAGE_NAME).forward(request,
				response);
	}

}
