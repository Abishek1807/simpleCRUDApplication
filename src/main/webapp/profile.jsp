<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
		
		if (session.getAttribute("sessionName") == null){
			response.sendRedirect("index.jsp");
		}
	%>
	
	<form action="EditUserDetails" method="post">
		<h2>Your Details</h2>
		<h4>Except for email you can edit all other details</h4>
        <label for="name">Name:</label><br>
        <input type="text" name="name" value=${sessionUname}><br><br>
        
        <label for="email">Email:</label><br>
        <input type="email" name="email" value=${sessionName} readonly><br><br>
        
        <label for="number">Number:</label><br>
        <input type="text" name="number" value=${sessionNumber}><br><br>
        
        <label for="password">Password:</label><br>
        <input type="password" name="password" value=${sessionPassword}><br><br>
        
        <input type="submit" value="Save">
    </form>
    
    <h4>Do you want to delete your account permanently?</h4>
    <form action="deleteAccount" method="post"><button>Delete</button></form>
    
    <h4>Want to logout?</h4>
    <form action="logout" method="post"><button>logout</button></form>
	
</body>
</html>