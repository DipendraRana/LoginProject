function validateTheLoginForm(){
	var emailId=document.loginform.emailId.value;
	var password=document.loginform.password.value;
	var atTheRatePosition=emailId.indexOf("@");
	var lastDotPosition=emailId.lastIndexOf(".");
	if(atTheRatePosition<1||atTheRatePosition>emailId.length||atTheRatePosition+2>lastDotPosition||lastDotPosition+2>=emailId.length){
		alert("Please enter valid e-mail ID");
		return false
	}
	else if(password.length<5){
		alert("Password can't be blank");
		return false
	}
}