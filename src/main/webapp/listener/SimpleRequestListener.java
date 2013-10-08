package main.webapp.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SimpleRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		requestEvent.getServletContext().log("Событие инициализации запроса");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent requestEvent) {
		requestEvent.getServletContext().log("Событие уничтожения запроса");
	}

}
