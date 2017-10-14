function validateTheLoginForm(){
	var emailId=document.loginform.emailId.value;
	var password=document.loginform.password.value;
	var atTheRatePosition=emailId.indexOf("@");
	var lastDotPosition=emailId.lastIndexOf(".");
	var regularExpressionForEmailId=/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if(!regularExpressionForEmailId.test(emailId)||emailId==""){
		alert("Please enter valid e-mail ID");
		return false
	}
	else if(password.length<=5||password==""){
		alert("Password length must be greater than 5");
		return false
	}
}