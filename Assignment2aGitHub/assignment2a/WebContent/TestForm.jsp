<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Form</title>
</head>
<body>
<form action="TestServlet" method="post">
  <label for="firstname">First name:</label>
  <input type="text" id="firstname" name="firstname"><br><br>
  <label for="lastname">Last name:</label>
  <input type="text" id="lastname" name="lastname"><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>