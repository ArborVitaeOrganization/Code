<%@ page language="java" pageEncoding="ISO-8859-1" import= "model.bean.ShoppingCart ,model.dao.ShoppingCartDao ,java.util.ArrayList,model.bean.Tree"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/ArborVitae/style/item.css"/>
<link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
<%Tree t= (Tree) request.getAttribute("treeObject") ;%>
<title><%=t.getName()%></title>
</head>
<body>

 <%@ include file="/html/homeNavbar.jsp" %>
 
    <div class="container">
  <div class="card">
   <div class="row">
    <aside class="col-sm-5 border-right">
     <article class="gallery-wrap"> 
      <div class="img-big-wrap">
         <img src="${pageContext.request.contextPath}/img/trees_img/<%=t.getName().toLowerCase()+"1.jpg" %>" alt="" id="main_img"/>
      </div> <!-- slider-product.// -->
        <div class="img-small-wrap">
         <div class="item-gallery"> <img src="/ArborVitae/img/trees_img//<%=t.getName().toLowerCase()+"1.jpg"%>" onclick="document.getElementById('main_img').setAttribute('src','/ArborVitae/img/trees_img/<%=t.getName().toLowerCase()+"1.jpg"%>')"> </div>
         <div class="item-gallery"> <img src="/ArborVitae/img/trees_img/<%=t.getName().toLowerCase()+"2.jpg"%>" onclick="document.getElementById('main_img').setAttribute('src','/ArborVitae/img/trees_img/<%=t.getName().toLowerCase()+"2.jpg"%>')"> </div>
         </div>  
       
     </article> 
    </aside>
    <aside class="col-sm-7">
     <article class="card-body p-5">
      <h3 class="title mb-3"><%=t.getName() %></h3>
       <p class="price-detail-wrap"> 
        <span class="price h3 text-warning"> 
         <span class="currency">&euro;</span>
         <span class="num"><%=t.getPrice() %></span>
        </span> 
        <span></span> 
       </p>
     
      <dl class="param param-feature">
         <dt>Specie</dt>
         <dd><%=t.getSpecies() %></dd>
      </dl>  <!-- item-property-hor .// -->
      <dl class="param param-feature">
         <dt>Paese</dt>
         <dd><%=t.getCountry() %></dd>
      </dl>  <!-- item-property-hor .// -->

      <div class="intern-row"> 
       <div class="col-sm-5">
        <dl class="param param-inline">
           <dt>Co2: </dt>
            <dd>
              <%=t.getCo2() %>
            </dd>
           </dl>  <!-- item-property .// -->
           <hr>
       <dl class="item-property">
         <dt class="mttlsam">Descrizione</dt>
          <dd><p class="mttfam"><%=t.getDescription() %>
         </p>
        </dd>
      </dl>
       </div>
      <!-- <div class="col-sm-7">
       <dl class="param param-inline">
          <dt>Size: </dt>
           <dd>
            <label class="form-check form-check-inline">
             <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
              <span class="form-check-label">SM</span>
          </label>
           <label class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
               <span class="form-check-label">MD</span>
          </label>
       
          <label class="form-check form-check-inline">
             <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
             <span class="form-check-label">XXL</span>
          </label>
           </dd>
       </dl>  <!-- item-property .// -->
     <!--  </div> -->
     </div> <!-- row.// -->
     <hr>
      <a class="btn btn-lg btn-primary text-uppercase" onclick="buyElement()"> Buy now </a> 
      <a class="btn btn-lg btn-outline-primary text-uppercase" onclick="addElement()"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
    </article> <!-- card-body.// -->
   </aside> <!-- col.// -->
  </div> <!-- row.// -->
 </div> <!-- card.// -->
  <script>
  
   function buyElement(){
	   let ernesto = new XMLHttpRequest();
	   ernesto.onreadystatechange= function(){
		   console.log(this.readyState+"\n"+this.status);
		   if(this.readyState==4 && this.status==200){
			   window.location.replace("http://localhost:8080/ArborVitae/view/attestati.jsp?treeName="+encodeURIComponent('<%=t.getName()%>'));
		       return;
		   }
		   if(this.readyState==4 && this.status==201) {
			   window.location.replace("http://localhost:8080/ArborVitae/redirectionServlet?urlName="+window.location.pathname+""+window.location.search);
		       return;
		   }
	   }
	   ernesto.open("GET","/ArborVitae/insertOrderServlet?treeName="+encodeURIComponent('<%=t.getName()%>'),true);
	   ernesto.send();
   }  
  
   function addElement(){
    let req = new XMLHttpRequest();
    req.onreadystatechange= function(){
     console.log(req.readyState+"\n"+req.status);
     let x = document.querySelector("#count");
     if(req.readyState==4 && req.status==200){
      	if(x==null){
       		let list=document.createElement("li");
       		let para=document.createElement("p");
       		let text=document.createTextNode("1");
       		para.setAttribute("id","count");
       		para.classList.add("cart-elements-count");
      		para.insertBefore(text,para.firstChild);
      		list.insertBefore(para,list.firstChild);
      		console.log(this.responseText);
      		let insertion=document.getElementById("prev-count");
      	 	insertion.parentNode.insertBefore(list,insertion.nextSibling);
      	 	return;
      	}else{
      		 x.innerHTML=""+this.responseText;
      	     console.log(""+this.responseText);
      	}
      }else if(req.readyState==4 && req.status==201){
    	  window.location.replace("http://localhost:8080/ArborVitae/redirectionServlet?urlName="+window.location.pathname+""+window.location.search);
     	  return;
      }
    }
    req.open("GET","/ArborVitae/shoppingCartServlet?treeName="+encodeURIComponent('<%=t.getName()%>'),true);
    req.send();
   }
  </script>
 

</div> <!--container.//-->
<div class="clearb">&nbsp</div>

</body>
</html>