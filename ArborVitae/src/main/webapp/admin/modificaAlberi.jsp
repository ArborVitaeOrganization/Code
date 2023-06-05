<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, model.bean.Tree,javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arbor Vitae Admin</title>
</head>
<body>
	 <%@ include file="/admin/admin.jsp"%>
	 
	 <h2>Modifica alberi</h2>
	 <br>
	 <%if(session.getAttribute("albero")!=null){ %>
	 	<%ArrayList<Tree>lista=(ArrayList<Tree>)session.getAttribute("albero"); %>
	 	<%Tree t = lista.get(0); %>
	 	<table>
	 	<tr>
	 		<th>Nome</th>
	 		<td scope="col"><%=t.getName()%></td>
	 	</tr>
		<tr>
			<th>Specie</th>
			<td scope="col"><%=t.getSpecies()%></td>
		</tr>
		<tr>
			<th>Country</th>
			<td scope="col"><%=t.getCountry()%></td>
		</tr>
		<tr>
			<th>CO2</th>
			<td scope="col"><%=t.getCo2()%></td>
		</tr>
		<tr>
			<th>Descrizione</th>
			<td scope="col"><%=t.getDescription()%></td>
		</tr>
		<tr>
			<th>Prezzo</th>
			<td scope="col"><%=t.getPrice()%></td>
		</tr>
		</table>
		<br>	
	 <form action="${pageContext.request.contextPath}/gestione?id=<%=11%>&name=<%=t.getName()%>" method="post">
		<table align="center">
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Modifica descrizione</label>
				    <input type="text" name="newDes" class="form-control">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				    <label for="exampleFormControlInput1">Modifica prezzo</label>
				    <input type="text" name="newPrice" class="form-control" placeholder="">
			  	</div>
		</td></tr>
		<tr><td width="50%">
			  	<div class="form-group">
				   <button type="submit" class="btn login_btn">Modifica</button>
			  	</div>
		</td></tr>
		
		</table>
	</form>
	 <%} %>
</body>
</html>