<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
    <title>Arbor Vitae</title>
     <link rel="icon" href="/ArborVitae/img/homepage_images/logo.ico" type="image/x-icon">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../js/validationForm.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/ArborVitae/style/signup.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <style>
      body, html {
      margin: 0;
      padding: 0;
      height: 100%;
      background-image: url('../img/homepage_images/sfondo1.jpg');
	  background-repeat: no-repeat;
      background-size: cover;
    }
    
    p.pError{
   		text-align:center;
    }
    .user_card {
      height: 600px;
      width: 450px;
      margin-top: auto;
      margin-bottom: auto;
      background: #71f545;
      position: relative;
      display: flex;
      justify-content: center;
      flex-direction: column;
      padding: 7px;
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
      margin-top: 80px;
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
              <img src="../img/homepage_images/logo.png" class="brand_logo" alt="Logo">
               <h1>Benvenuto!</h1>
            </div>
          </div>
          
          <!-- mb3 -->
          <div class="d-flex justify-content-center form_container">
            <form action="${pageContext.request.contextPath}/signup" method="post" onSubmit="return validate()">
              <div class="input-group mb-2">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="email" name="email" class="form-control input_user" value="" placeholder="email" onchange="checkEmail(this)">
              </div>
                <div class="input-group mb-2">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="text" name="name" class="form-control input_pass" value="" placeholder="name" onchange="checkName(this)">
              </div>
                <div class="input-group mb-2">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="text" name="surname" class="form-control input_pass" value="" placeholder="surname" onchange="checkName(this)">
              </div>
              <div class="input-group mb-2">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="text" name="country" class="form-control input_pass" value="" placeholder="country" onchange="checkName(this)">
              </div>
              <div class="input-group mb-2">
                <div class="input-group-append">
                  <span class="input-group-text"><i class="fas fa-key"></i></span>
                </div>
                <input type="password" name="password" class="form-control input_pass" value="" placeholder="password" onchange="checkPwd(this)">
              </div>
              <div class="d-flex justify-content-center mt-3 login_container">
              <button type="submit" name="aggAdmin" class="btn login_btn" >Sign up</button>
             </div>
            </form>
          </div>
      
          <div class="mt-4">
            <div class="d-flex justify-content-center links">
              Hai già un account? <a href="${pageContext.request.contextPath}/view/login.jsp" class="ml-2">Accedi.</a>
            </div>
            <% if(session.getAttribute("logged")!=null && session.getAttribute("logged").equals("false")){%>
            	  <p class="pError" >Email già in uso!</p>
              <%}session.removeAttribute("logged");%>
          </div>
        </div>
      </div>
    </div>
	</body>
</html>