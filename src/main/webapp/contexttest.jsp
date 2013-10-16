<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String pageName = "Contexts test";%>
<jsp:useBean scope="page" id="customer"
	class="main.webapp.bean.CustomerBean" />

<jsp:setProperty name="customer" property="firstName" value="Jonathan" />
<jsp:setProperty name="customer" property="lastName" value="Livingston" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Different contexts test</title>
</head>
<body>
	<table>
		<tr>
			<%@ include file="navigation.jspf"%>
		</tr>
		<tr>
			<td>Application context : ${applicationScope.customer} <br /> <br />
				Session context : ${sessionScope.customer.firstName}
				${sessionScope.customer.lastName} <br /> <br /> Request context :
				${requestScope.customer} <br /> <br /> Page context  :
				${pageScope.customer} <br />
			</td>
		</tr>
	</table>
</body>