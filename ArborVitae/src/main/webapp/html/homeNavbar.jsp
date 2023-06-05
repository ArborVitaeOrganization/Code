<%@ page language="java" pageEncoding="ISO-8859-1" import= "model.bean.ShoppingCart ,model.dao.ShoppingCartDao ,java.util.ArrayList,model.bean.Tree"%>

<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Arbor Vitae</title>
  <link rel="stylesheet" type="text/css" href="/ArborVitae/style/homepage.css">
  <style>
    .cart-button{
      border: none;
      background-color: white;
      padding: 0px !important;
    }
      
    .profile-button{
      border: none;
      background-color: white;
    }
    
   .dropbtn {
    background-color: none !important;
    color: white;
    padding: 8px;
    font-size: 10px;
    border: none;
    float: right;
    margin: -5px 0px 3px 0px;
   }
   
   .dropdown {
     position: relative;
     display: inline-block;
   }
   
   .dropdown-content {
     display: none;
     position: absolute;
     background-color: white;
     min-width: 160px;
     box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
     z-index: 1;
   }
   
   .dropdown-content a {
     color: gray;
     padding: 3.5px;
     text-decoration: none;
     display: block;
   }
   
   .dropdown-content a:hover {background-color: #ddd; border-radius: 10px}
   
   .dropdown:hover .dropdown-content {display: block; border-radius: 10px}
   
   .dropdown:hover .dropbtn {background-color: #46dd2c; border-radius: 10px}
   
  </style>
 </head>
 
 <body>
  <header>
   <div class="logo">
    <div class="navbar-item img-navbar-item">
     <img src="${pageContext.request.contextPath}/img/homepage_images/logo.png" alt="Arbor Vitae's logo" />
    </div>
    <div class="navbar-item">
     <h1 class="site-title"> Arbor Vitae</h1>
    </div>
   </div>
   
   <input type="checkbox" id="nav-toggle" class="nav-toggle">
   
   <nav>
   <div>
    <ul>
    <li><a href="${pageContext.request.contextPath}/view/homepage.jsp" class="link-elements">Home</a></li>
    <li><a href="/ArborVitae/catalogoServlet?ordinamento=<%=1%>" class="link-elements">Catalogo</a></li>
    <li><a href="${pageContext.request.contextPath}/view/homepage.jsp#project" class="link-elements">Progetto</a></li>
    <li><a href="${pageContext.request.contextPath}/view/homepage.jsp#aboutus" class="link-elements">Team</a></li>
    <li><a href="${pageContext.request.contextPath}/view/homepage.jsp#footer" class="link-elements">Contatti</a></li>
   
    
    <% if(request.getSession(false)==null || session.getAttribute("logged")==null || session.getAttribute("logged").equals("false")){%>
        <li><a href="${pageContext.request.contextPath}/view/login.jsp"><button type="button" class="login-signup-buttons">Login</button></a></li>
        <li><a href="${pageContext.request.contextPath}/view/signup.jsp"><button type="button" class="login-signup-buttons">Sign Up</button></a></li>
       <%}else{%>
        <li id="prev-count"><a href="/ArborVitae/view/cart.jsp"><button type="button" class="cart-button"><img src="${pageContext.request.contextPath}/img/homepage_images/cart.png" width="45px" height= "45px"></button></a></li>
        <% ShoppingCartDao scd=new ShoppingCartDao();
         ShoppingCart sc= scd.doRetrieveByKey((String)session.getAttribute("email"));
         if(sc!=null){
          ArrayList<Tree> list= scd.doRetrieveTrees(sc.getcodeCart());
          if(list!=null){ 
           int x=list.size();
           if(x>0){%>
            <li><p class="cart-elements-count" id="count"><%=x%></p></li>
           <%}%>
          <%}%>
       <%}%>
     <li><div class="dropdown">
          
           <button type="button" class="profile-button dropbtn">
            <img src="${pageContext.request.contextPath}/img/homepage_images/profile.png" width="35px" height="35px">
            <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/view/ordini.jsp">I miei Ordini</a>
            <a href="${pageContext.request.contextPath}/logout" >Log out</a>
        </div>
           </button>
      
         </div></li>
   <%}%>
    </ul>
    
   </div>
   </nav>
   
   <label for="nav-toggle" class="nav-toggle-label">
    <span></span>
   </label>

  </header>
 </body>
</html>