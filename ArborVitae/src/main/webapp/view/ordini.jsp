<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.dao.OrdersDao, model.dao.ProductsDao, java.util.ArrayList, model.bean.Orders, model.bean.Products"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Arbor Vitae</title>
		<link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/ordini.css">
		<style>
		
		  /* <!--.separator{
		     border: 40px solid #F5F5F5;
		     background-color: #F5F5F5;
		   }*/
		p.info{
			display: inline; !important
		}
		
		   .cart-elements-count{
		   	bottom: 0px !important;
		   	top: 12px;
		   }
		</style>
	</head>
	<body>
		<%@ include file="/html/homeNavbar.jsp" %>
		
			<!-- <div class="separator"><br></div>-->
		
		<section class="h-100 gradient-custom">
	  <div class="container py-5 h-100">
	  <br><br><br><br>
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-lg-8 col-xl-10">
	        <div class="card" style="border-radius: 10px;"></div>
	          <div class="card-header px-4 py-5">
	            <h5 class="text-muted mb-0">I miei ordini</h5>
	          </div>
	      	<script>
			function redCert(x){
				window.location.replace("http://localhost:8080/ArborVitae/view/attestati.jsp?treeName="+encodeURIComponent(x));
			}
	              									
	              									
	        </script>
	        
	            <%String email= (String)session.getAttribute("email");
	              OrdersDao oD= new OrdersDao();
	              ArrayList<Orders> orderList = oD.doRetrieveByKey(email);
	              if(orderList.size()==0){%>
	              	<div class="card-body p-4">
	            		<div class="d-flex justify-content-between align-items-center mb-4">
	            	   		<p class="lead fw-normal mb-0" style="color: #46dd2c;">Non hai effettuato alcun ordine fino ad ora</p>	
	            		</div>
	            	</div>
	              <%}else{
	              	int i=0;
	              	int j=0;
	              	ProductsDao pD = new ProductsDao();
	              	for(i=0;i<orderList.size();i++){
	              		Orders currOrder = orderList.get(i);
	              		ArrayList<Products> currProdList = pD.doRetrieveByKey(orderList.get(i).getCodeOrder());%>
	              		<div class="card-body p-4">
            				<div class="d-flex justify-content-between align-items-center mb-4">
      						<p class="lead fw-normal mb-0" style="color: #46dd2c;">Data: <%= currOrder.getDate().toString() %></p>
    					</div>
	              		<%for(j=0;j<currProdList.size();j++){
	              			Products currProd= currProdList.get(j);%>
	            					<div class="card shadow border mb-4">
	              						<div class="card-body">
	              							<div>
	              								<button id="certButton" onclick= "redCert('<%=currProd.getName()%>')">Ottieni Certificato</button>
	              								
	              		
	              									
	              							</div>
	               							<div class="row">
	                  							<div class="col-md-2 img-wid">
	                    							<img src="${pageContext.request.contextPath}/img/trees_img/<%=currProd.getName().toLowerCase()%>1.jpg" class="img-fluid" alt="name tree">
	                  							</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="info">Nome</p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="info">Paese</p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="info">Co2</p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="info">Quantit&agrave;</p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="info">Prezzo Totale</p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="infoDesc"></p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="infoDesc"><%=currProd.getName()%></p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="infoDesc"><%=currProd.getCountry()%></p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="infoDesc"><%=currProd.getCo2()%></p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="infoDesc"><%=currProd.getQuantity()%></p>
	                  						</div>
	                  						<div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    						<p class="infoDesc"><%=String.format("%.2f", currProd.getPrice()*currProd.getQuantity()).replace(',', '.')%> &euro;</p>
	                  						</div>
	                					</div>
	              					</div>
		        				</div>
	              		<%}%>
	        	      	
       					<hr class="mb-4" style="background-color: #46dd2c ; opacity: 1;">
     					</div>
     					<%}	
	         		}%>
	           	
	              <!--<p class="lead fw-normal mb-0" style="color: #46dd2c;">Ricevute</p>
	            </div>
	            <div class="card shadow border mb-4">
	              <div class="card-body">
	                <div class="row">
	                  <div class="col-md-2 img-wid">
	                    <img src="${pageContext.request.contextPath}/img/trees_img/anacardo1.png"
	                      class="img-fluid" alt="name tree">
	                  </div>
	                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    <p class="info">Paese</p>
	                  </div>
	                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    <p class="info">co2</p>
	                  </div>
	                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    <p class="info">1</p>
	                  </div>
	                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    <p class="info">prezzo</p>
	                  </div>
	                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
	                    <p class="info">Nome</p>
	                  </div>
	                </div>
	              </div>
		        </div>
		        
		          
	            <hr class="mb-4" style="background-color: #46dd2c ; opacity: 1;">
		
		      </div>
		    </div>
		    </div>
		    </div>
		  </div>-->
		</section>
		
		
   <div id="footer" >
    <%@ include file="../html/footer.html" %>
   </div>
		
	</body>
</html>