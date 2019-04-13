<%@ page import="courses.Courses" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="courses.Grades" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="papei.jpg">
<h1>Grades per Student </h1> </br>
<%  List<Grades> list = (ArrayList<Grades>) request.getAttribute("list"); %>
<table border="1" cellpadding="3" id="printTable">
    <tbody><tr>
        <th><b>Registration Number</b></th>
        <th><b>Grade</b></th>
    </tr>
    <%
        for(Grades grade : list) {
    %>
    <tr>
        <th><%= grade.getRegNum() %></th>
        <th><%= grade.getGrade() %></th>
    </tr>
    <%
        }
    %>
    </tbody></table>
</body>
</html>
