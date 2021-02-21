<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Response</title>
</head>
<body>

Name from form: <%= request.getAttribute("firstname") %> <%= request.getAttribute("lastname") %>
 
</body>
</html>