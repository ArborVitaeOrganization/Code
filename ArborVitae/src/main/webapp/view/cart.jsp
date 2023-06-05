<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.dao.ShoppingCartDao, java.util.ArrayList,model.bean.Tree,model.bean.ShoppingCart"%>
<!DOCTYPE html>
 <html>
 <head>
  <meta charset="ISO-8859-1">
  <title>Arbor Vitae</title>
  <link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/cart.css">
 </head>
 
 <style>
  .cart-elements-count{
   top: 12px;
      right: 10px !important;
  }
 </style>
 <body>
 <script>
  function add(x){
        var quantityDiv=document.getElementById(x);
        quantityDiv.innerHtml=(parseInt(quantityDiv.innerHtml)+1).toString();
  }
 
</script>
 <%@ include file="/html/homeNavbar.jsp" %>
  <div class="cart_section">
     <div class="container-fluid" id="container-fluid">
         <div class="row">
             <div class="col-lg-10 offset-lg-1">
                 <div class="cart_container">
                     <div class="cart_title">Carrello</div>
                     <div class="cart_items" id="cart_items">
                         <ul class="cart_list" id="cart_list">
                           <% ShoppingCartDao scd= new ShoppingCartDao();
                              ShoppingCart sc=scd.doRetrieveByKey((String)session.getAttribute("email"));
                           if(sc!=null) {%>
                           
                           <%ArrayList<Tree> list= scd.doRetrieveTrees(sc.getcodeCart());
                            if(list.size()>0){
                             int i=0;
                             int j;
                             double sum=0;
                             for(i=0;i<list.size();i++){
                            	int count=1;  
                            	Tree currentTree=list.get(i);
                              	for(j=i+1;j<list.size();j++){
                              		if(list.get(i).getName().equals(list.get(j).getName())){
                                		list.remove(j);
                                		j--;
                                 		count++;
                              		}
                              }%>
                             	<div>
                             	 <li class="cart_item clearfix">
                                 <div class="cart_item_image"><img src="/ArborVitae/img/trees_img/<%=currentTree.getName().toLowerCase()+"1.jpg"%>" alt=""></img></div>
                                   <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                       <div class="cart_item_name cart_info_col">
                                            <div class="cart_item_title">Nome</div>
                                             <div class="cart_item_text"><%=currentTree.getName()%></div>
                                       </div>
                                       <div class="cart_item_quantity cart_info_col">
                                           <div class="cart_item_title">Quantita'</div>
                                           <div class="cart_item_text" id="<%=i %>">
                                           		<p class=item_Quant><%=count %></p>
                                           		<button class="inc_Dec" onclick="increase(this)">+</button>
                                          	 	<button class="inc_Dec" onclick="decrease(this)">-</button>
                                       	   </div>
                                       </div>
                                       <div class="cart_item_price cart_info_col">
                                           <div class="cart_item_title">Prezzo</div>
                                           <div class="cart_item_text">
                                           <p class="item_Quant3"><%= String.format("%.2f", currentTree.getPrice()).replace(',', '.') %></p>
                                           <p class="item_Quant4"> &euro;</p>
                                           <p class="to_be_hidden"><%= String.format("%.2f", currentTree.getPrice()).replace(',', '.') %></p>
                                      </div>
                                      </div>
                                   </div>
                               </li>
                               <%if(i+1!=list.size()){%>
                            		   <div id="hor_line"><hr></div>
                               <%}%>
                             <% sum=sum+(count*list.get(i).getPrice());%>
                           	</div>
                           <%}%>
                         </ul>
                     </div>
                     <div id="totalContainer">
                     	<div class="order_total">
                         <div class="order_total_content text-md-right">
                             <div class="order_total_title">Totale:</div>

					<div class="order_total_amount" id="order_total_amount">
						<p class="item_Quant3"><%= String.format("%.2f",sum).replace(',', '.') %></p>
						<p class="item_Quant4"> &euro;</p>
					</div>
                         </div>
                     </div>
                     <div class="cart_buttons"> <button type="button" onclick="redirect()" class="button cart_button_clear">Continue Shopping</button> <button type="button" class="button cart_button_checkout" onclick="addToOrders()">Proceed to Checkout</button> </div>
                	</div>	
                	<script>
                		function redirect(){
                			window.location.replace("http://localhost:8080/ArborVitae/catalogoServlet?ordinamento=1");
                	 	}	
                		
                		function increase(x){
                			let y = x.parentElement.firstElementChild;
                			let calc=parseInt(y.innerHTML);
                			calc=calc+1;
                			y.innerHTML=""+calc;
                			let priceDiv = x.parentElement.parentElement.nextElementSibling.firstElementChild.nextElementSibling.firstElementChild;
                			let pr=parseFloat(priceDiv.nextElementSibling.nextElementSibling.innerHTML.replace(',','.'));
                			let priceConst=priceDiv.nextElementSibling.nextElementSibling;
                			if(calc==1){
                				let z = document.getElementById("order_total_amount");
                				let m=parseFloat(z.firstElementChild.innerHTML).toFixed(2);
                				pr=pr.toFixed(2);
                				m=Number(m)+Number(parseFloat(priceConst.innerHTML).toFixed(2));
                				z.innerHTML= ""+m.toFixed(2);
                				let xhrObj=new XMLHttpRequest();
                				let TreeName=x.parentElement.parentElement.previousElementSibling.firstElementChild.nextElementSibling;
                				xhrObj.open("GET","/ArborVitae/shoppingCartServlet?treeName="+TreeName.innerHTML,true);
                				xhrObj.send();
                				return;
                			}
                			pr = parseFloat(priceDiv.innerHTML.replace(',','.'));
                			pr= pr.toFixed(2);
                			let z = document.getElementById("order_total_amount");
                			let m = parseFloat(z.firstElementChild.innerHTML).toFixed(2);
                			m=Number(m) + Number(parseFloat(priceConst.innerHTML).toFixed(2));
                			m=m.toFixed(2);
            				z.firstElementChild.innerHTML= ""+m;
                			let xhrObj=new XMLHttpRequest();
                			let TreeName=x.parentElement.parentElement.previousElementSibling.firstElementChild.nextElementSibling;
                			xhrObj.open("GET","/ArborVitae/shoppingCartServlet?treeName="+encodeURIComponent(TreeName.innerHTML),true);
                			xhrObj.send();
                			let g = document.querySelector("#count");
                 		    let listCount=g.parentElement;
       		   		   	    g.innerHTML=""+(parseInt(g.innerHTML)+1);
                 		    	
                		}
                		
                		function decrease(x){
                			let y = x.parentElement.firstElementChild;
                			let calc=parseInt(y.innerHTML);
                			if(calc==0) return;
                			calc=calc-1;
                			y.innerHTML=""+calc;
                			let priceDiv=x.parentElement.parentElement.nextElementSibling.firstElementChild.nextElementSibling.firstElementChild;
                			let pr=parseFloat(priceDiv.innerHTML);
                			let priceConst=priceDiv.nextElementSibling.nextElementSibling;
                			pr=pr.toFixed(2);
                			let z = document.getElementById("order_total_amount");
                			let m=parseFloat(z.firstElementChild.innerHTML).toFixed(2);
                			m=m-parseFloat(priceConst.innerHTML).toFixed(2);
                			m=m.toFixed(2);
                			z.firstElementChild.innerHTML= ""+m;
                			let xhrObj=new XMLHttpRequest();
                			let TreeName=x.parentElement.parentElement.previousElementSibling.firstElementChild.nextElementSibling;
                			xhrObj.open("GET","/ArborVitae/shoppingCartServlet?tRemove="+encodeURIComponent(TreeName.innerHTML),true);
                			xhrObj.send();
                			if(calc==0){
                				let listElement = x.parentElement.parentElement.parentElement.parentElement.parentElement;
            					while((listElement.firstElementChild)!=null){
            						listElement.removeChild(listElement.firstElementChild);
            					}
 								let ul=listElement.parentElement;
            					listElement.parentElement.removeChild(listElement);
            					let firstDivChild=ul.firstElementChild;
            					if(firstDivChild==(ul.lastElementChild)){
            						let elem=document.getElementById("hor_line");
            						if(elem!=null){
            							elem.parentElement.removeChild(elem);
            						}
            					}
            						
            					
                			}
                			let g = document.querySelector("#count");
                 		    let listCount=y.parentElement;
                 		 	if((g.innerHTML)=='1'){
                				let totalDiv=document.getElementById("totalContainer");
                				while((totalDiv.firstElementChild)!=null){
                    				totalDiv.removeChild(totalDiv.firstElementChild);
                    			}
                    			totalDiv.parentElement.removeChild(totalDiv);
                 		   		g.parentElement.removeChild(g);
                 		    	listCount.parentElement.removeChild(listCount);  
                 		     	let f_textEl=document.createElement("p");
                 		     	f_textEl.setAttribute("id","f-text");
                 		     	f_textEl.classList.add("f-text");
                 		     	f_textEl.innerHTML="Non hai inserito alcun elemento nel tuo carrello";
                 		     	let contFl=document.getElementById("cart_list");
                 		     	contFl.insertBefore(f_textEl,null);	
                 		    	return;
                 		     }else{
                 		      	g.innerHTML=""+(parseInt(g.innerHTML)-1);
                 		     }	
                 		     
                		}
                		
                		
                		function addToOrders(){
                			let ernesto = new XMLHttpRequest();
                			ernesto.onreadystatechange= function(){
                				if(this.readyState==4 && this.status==200){
                					let totalDiv=document.getElementById("cart_list");
                    				while((totalDiv.firstElementChild)!=null){
                        				totalDiv.removeChild(totalDiv.firstElementChild);
                        			} 
                     		     	let f_textEl=document.createElement("p");
                     		     	f_textEl.setAttribute("id","f-text");
                     		     	f_textEl.classList.add("f-text");
                     		     	f_textEl.innerHTML="Non hai inserito alcun elemento nel tuo carrello";
                     		     	totalDiv.insertBefore(f_textEl,null);	
                					let totCont=document.getElementById("totalContainer");
                					while((totCont.firstElementChild)!=null){
                        				totCont.removeChild(totCont.firstElementChild);
                        			} 
                					
                					totCont.parentElement.removeChild(totCont);
                					let g = document.querySelector("#count");
                					g.parentElement.removeChild(g);
                					
                				}
                			}
                			ernesto.open("GET","/ArborVitae/insertOrderServlet",true);
                			ernesto.send();
                		}
                	</script>	
                		
                 </div>
             </div>
         </div>
         <%}else{ %>
         <p class="f-text" id="f-text">Non hai inserito alcun elemento nel tuo carrello</p>
         <%}}%>
     </div>
 </div>
 </body>
</html>