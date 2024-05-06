<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up page</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	
	 <header>
        <h1>Sign Up</h1>
     </header>
     
     <form action="SignUp" method="post">
        
        <label for="uname">Name:</label>
        <input type="text" style="margin-bottom:10px;"  name="uname" required><br>
        
        <label for="unumber">Number:</label>
        <input type="text" style="margin-bottom:10px;"  name="unumber" required><br>
        
        <label for="uemail">Email:</label>
        <input type="email" style="margin-bottom:10px;"  name="uemail" required><br>
        
        <label for="upassword">Password:</label>
        <input type="password" style="margin-bottom:10px;" name="upassword" required><br>
        
        <button type="submit">Sign Up</button>
        
     </form>
	
	
	
</body>
</html>