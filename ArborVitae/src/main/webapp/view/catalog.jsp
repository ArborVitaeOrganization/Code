
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.bean.Tree,javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Catalogo</title>
    <link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/catalog.css"/>  

  <style type="text/css"> 
     .dropbtn1 {
    background-color: #46dd2c !important;
    color: white;
    padding: 8px;
    font-size: 25px;
    border: none;
    float: right;
    margin: -50px -50px 300px 2px;
     border-radius: 20%
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
   
  
   .navbar-space {
     border: 40px solid white;
     background-color: white;
   }
   
   
  .inclusive-container{
  	 text-align: center;
  }
  
  .products-container{
     background-color: inherit;
     padding: 1.5em;
     margin: 0px 10px 35px 10px;
     width: 300px;
     height: 450px;
     vertical-align: bottom;
     display: inline-block;
   }
  .searchcontainer{
      margin: 70px;
      padding: 0;
  }
 
    .search-box{
        position:absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #46dd2c;
        height: 40px;
        border-radius: 30px;
        padding:10px;
    }

    .formsearch:hover > .search-txt{
        width: 500px;
        padding: 0 6px;
    }

    .formsearch:hover > .search-btn{
        background: #46dd2c;
        
    }

    .search-btn{
        background-color: #46dd2c;
        color: none;
        float: center;
        width: 0;
        height: 20px;
        border-radius: 90%;
        visibility: hidden;
        display: center;
        align-items: center;
    }

    .search-txt{
        border: none;
        background: none;
        outline: none;
        float: right;
        padding:0;
        color: gray;
        font-size: 30px;
        transition: 0.7s;
        list-style: 40px;
        width: 0px;
    }
   
   
   
  .products-container{
     background-color: inherit;
     padding: 1.5em;
     margin: 0px 10px 35px 10px;
     width: 300px;
     height: 450px;
     vertical-align: bottom;
     display: inline-block;
   }
   /*
  .searchcontainer{
      padding-bottom: 15%;
  }
 */
    .search-box{
        position: relative;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #46dd2c;
        height: 40%;
        width: 40%;
        border-radius: 30px;
        padding:10px;
    }
    
    .search-btn{
        background-color: #46dd2c;
        color: none;
        width: 0;
        height: 20px;
        border-radius: 90%;
        visibility: hidden;
        display: center;
        align-items: center;
    }

    .search-txt{
        border: none;
        background: none;
        outline: none;
        color: gray;
        font-size: 30px;
        list-style: 40px;

    }

  h2{
   font-size: 40px;
    color: #46dd2c;
    font-family: fantasy;
   }
 
 a:hover{
    color: #46dd2c;
  } 
 
  h2{
   font-size: 50px;
    color: #46dd2c;
    font-family: fantasy;

  }
 
  p{
     font-size:20px;
   color: black;
      text-align: center;
      margin-top: 30px;
  }
  
   .text-p{
    font-size: 25px;
    color: black;
    text-align: center;
    margin-top: 30px;
    background-color: #F5F5F5;
    border-radius: 10px;
   }
   
   	nav ul {
		display: flex;
	}

</style>
 </head>
 <body>
   <%@ include file="/html/homeNavbar.jsp" %>
   
   <div class="navbar-space">
    <h2 align="center"><br>Benvenuto
    <% if(request.getSession(false)==null || session.getAttribute("logged")==null || session.getAttribute("logged").equals("false")){%>
    <%}else{ %>
    	<%=session.getAttribute("isName") %>
    <%} %>
    ,<br> scegli il tuo albero da piantare<br></h2>
    <p align="center">
       Piantare un albero è davvero un gesto semplice, ma prima di effettuare la tua scelta ti consigliamo <a href="http://www.conalpa.it/perche-piantare-alberi-ecco-un-decalogo-dei-benefici/" target="_blank"> questo articolo</a> in cui vengono dati ben 10 motivi per i quali piantare un albero è vantaggioso per noi ed il nostro pianeta.
       </p> 
   </div>
   
 
   
   <div class="searchcontainer" style='display:inline; position:relative'>
        <div class="search-box">
            <form action="/ArborVitae/catalogoServlet" class="formsearch"> &nbsp&nbsp
            <input  class="search-txt" type="text" name="ricerca" placeholder="Ricerca albero...">
            <img src="/ArborVitae/img/homepage_images/magnifier.png" width="35" height= "35">
            <button type="submit"  class="search-btn">            
            </button>
        </form>
        </div>
    </div>
    
    <div class="dropdown" style='display:inline; position:relative; right:18%; bottom: 1.8em'>
		          
           <button type="button" class="profile-button dropbtn1">Ordina
            <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/catalogoServlet?ordinamento=1">Alfabetico</a>
            <a href="${pageContext.request.contextPath}/catalogoServlet?ordinamento=2" >Co2</a>
            <a href="${pageContext.request.contextPath}/catalogoServlet?ordinamento=3" >Prezzo</a>
        </div>
           </button>
      
         </div>



	
		
	
   
   <div class='inclusive-container'>
     <%if(session.getAttribute("tree")!=null){%>
      
      <%!int i;%>
      <%ArrayList<Tree>listTree=(ArrayList<Tree>)session.getAttribute("tree");%>
       <% for(i=0;i<listTree.size();i++){%>
       <% Tree currentTree=listTree.get(i);%>
       <div class="products-container">
        <div class="row product-list">
            <div class="col-md-4">
              <section class="panel">
                  <div class="pro-img-box">
                      <img src="${pageContext.request.contextPath}/img/trees_img/<%=currentTree.getName().toLowerCase()+"1.jpg" %>" alt="" />
                         <!-- <a href="#" class="adtocart">
                            <i class="fa fa-shopping-cart"></i>
                         </a>-->
                  </div>
   
                  <div class="panel-body text-center">
                     <h4>
                        <a href="/ArborVitae/catalogItemServlet?treeName=<%=currentTree.getName() %>" class="pro-title"> 
                          <%=currentTree.getName()%></a>
                     </h4>
                     <p class="price">
                      €<%=currentTree.getPrice()%>
                     </p>
                  </div>
           </section>
          </div>

      <!-- fine prodotto i-esimo -->
        </div>  
     </div>
      <% }%>
     <%} %>
 </div>
 
 
   <section>
    <div id="footer" >
     <%@ include file="/html/footer.html" %>
    </div>
   </section>
 </body>
</html>






