<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String pageName = "Simple form data";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple form data</title>
</head>
<body>
	<form method="post" action="formhandlerservlet">
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<%@ include file="navigation.jspf"%>
			</tr>
			<tr>
				<td>Your value:</td>
				<td><input type="text" name="enteredValue" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>