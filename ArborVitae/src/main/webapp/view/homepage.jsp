<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Arbor Vitae HomePage</title>
  <link rel="stylesheet" type="text/css" href="/ArborVitae/style/homepage.css">
    <link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
  <style type="text/css">  
    .titolo{
   font-size: 50px;
   color: #46dd2c;
   font-family: fantasy;
   margin-top: 30px;
 }
 
   .navbar-space {
     border: 40px solid white;
     background-color: white;
   }
   
   .separator{
     border: 2px solid #F5F5F5;
     background-color: #F5F5F5;
   }
 
   .video-container{
     background-color: #F5F5F5;
     padding: 1px;
   }
   
   video{
     position: relative;
     max-width: 100%;
     top: 0;
     height: auto;
     box-shadow: 0px 0px 5px 5px #46dd2c;
    outline: none;
    border-radius:90px;
   }
   
   .div-goal{
     background: white;
     padding: 1px;
     text-align: center;
   }
   
   .container-goal{
       display: block;
       align-items: center;
   }
   
   .goal-item1 { grid-area: 1 / 1 / 2 / 2; font-size: 25px}
   .goal-item2 { grid-area: 1 / 2 / 2 / 3}
   
   .goal-img{border-radius: 20%; outline: 10px double #46dd2c; margin-bottom: 30px; align: center;}
   
   .div-aboutus{
     background: white;
     padding: 7em;
   }
   
   .container-aboutus{
     display: grid;
     grid-template-columns: repeat(2, 5fr);
     grid-template-rows: 1fr;
     grid-column-gap: 50px;
     grid-row-gap: 0px;
     padding: 7em;
     background-color: #F5F5F5;
     text-align: center;
     border-radius: 90px;
     width: auto;
     height: auto;
     outline: 3px solid #46dd2c;
   }
   
   .aboutus-item1 { grid-area: 1 / 1 / 2 / 2; border-radius: 50%; size: auto; margin: 0px 0px 0px 0px} /* margine foto tonda*/
   .aboutus-item2 { grid-area: 1 / 2 / 2 / 3; background: light-gray; text-align: justify}
   
   
   .circular--portrait img {size:auto; position: relative; max-width: 85%; max-height: 90%; border-radius: 100%;outline: 6px solid #46dd2c}
   
   @media screen and (max-width: 1350px){
   .container-aboutus{
     display: block;
     padding: 2em;
     background-color:  #F5F5F5;
     text-align: center;
     border-radius: 20px;
   }
   
   .aboutus-item1 { border-radius: 50%; size: auto}
   .aboutus-item2 { background: light-gray; text-align: justify}
   
   .circular--portrait img { size:auto; position: relative; max-width: 30%; max-height: 30%; border-radius: 100%; outline: 6px solid #46dd2c}
   
   }
   
   .text-p{
    font-size: 25px;
    color: black;
    text-align: center;
    margin-top: 6px;
    background-color: #F5F5F5;
    border-radius: 90px;
   }
   
   .goal-text{
   	padding: 2em;
   	margin-left: 40px;
   	margin-right: 40px;
   	outline: 3px solid #46dd2c;
   }
   
   h4{
      font-size: 50px;
	  color: #46dd2c;
	  font-family: fantasy;
	  text-align: center;
	  margin: 80px 0px 0px 0px; /*margine nomi*/
   }
   
   .cart-elements-count{
   	bottom: 0px !important;
   }
   
  </style>
 </head>
 <body>
 
  <%@ include file="../html/homeNavbar.jsp" %>

   <div id="home" class="navbar-space"><br></div>
   <div class="separator"></div>
   
   <div class="video-container" align="center">
      <br>
    <video autoplay loop muted>
     <source src="${pageContext.request.contextPath}/img/homepage_images/Homepage Video.mp4" type="video/mp4"/> 
    </video>
   </div> 


	<div class="separator"><br></div>
	
	<div id="project" class="div-goal">
	    <div  class="container-goal">
	     <div class="goal-item1">
	       <h1 class="titolo" align="center" id="project"><br>Il nostro Goal</h1>
	      <p align="center" class="text-p goal-text">
	       Arbor Vitae &egrave; un progetto che nasce dalla volont&agrave; da parte degli sviluppatori di combattere l&#39;inquinamento ambientale e atmosferico.
	       <br>L&#39;obiettivo &egrave; quello di diminuire l&#39;impatto di CO2 nell&#39;atmosfera causato quotidianamente da industrie, trasporti e allevamenti, e al tempo stesso di contrastare il fenomeno della deforestazione. Infatti, il sito offre la possibilit&agrave; di poter acquistare e piantare un albero in una qualunque parte del pianeta; cos&igrave; facendo l&#39;acquirente potr&agrave; seguire online la storia del progetto che contribuir&agrave; a realizzare.
	       <br>La nostra vuole essere un&#39;organizzazione no-profit, il cui scopo &egrave; quello di sensibilizzare e coinvolgere quante pi&ugrave; persone su questa problematica che danneggia la nostra &ldquo;casa&rdquo;. <br>
	       </p>       
	      </div>
	     <div class="goal-item2" >
	     <br>

	      <img class="goal-img" alt="Scopo del progetto" src="${pageContext.request.contextPath}/img/homepage_images/project.png" height="300" width="500"> 
	     </div>
	    </div>
	    </div>
	
	  
 
    <div class="div-aboutus">
     <h1 class="titolo" align="center" id="aboutus"><br><br>Il nostro Team</h1>
      <div class="container-aboutus">
        <div class="aboutus-item1 circular--portrait">
         <img src="${pageContext.request.contextPath}/img/homepage_images/carlo.jpg" alt="Carlo"/>
        </div>
        <div class="aboutus-item2">
         <h4 align="center">Carlo</h4>
       <p align="center" class="text-p">
        La mia idea di progresso &egrave; un mondo pi&ugrave; sano e sostenibile. Da sempre curioso di intraprendere nuove sfide e nuovi percorsi e convinto della necessit&aacute; di un cambiamento, ho deciso che Arbor Vitae &egrave; la mia idea di progresso. </br><p style="font-size:200%; text-align:center">&ldquo;Che cosa sarebbe la vita se non avessimo il coraggio di correre dei rischi?&rdquo; </p><p id=rig style="text-align:right;font-size:110%;position:relative;right:20px">Vincent Van Gogh</p>
       </p>             
     </div>
     
    </div>
    </div>

     <div class="div-aboutus">
      <div id="aboutus" class="container-aboutus">
      <div class="aboutus-item1 circular--portrait">
      <img src="${pageContext.request.contextPath}/img/homepage_images/maria.jpg" alt="Maria"/>
     </div>
     <div class="aboutus-item2">
      <h4 align="center">Maria</h4>
       <p align="center" class="text-p">
         Mi piace costruire legami profondi. Con le persone che incontro e con i posti che chiamo casa nel mondo; sono sempre stata attratta da temi come la salvaguardia della natura, l&rsquo;equit&aacute; sociale e tutto ci&oacute; che si nasconde sotto la superficie. </br>
         <p style="font-size:200%; text-align:center">&ldquo;Se osservi scientificamente ci&oacute; che sta accadendo sulla Terra e non sei pessimista, non hai capito i dati. Ma se incontri le persone che stanno lavorando per salvare questa Terra... e non sei ottimista, allora sei finito.&rdquo;</p><p id=rig style="text-align:right;font-size:110%;position:relative;right:20px">Stephen Hawking</p>
       </p>             
     </div>
        </div>
    </div>
    
    
     <div class="div-aboutus">
      <div id="aboutus" class="container-aboutus">
      <div class="aboutus-item1 circular--portrait">
      <img src="${pageContext.request.contextPath}/img/homepage_images/francesco.jpg" alt="Francesco"/>
     </div>
     <div class="aboutus-item2">
      <h4 align="center">Francesco</h4>
       <p align="center" class="text-p">
         Il mio inguaribile ottimismo mi porta ad immaginare un futuro in cui c'è una urgente necessità collettiva di agire per ridurre ogni forma di distacco, a partire dal divario sociale fino ad arrivare al problema della spaccatura sempre più netta tra uomo e natura; bisogna tornare a dare importanza alle cose semplici, per permettere ad esse di rifiorire sotto una migliore luce.</br></br>
         <p style="font-size:200%; text-align:center">&ldquo;La natura non è un posto da visitare. E' casa nostra.&rdquo;</p><p id=rig style="text-align:right;font-size:110%;position:relative;right:20px">Gary Snider</p>
       </p>             
     </div>
        </div>
    </div>

   <div id="footer" >
    <%@ include file="../html/footer.html" %>
   </div>

  
 </body>
 
</html>