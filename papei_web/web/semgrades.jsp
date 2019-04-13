<%@ page import="courses.Courses" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Semester Grades Review</title>
</head>
<body background="papei.jpg">
<h1>Semester Grades Review  </h1> </br>
<%
    List<Double> list = (ArrayList<Double>) request.getAttribute("list");
%>
<table border="1" cellpadding="3" id="printTable">
    <tbody><tr>
        <th><b>Semester</b></th>
        <th><b>Grade</b></th>
    </tr>
        <%

    for(int i=0; i<list.size(); i++) {

%>
    <tr>
        <th><%=  i+1 %></th>
        <th><%=  list.get(i) %></th>
    </tr>
        <%
    }
%>
</body>
</html>
