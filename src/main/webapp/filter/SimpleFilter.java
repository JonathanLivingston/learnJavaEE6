package main.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/formhandlerservlet",
		"/multiplevaluefieldhandlerservlet", "/confirmationservlet",
		"/redirectionservlet" })
public class SimpleFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		ServletContext servletContext = filterConfig.getServletContext();
		servletContext.log("Выполнен запрос по адресу "
				+ servletRequest.getLocalAddr());
		filterChain.doFilter(servletRequest, servletResponse);
		servletContext.log("Запрос обработан");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
