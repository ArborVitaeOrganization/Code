<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.ArrayList, model.bean.User,javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest"%>
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
				<th scope="col">#</th>
				<th scope="col">Email</th>
				<th scope="col">Nome</th>
				<th scope="col">Cognome</th>
				<th scope="col">Paese</th>
			</tr>
		</thead>
		<tbody>
		<%if(session.getAttribute("utente")!=null){%>
			  	<%!int i;%>
			  	<%ArrayList<User>lista=(ArrayList<User>)session.getAttribute("utente");%>
			  	 <% for(i=0;i<lista.size();i++){%>
			  		<% User curr = lista.get(i);%>
			<tr>
				<th scope="col">#<%=i+1%></th>
				<th scope="col"><%=curr.getEmail()%></th>
				<th scope="col"><%=curr.getName()%></th>
				<th scope="col"><%=curr.getSurname()%></th>
				<th scope="col"><%=curr.getCountry()%></th>
				<%if(curr.getRole().equals(User.userRole.Admin)){%>
				<th scope="col"><a href="/ArborVitae/gestione?id=<%=7%>&em=<%=curr.getEmail()%>"><button type="button">Rimuovi</button></a>
				</th>
				<%}else{%>
					<th scope="col"><a href="/ArborVitae/gestione?id=<%=8%>&em=<%=curr.getEmail()%>"><button type="button">Rimuovi</button></a>
				</th>
			</tr>
		</tbody>
		<% }}%>
		<%}%>
	</table>
	  
</body>
</html>