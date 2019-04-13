<%@ page import="courses.Courses" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses Review</title>
</head>
<body background="papei.jpg">
<h1>University of Piraeus Courses list  </h1> </br>
<%
        List<Courses> list = (ArrayList<Courses>) request.getAttribute("list");
        %>
<table border="1" cellpadding="3" id="printTable">
    <tbody><tr>
        <th><b>Course Name</b></th>
        <th><b>Department</b></th>
        <th><b>Semester</b></th>
    </tr>
<%
    for(Courses course : list) {
%>
    <tr>
        <th><%= course.getName() %></th>
        <th><%= course.getDepartment() %></th>
        <th><%= course.getSemester() %></th>
    </tr>
<%
    }
%>
    </tbody></table>
</body>
</html>
