package main.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import main.webapp.bean.CountryBean;
import main.webapp.util.Constants;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/countries" })
public class JDBCSelectCountryListServlet extends HttpServlet {

	private static final String COUNTRIES_PAGE_NAME = "countries.jsp";
	private static final String COUNTRY_LIST_ATTRIBUTE_NAME = "countryList";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sqlQuery = "select code, name from countries order by name";
		List<CountryBean> countryList = new ArrayList<>();

		try {
			// JNDI resources context
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource) initialContext
					.lookup(Constants.DB_RESOURCE_LINK);
			try (Connection connection = dataSource.getConnection();
					PreparedStatement statement = connection
							.prepareStatement(sqlQuery);
					ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					countryList.add(new CountryBean(resultSet.getString(1),
							resultSet.getString(2)));
				}
			}
		} catch (NamingException | SQLException exception) {
			exception.printStackTrace();
		}

		request.setAttribute(COUNTRY_LIST_ATTRIBUTE_NAME, countryList);
		request.getRequestDispatcher(COUNTRIES_PAGE_NAME).forward(request,
				response);
	}

}
