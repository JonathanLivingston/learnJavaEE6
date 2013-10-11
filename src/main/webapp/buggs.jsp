<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%!String pageName = "Page containing error";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page containing error</title>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="0">
		<tr>
			<%@ include file="navigation.jspf"%>
		</tr>
		<tr>
			<%
				Object nullObject = null;
				out.println(nullObject.toString());
			%>
		</tr>
	</table>
</body>
</html>
