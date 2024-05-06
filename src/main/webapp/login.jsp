<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	
	<header>
        <h1>Login</h1>
    </header>
    <form action="Login" method="POST">
        <label for="username">Username:</label>
        <input type="text" style="margin-bottom:10px;" placeholder="email" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" style="margin-bottom:10px;" name="password" required><br>
        
        <button type="submit">Login</button>
    </form>
    
    <h4>Not registered? <a href="signUp">sign up</a></h4>
	
</body>
</html>