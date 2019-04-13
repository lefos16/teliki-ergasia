<%@ page import="courses.Courses" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grades Review</title>
</head>
<body background="papei.jpg">
<h1>Grades Review  </h1> </br>
<%
    List<String> list = (ArrayList<String>) request.getAttribute("list");
%>
<table border="1" cellpadding="3" id="printTable">
    <tbody><tr>
        <th><b>Course Name</b></th>
        <th><b>Grade</b></th>
    </tr>
        <%

    for(int i=0; i<list.size(); i+=2) {

%>
    <tr>
        <th><%=  list.get(i) %></th>
        <th><%=  list.get(i+1) %></th>
    </tr>
        <%
    }
%>
</body>
</html>
