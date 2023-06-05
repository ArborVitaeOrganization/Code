<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.ArrayList, model.bean.Tree,javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arbor Vitae Admin</title>
</head>
<body>
	  <%@ include file="/admin/admin.jsp"%>
	  
	  <table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Codici</th>
				<th scope="col">Nome</th>
				<th scope="col">Specie</th>
				<th scope="col">Paese</th>
				<th scope="col">CO2</th>
				<th scope="col">Descrizione</th>
				<th scope="col">Prezzo</th>
			</tr>
		</thead>
		<tbody>
		<%if(session.getAttribute("alberi")!=null && session.getAttribute("codice")!=null){%>
			  	<%!int i;%>
			  	<%ArrayList<Tree>lista=(ArrayList<Tree>)session.getAttribute("alberi");%>
			  	<%ArrayList<Integer>codici=(ArrayList<Integer>)session.getAttribute("codice");%>
			  	 <% for(i=0;i<lista.size();i++){%>
			  		<% Tree curr = lista.get(i);%>
			  		<% int j = codici.get(i); %>
			<tr>
				<th scope="col"><%=j%></th>
				<th scope="col"><%=curr.getName()%></th>
				<th scope="col"><%=curr.getSpecies()%></th>
				<th scope="col"><%=curr.getCountry()%></th>
				<th scope="col"><%=curr.getCo2()%></th>
				<th scope="col"><%=curr.getDescription()%></th>
				<th scope="col"><%=curr.getPrice()%></th>
				<th scope="col"><a href="/ArborVitae/gestione?id=<%=9%>&code1=<%=curr.getName()%>"><button type="button">Modifica</button></a></th>
				<th scope="col"><a href="/ArborVitae/gestione?id=<%=10%>&code=<%=curr.getName()%>"><button type="button">Elimina</button></a></th>
			</tr>
		</tbody>
		<% }%>
		<%} %>
	</table>
	  
</body>
</html>