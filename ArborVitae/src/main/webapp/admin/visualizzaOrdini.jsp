<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, java.sql.SQLException, model.bean.Orders, model.bean.Products, javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="ISO-8859-1">
  <title>Arbor Vitae Admin</title>
  </head>
  <body>
    <%@ include file="/admin/admin.jsp"%>
    
    
    <form action="${pageContext.request.contextPath}/gestione?id=<%=12%>" method="post">
       <table align="center">
         <tr>
           <td><div class="form-group">
              <label for="exampleFormControlInput1">Ricerca per utente</label>
               <input type="text" name="email" class="form-control">
              </div>
           </td>
           <td><div class="form-group">
              <label for="exampleFormControlInput1">Data inizio</label>
               <input type="text" name="data1" class="form-control">
              </div>
           </td>
           <td><div class="form-group">
              <label for="exampleFormControlInput1">Data fine</label>
               <input type="text" name="data2" class="form-control">
              </div>
           </td>
           <td width="50%">
          <div class="form-group">
           <button type="submit" class="btn login_btn">Filtra</button>
          </div>
    </td>
         </tr>
       </table>
    
    <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">Codice</th>
        <th scope="col">Email</th>
        <th scope="col">Data</th>
        <th scope="col">Albero</th>
        <th scope="col">Paese</th>
        <th scope="col">CO2</th>
        <th scope="col">Quantità</th>
        <th scope="col">Prezzo</th>
      </tr>
    </thead>
    <tbody>
    <%if(session.getAttribute("ordini")!=null&& session.getAttribute("prodotti")!=null){%>
          <%!int i;%>
          <%ArrayList<Products>lista=(ArrayList<Products>)session.getAttribute("prodotti");%>
          <%ArrayList<Orders> ol = (ArrayList<Orders>)session.getAttribute("ordini");%>
           <% for(i=0;i<lista.size();i++){%>
            <% Products prod = lista.get(i);%>
      <tr>
      <%!int j;%>
        <%for(j=0; j<ol.size(); j++){ %>
        	<%if(ol.get(j).getCodeOrder()==prod.getCodeOrder()){%>
		        <th scope="col"><%=prod.getCodeOrder()%></th>
		        <th scope="col"><%=ol.get(i).getEmail()%></th>
		        <th scope="col"><%=ol.get(j).getDate()%></th>
		        <th scope="col"><%=prod.getName()%></th>
		        <th scope="col"><%=prod.getCountry()%></th>
		        <th scope="col"><%=prod.getCo2()%></th>
		        <th scope="col"><%=prod.getQuantity()%></th>
		        <th scope="col"><%=prod.getPrice()%></th>
		      </tr>
		    </tbody>
    <% }%>
    <% }%>
    <%}%>
    <%} %>
  </body>
</html>