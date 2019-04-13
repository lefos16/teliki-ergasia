
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body background="papei.jpg">
<h1>University of Piraeus Students home page  </h1> </br>
<p><b>Welcome user ${username}  ${registrationNumber}</b></p>
<p><br><b>Personal details </b></br> name: ${name}, surname: ${surname}, department: ${department}</p>
</br>
<form method="post" action="Std">

    <br>  <p><b>Grades Per Course  </b></p>
    <input type="submit" name="button1" value="Grades Per Course" />
    </br>
    <br>   <p><b>Grades Per Semester  </b></p>
    <input type="submit" name="button2" value="Grades Per Semester " />
    </br>
    <br>   <p><b>Average Grade</b></p>
    <input type="submit" name="button3" value="Average Grade" />
    </br>
    <br>
    <br>
    <br>
    <input type="submit" name="button4" value="log out" />
</form>
</body>
</html>
