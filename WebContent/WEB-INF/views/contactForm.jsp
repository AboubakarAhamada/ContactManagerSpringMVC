<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit Contact</title>
</head>
<body>
<div align="center">
<h2>Add/Edit contact</h2>
<form:form action="save" method="post" modelAttribute="contact">
	<table cellpadding="5">
	<form:hidden path="id"/> <!-- What is this ? -->
	<tr>
	<td>Name:</td>
	<td><form:input path="name"/> </td>
	</tr>
	<tr>
	<td>Email:</td>
	<td><form:input path="email"/> </td>
	</tr>
	<tr>
	<td>Adress:</td>
	<td><form:input path="adress"/> </td>
	</tr>
	<tr>
	<td>Phone:</td>
	<td><form:input path="phone"/> </td>
	</tr>
	</table>
	<form:button>Save contact</form:button>
</form:form>
</div>
</body>
</html>