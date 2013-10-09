<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Enumeration"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Implicit Java Objects at JSP pages</title>
</head>
<body>
	<p>Testing access to context variables</p>
	<p>
	<p>
		Application context attributes:
		<%=application.getAttribute("applicationAttribute")%><br /> Session
		context attributes:
		<%=session.getAttribute("sessionAttribute")%><br /> Request context
		attributes:
		<%=request.getAttribute("requestAttribute")%><br />
	</p>
	<p>
		Application context attributes:
		<%
		Enumeration<String> applicationAttributeNames = pageContext
				.getAttributeNamesInScope(PageContext.APPLICATION_SCOPE);
		while (applicationAttributeNames.hasMoreElements()) {
			out.println(applicationAttributeNames.nextElement() + "<br/>");
		}
	%>
	</p>
	<p>
		<a href="buggs.jsp">Errors page</a>
	</p>
</body>
</html>
