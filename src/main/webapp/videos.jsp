<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
        <h1>Videos</h1>
        <a href="#" class="logout">Logout</a>
    </header>
    <main>
        <h2>YouTube Videos</h2>
        <div class="video">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/VIDEO_ID_HERE" frameborder="0" allowfullscreen></iframe>
        </div>
        <div class="video">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/VIDEO_ID_HERE" frameborder="0" allowfullscreen></iframe>
        </div>
    </main>
	
</body>
</html>