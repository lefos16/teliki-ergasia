<%@ page import="courses.Courses" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body background="papei.jpg">
<h1>University of Piraeus Professors home page  </h1> </br>
<p><b>Welcome user ${username} </b></p>
<p><br><b>Personal details </b></br> name: ${name}, surname: ${surname}, department: ${department}</p>
</br>
<%
    List<Courses> list = (ArrayList<Courses>) request.getAttribute("list");
%>

<form method="post" action="Prof">
    <br>  <p><b>View Grades   </b></p>
    </br>
    <select name="course">
        <% for(Courses course : list) { %>
        <option value="<%=course.getCourse_id()%>"><%= course.getName() %></option>
        <% } %>
    </select>
    <input type="submit" name="button1" value="View Grades"/><br/>
    <br>  <p><b>Add Grades   </b></p>
    </br>
    <select name="course1">
        <% for(Courses course : list) { %>
        <option value="<%=course.getCourse_id()%>"><%= course.getName() %></option>
        <% } %>
    </select><br/>
    Student ID:<input type="text" name="regNum" /><br/>
    Grade:<input type="text" name="grade" /><br/>
    <input type="submit" name="button2" value="Add Grade"/>
    <br>
    <br>
    <br>
    <input type="submit" name="button3" value="log out" />
</form>
</body>
</html>
