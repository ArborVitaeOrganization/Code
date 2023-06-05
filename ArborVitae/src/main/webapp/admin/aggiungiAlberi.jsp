<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arbor Vitae Admin</title>
</head>
<body>
	  <%@ include file="/admin/admin.jsp"%>
	  <h2>Aggiungi nuovo albero</h2>
	  
	  <form action="${pageContext.request.contextPath}/gestione?id=<%=6%>" method="post">
		<table align="center">
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Nome</label>
				    <input type="text" name="newName" class="form-control" placeholder="Melo">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Specie</label>
				    <input type="text" name="newSpecie" class="form-control" placeholder="Malus">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Paese</label>
				    <input type="text" name="newCountry" class="form-control" placeholder="Kazakhstan">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">CO2</label>
				    <input type="text" name="newco2" class="form-control" placeholder="-20Kg">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Descrizione</label>
				    <input type="text" name="newDes" class="form-control">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Prezzo</label>
				    <input type="text" name="newPrice" class="form-control" placeholder="20.10">
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