<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Enumeration"%>
<%@ page import="main.webapp.util.Constants"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Implicit Java Objects at JSP pages</title>
</head>
<body>
	<p>Some very interesting content</p>
	<p>
		<%
			application.setAttribute("applicationAttribute",
					"SOME VERY VALUEBLE DATA");
			session.setAttribute("sessionAttribute",
					"SOME USER PERSONAL INFORMATION");
			request.setAttribute("requestAttribute",
					"SOME REQUEST SPECIFIED INFORMATION");
			Enumeration<String> initParameterNames = config
					.getInitParameterNames();
			out.print("Инициализация параметров, полученных из неявных объектов");
			while (initParameterNames.hasMoreElements()) {
				out.print(Constants.HTML_TAG_BR);
				String paramName = initParameterNames.nextElement();
				out.print(paramName + " = ");
				out.print(config.getInitParameter(paramName));
			}
		%>
	</p>
	<p>
		<a href="implicitobjects2.jsp">Continue</a>
	</p>
</body>
</html>