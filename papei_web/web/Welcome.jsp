<%--
  Created by IntelliJ IDEA.
  User: lefos
  Date: 5/26/2018
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body background="papei.jpg">
<h1>University of Piraeus Secretaries home page  </h1> </br>
    <p><b>Welcome user ${username} </b></p>
<p><br><b>Personal details </b></br> name: ${name}, surname: ${surname}, department: ${department}</p>
</br>
    <form method="post" action="Secr">
  <br>  <p><b>Courses review   </b></p>
    <input type="submit" name="button1" value="Courses review" />
        </br>
        <br>   <p><b>Chief Professor per course review  </b></p>
    <input type="submit" name="button2" value="Chief Professor per course review" />
        </br>
        <br>   <p><b>Assign course to Professor </b></p>
        Professor ID:<input type="text" name="prof_id" /><br/>
        Course ID:<input type="text" name="course_id" /><br/>
        <input type="submit" name="button3" value="Assign course to Professor" />
        </br>
        <br>
        <br>
        <br>
        <input type="submit" name="button4" value="log out" />
</form>
</body>
</html>
