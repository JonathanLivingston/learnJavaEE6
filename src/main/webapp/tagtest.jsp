<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="jltag" uri="SimpleTagLibrary"%>
<%!String pageName = "Sample of simple custom tag using";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom tag support</title>
</head>
<body>
	<table>
		<tr>
			<%@ include file="navigation.jspf"%>
		</tr>
		<jltag:labeledTextField name="country" label="Country" value="Russia" />
		<jltag:labeledTextField name="city" label="City" />
		<jltag:labeledTextField name="street" label="Street" />
		<jltag:labeledTextField name="houseNumber" label="House number" />
		<jltag:labeledTextField name="postal code" label="Postal code" />
		<tr>
			<td></td>
			<td><input type="submit" name="Submit" /></td>
		</tr>
	</table>

</body>
</html>