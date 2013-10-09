package main.webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import main.webapp.servlet.ProgrammaticallyConfiguredServlet;

@WebListener
public class SimpleServletContextListener implements ServletContextListener {

	private static final String PROGRAMMATICALLY_CONFIGURED_SERVLET_URL_MAPPING = "/programmaticallyConfiguredServlet";

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		try {
			ProgrammaticallyConfiguredServlet servlet = servletContext
					.createServlet(ProgrammaticallyConfiguredServlet.class);
			servletContext.addServlet(
					ProgrammaticallyConfiguredServlet.class.getSimpleName(),
					servlet);
			ServletRegistration registration = servletContext
					.getServletRegistration(ProgrammaticallyConfiguredServlet.class
							.getSimpleName());
			registration
					.addMapping(PROGRAMMATICALLY_CONFIGURED_SERVLET_URL_MAPPING);
		} catch (ServletException servletException) {
			servletException.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

}
