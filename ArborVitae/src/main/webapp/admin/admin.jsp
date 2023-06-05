<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="js/jquery-ui-1.13.1.custom/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="js/jquery-ui-1.13.1.custom/jquery-ui.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/admin.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Visualizza</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item"
							href="/ArborVitae/gestione?id=<%=1%>">Admin</a>
						<a class="dropdown-item"
							href="/ArborVitae/gestione?id=<%=2%>">Utenti</a>
						<a class="dropdown-item"
							href="/ArborVitae/gestione?id=<%=3%>">Alberi</a>
						<a class="dropdown-item"
							href="/ArborVitae/gestione?id=<%=4%>">Ordini</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Aggiungi</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/admin/aggiungiAdmin.jsp">Admin</a>   <!-- id=5 -->
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/admin/aggiungiAlberi.jsp">Alberi</a>
					</div></li>
					<li class="nav-item active"><a class="nav-link" href="/ArborVitae/logout">Logout</a>
       				 </li>
			</ul>
		</div>
	</nav>
</body>
</html>