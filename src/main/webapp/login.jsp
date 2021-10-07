<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>H2KInfosys Teachers App</title>
</head>
<body>
<p> 
<% 
	String errorMessage = (String) session.getAttribute("errorMessage");
	if (errorMessage != null){
		out.println(errorMessage);
	}

%>
</p>
<form method="post" action="login">
		<p> User Name : <input type="text" name="userID" /> </p>
		<p> Password : <input type="password" name="password" /> </p>
		<p> <input type="submit" name="Submit" />
</form>

</body>
</html>