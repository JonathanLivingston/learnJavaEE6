<%@ tag language="java"%>
<%@ attribute name="addressType" required="true"%>
<jsp:useBean id="address" scope="request" class="main.webapp.bean.AddressBean" />
<table>
	<tr>
		<td align="right"><b>Country</b>&nbsp;</td>
		<td><select name="${addressType}_country">
				<option value=""></option>
				<option value="RUS">Russia</option>
				<option value="ENG">England</option>
				<option value="USA">USA</option>
				<option value="CZH">Chezh Republic</option>
				<option value="GER">Germany</option>
		</select></td>
	</tr>
	<tr>
		<td align="right"><b>City</b>&nbsp;</td>
		<td><input type="text" name="${addressType}_city" size="30"
			maxlength="100" value="${address.city}"></td>
	</tr>
	<tr>
		<td align="right"><b>Street</b>&nbsp;</td>
		<td><input type="text" name="${addressType}_street" size="30"
			maxlength="100" value="${address.street}"></td>
	</tr>
	<tr>
		<td align="right"><b>Postal code</b>&nbsp;</td>
		<td><input type="text" name="${addressType}_postalcode" size="30"
			maxlength="100" value="${address.postalcode}"></td>
	</tr>
</table>