<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String pageName = "JSTL core tags";%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<html>
<%
	ArrayList<String> nameList = new ArrayList<String>(4);

	nameList.add("Johnny");
	nameList.add("Katherine");
	nameList.add("Don");
	nameList.add("Alice");

	request.setAttribute("nameList", nameList);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL core tags</title>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="0">
		<tr>
			<%@ include file="navigation.jspf"%>
		</tr>
		<tr>
			<td><c:set var="name" scope="page" value="${param.name}"></c:set>
				<c:out value="Hello"></c:out> <c:choose>
					<c:when test="${!empty name}">
						<c:out value="${name}"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="unknown"></c:out>
						<br />
						<c:out value="Have you any name? There are several variants:" />
						<br />
						<ul>
							<c:forEach var="nameOption" items="${requestScope.nameList}">
								<li />
								<c:out value="${nameOption}"></c:out>
							</c:forEach>
						</ul>
					</c:otherwise>
				</c:choose> <c:remove var="name" scope="page" /></td>
		</tr>
</body>
</html>
