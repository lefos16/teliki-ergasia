<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lefos
  Date: 5/27/2018
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses-Professors</title>
</head>
<body background="papei.jpg">
<h1>University of Piraeus professor course list  </h1> </br>
<%
    List<String> list = (ArrayList<String>) request.getAttribute("list1");

%>
<table border="1" cellpadding="3" id="printTable">
    <tbody><tr>
        <th><b>Course Name</b></th>
        <th><b>Department</b></th>
        <th><b>Professor Name</b></th>
        <th><b>Professor Surname</b></th>
    </tr>
        <%
        
    for(int i=0; i<list.size(); i+=4) {

%>
    <tr>
        <th><%=  list.get(i) %></th>
        <th><%=  list.get(i+1) %></th>
        <th><%= list.get(i+2) %></th>
        <th><%= list.get(i+3) %></th>
    </tr>
        <%
    }
%>
</body>
</html>
