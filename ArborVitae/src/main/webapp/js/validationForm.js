

function checkPwd(input){
	var pwd=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/g;
	if(input.value.match(pwd)){
		input.classList.remove("error");
		return true;
	}else{
		input.classList.add("error");	
		return false;
	}
}

function checkName(input){
	var name=/^[\w'\-,.][^0-9_!¡?÷?¿/\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/; 
	if(input.value.match(name)){
		input.classList.remove("error");
		return true;
	}else{
		input.classList.add("error");	
		return false;
	}
}

function checkEmail(input)
{
	var email=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(input.value.match(email)){
		input.classList.remove("error");
		return true;
	}else{
		input.classList.add("error");	
		return false;
	}
}



function validate()
{
	var valid = true;
	
	
	//validiamo il nome
	var name=document.getElementsByName("name")[0];
	if(!checkName(name)){
		valid=false;
		alert('Campo NOME non corretto!');
		name.classList.add("error");
	}else
		name.classList.remove("error");
	
	//validiamo il paese
	var country=document.getElementsByName("country")[0];
	if(!checkName(country)){
		valid=false;
		alert('Campo Country non corretto!');
		country.classList.add("error");
	}else
		country.classList.remove("error");
	
	//validiamo il cognome
	var cognome=document.getElementsByName("surname")[0];
	if(!checkName(cognome)){
		valid=false;
		alert('Campo COGNOME non corretto!');
		cognome.classList.add("error");
	}else
		cognome.classList.remove("error");

	//validiamo l'email
	var email=document.getElementsByName("email")[0];
	if(!checkEmail(email)){
		valid=false;
		alert('Campo EMAIL non corretto!');
		email.classList.add("error");
	}else
		email.classList.remove("error");

	//validiamo la password
	var pwd = document.getElementsByName("password")[0];
	if(!checkPwd(pwd)){
		valid=false;
		alert('Campo PASSWORD non corretto!');
		pwd.classList.add("error");
	}else
		pwd.classList.remove("error");

	
	
	return valid;
}


