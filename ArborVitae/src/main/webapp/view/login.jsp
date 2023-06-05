<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
  <html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Arbor Vitae</title>
     <link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="js/jquery-ui-1.13.1.custom/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="js/jquery-ui-1.13.1.custom/jquery-ui.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <style>
      body,html {
      margin: 0;
      padding: 0;
      height: 100%;
	}
    
    body{
		background-image: url('/ArborVitae/img/homepage_images/sfondo.jpg');
		background-repeat: no-repeat;
		background-size: cover;
    }
    
    p.pError{
   		text-align:center;
    }
    
    .user_card {
      height: 450px;
      width: 400px;
      margin-top: auto;
      margin-bottom: auto;
      background: #71f545;
      position: relative;
      display: flex;
      justify-content: center;
      flex-direction: column;
      padding: 10px;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
      -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
      -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
      border-radius: 5px;

    }
    .brand_logo_container {
      position: absolute;
      height: 170px;
      width: 170px;
      top: -75px;
      border-radius: 50%;
      background: #ffffff;
      padding: 10px;
      text-align: center;
    }
    .brand_logo {
      height: 150px;
      width: 150px;
      border-radius: 50%;
      border: 2px solid white;
    }
    .form_container {
      margin-top: 100px;
    }
    .login_btn {
      width: 100%;
      background: #1e6916 !important;
      color: white !important;
    }
    .login_btn:focus {
      box-shadow: none !important;
      outline: 0px !important;
    }
    .login_container {
      padding: 0 2rem;
    }
    .input-group-text {
      background: #1e6916 !important;
      color: white !important;
      border: 0 !important;
      border-radius: 0.25rem 0 0 0.25rem !important;
    }
    .input_user,
    .input_pass:focus {
      box-shadow: none !important;
      outline: 0px !important;
    }
    .custom-checkbox .custom-control-input:checked~.custom-control-label::before {
      background-color: #1e6916 !important;
    }
    
	h1{
	  color: #1e6916;
	  font-family: fantasy;
	  margin-top: 30px;
	  margin-left: -19%;
	}
    
    </style>
  </head>
  <body>
    <div class="container h-100">
      <div class="d-flex justify-content-center h-100">
        <div class="user_card">
          <div class="d-flex justify-content-center">
            <div class="brand_logo_container">
              <img src="/ArborVitae/img/homepage_images/logo.png" class="brand_logo" alt="Logo">
              <h1>Bentornato</h1>
            </div>
          </div>
          <div class="d-flex justify-content-center form_container">
            <form action="${pageContext.request.contextPath}/login" method="get">
              <div class="input-group mb-3">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <!-- onchange="funzione di validazione javascript" -->
                <input type="email" name="email" class="form-control input_user" value="" placeholder="email">
              </div>
              <div class="input-group mb-2">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-key"></i></span>
                </div>
                <input type="password" name="password" class="form-control input_pass" value="" placeholder="password">
              </div>
              <div class="d-flex justify-content-center mt-3 login_container">
              <button type="submit" name="login" class="btn login_btn">Login</button>
             </div>
            </form>
          </div>
      
          <div class="mt-4">
            <div class="d-flex justify-content-center links">
              Non hai un account? <a href="${pageContext.request.contextPath}/view/signup.jsp" class="ml-2">Creane uno.</a>
            </div>
             <% if(session.getAttribute("logged")!=null && session.getAttribute("logged").equals("false")){%>
            	  <p class="pError" >Email o password incorrette... Riprovare</p>
              <%}session.removeAttribute("logged");%>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>