<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>University of Piraeus</title>
</head>
<body background="papei.jpg">
<h1>University of Piraeus log in page</h1>
<form method="post" action="log">
  <input type="radio" name="usertype" value="Student" checked> Student<br>
  <input type="radio" name="usertype" value="Professors" > Professors<br>
  <input type="radio" name="usertype" value="Secretaries" > Secretaries<br>
  Username:<input type="text" name="username" /><br/>
  Password:<input type="password" name="password" /><br/>
  <input type="submit" value="login" />
</form>
</body>
</html>