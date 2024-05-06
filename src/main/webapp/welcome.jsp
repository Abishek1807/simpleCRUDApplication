<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>

	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
		
		if (session.getAttribute("sessionName") == null){
			response.sendRedirect("login.jsp");
		}
	%>
	
	<header>
        <h1>Welcome</h1>
    </header>
    <main>
        <p>Welcome to the CRUD Application. This is the welcome page.</p>
    </main>
    
    <h4>Your <a href="profile.jsp">Profile</a></h4>
    
     
	
</body>
</html>