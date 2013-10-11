<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String pageName = "Page with checkboxes";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page with checkboxes</title>
</head>
<body>
	<form method="post" action="multiplevaluefieldhandlerservlet">
		<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<%@ include file="navigation.jspf"%>
			</tr>
			<tr>
				<td><input type="checkbox" name="options" value="Option 1" />Option
					1</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="options" value="Option 2" />Option
					2</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="options" value="Option 3" />Option
					3</td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>