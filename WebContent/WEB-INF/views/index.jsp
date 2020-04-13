<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- In order to use JSTL in this page, we must include this below: -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Manager</title>
</head>
<body>
	<h1 align="center">Contact Manager Application</h1>
	<div align="left">
	<h3><a href="new">Add new contact</a></h3>
	<table border="1" cellpandding="5">	
	<tr>
	<th>No</th>
	<th>Name</th>
	<th>Email</th>
	<th>Adress</th>
	<th>Phone</th>
	<th>Action</th>
	</tr>
	
	<c:forEach items="${listContact}" var="contact" varStatus="status">
	<tr>
	<td>${status.index +1 }</td>
	<td>${contact.name}</td>
	<td>${contact.email }</td>
	<td>${contact.adress }</td>
	<td>${contact.phone }</td>
	<td><a href="edit?id=${contact.id}">Edit</a> &nbsp;&nbsp; <a href="delete?id=${contact.id}"> Delete</a></td>
	</tr>
	</c:forEach>
	
	</table>
	</div>
</body>
</html>