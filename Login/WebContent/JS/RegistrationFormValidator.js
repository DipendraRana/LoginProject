function validateTheRegistrationForm(){
	var userName=document.registrationform.name.value;
	var userName=userName.replace(/ /g,'');
	var emailId=document.registrationform.emailId.value;
	var password=document.registrationform.password.value;
	var mobileNumber=document.registrationform.mobileNumber.value;
	var regularExpressionForUserName=/[^A-Za-z]{1,}/;
	var regularExpressionForEmailId=/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if(userName==""||regularExpressionForUserName.test(userName)){
		alert("User name not valid");
		return false;
	}
	else if(!regularExpressionForEmailId.test(emailId)||emailId==""){
		alert("Please enter valid e-mail ID");
		return false;
	}
	else if(password.length<5||password==""){
		alert("Password length must be greater than 5");
		return false;
	}
	else if(mobileNumber.length !=10 || isNaN(mobileNumber) || mobileNumber==""){
		alert("Mobile Number not valid");
		return false;
	}
}