package main.webapp.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/asyncServlet" }, asyncSupported = true)
@SuppressWarnings("serial")
public class AsynchronousServlet extends HttpServlet {

	private static final int THREAD_SLEEP_TIME_MS = 10000;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final Logger logger = Logger.getLogger(AsynchronousServlet.class
				.getName());
		final AsyncContext asyncContext = request.startAsync();
		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				logger.log(Level.INFO, "Начало обработки асинхронного запроса");
				try {
					Thread.sleep(THREAD_SLEEP_TIME_MS);
					asyncContext.getResponse().getWriter().println("ALF");
					logger.log(Level.INFO,
							"Обработка асинхронного запроса заввершена");
					asyncContext.complete();
				} catch (InterruptedException interruptedException) {
					logger.log(Level.INFO, interruptedException.getMessage());
				} catch (IOException ioException) {
					logger.log(Level.INFO, ioException.getMessage());
				}

			}
		});
	}

}
