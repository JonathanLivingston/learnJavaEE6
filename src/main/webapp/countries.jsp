<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!String pageName = "List of countries from DB";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of countries from DB</title>
</head>
<body>
	<table>
		<tr>
			<%@ include file="navigation.jspf"%>
		</tr>
		<tr>
			<td>
				<ul>
					<c:forEach var="country" items="${requestScope.countryList}">
						<li />${country.code}<br />
						${country.name}
					</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
</body>
</html>