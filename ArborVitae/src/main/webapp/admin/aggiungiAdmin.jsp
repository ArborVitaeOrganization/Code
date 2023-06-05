<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arbor Vitae Admin</title>
</head>
<body>
	<%@ include file="/admin/admin.jsp"%>
	<h2>Aggiungi Nuovo Admin</h2>
	<form action="${pageContext.request.contextPath}/gestione?id=<%=5%>" method="post">
	<table align="center">
	<tr><td width="50%">
		  	<div class="form-group">
			    <label for="exampleFormControlInput1">Email</label>
			    <input type="text" name="newEmail" class="form-control" placeholder="name@example.com">
		  	</div>
	</td></tr>
	<tr><td width="50%">
		  	<div class="form-group">
			    <label for="exampleFormControlInput1">Nome</label>
			    <input type="text" name="newName" class="form-control" placeholder="Carlo">
		  	</div>
	</td></tr>
	<tr><td width="50%">
		  	<div class="form-group">
			    <label for="exampleFormControlInput1">Cognome</label>
			    <input type="text" name="newSurname" class="form-control" placeholder="Sorrentino">
		  	</div>
	</td></tr>
	<tr><td width="50%">
		  	<div class="form-group">
			    <label for="exampleFormControlInput1">Paese</label>
			    <input type="text" name="newCountry" class="form-control" placeholder="Italia">
		  	</div>
	</td></tr>
	<tr><td width="50%">
		  	<div class="form-group">
			    <label for="exampleFormControlInput1">Password</label>
			    <input type="text" name="newPass" class="form-control" placeholder="Abc234">
		  	</div>
	</td></tr>
	<tr><td width="50%">
		  	<div class="form-group">
			   <button type="submit" class="btn login_btn">Aggiungi</button>
		  	</div>
	</td></tr>
	
	</table>
	</form>
	
</body>
</html>