package main.webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SimpleSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		ServletContext servletContext = sessionEvent.getSession()
				.getServletContext();
		servletContext.log("Открыта новая сессия");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		ServletContext servletContext = sessionEvent.getSession()
				.getServletContext();
		servletContext.log("Cессия закрыта");
	}

}
