<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>H2KInfosys Launch Page</title>
</head>
<body>
<p> 
<% 
	String dbname = (String) application.getAttribute("DBName");
	if (dbname != null){
		out.println(dbname);
	}

%>
</p>

</body>
</html>