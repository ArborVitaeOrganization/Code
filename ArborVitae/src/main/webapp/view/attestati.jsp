<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Arbor Vitae</title>
		    <link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
		<style>
		.image {
		   position: relative;
		}
		
		p {

		   position: absolute;
		   top: 50%;
		   right: auto;
		   width: 100%;
		   margin: 0 auto;
		   font-size: 200%;
		   font-weight: bold;
		}
		
</style>
	</head>
	<body style='background-color: rgb(185,220,184)'>
			<button style="background-color: #46dd2c" onclick=" window.location.replace('http://localhost:8080/ArborVitae/view/homepage.jsp')">Homepage</button>
			<div style='text-align:center' class="image">
		     <img src="../img/certificato.jpg" style='width: 75%;height: 75%'/> 
           		
		       <p> <%=session.getAttribute("isName")%> <%=session.getAttribute("isSurname")%> ha piantato: <%=request.getParameter("treeName")%></p>
		  
           </div>
           
	</body>
</html>