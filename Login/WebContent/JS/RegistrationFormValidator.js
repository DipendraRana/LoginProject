function validateTheRegistrationForm(){
	var userName=document.registrationform.name.value;
	var emailId=document.registrationform.emailId.value;
	var password=document.registrationform.password.value;
	var mobileNumber=document.registrationform.mobileNumber.value;
	var atTheRatePosition=emailId.indexOf("@");
	var lastDotPosition=emailId.lastIndexOf(".");
	var regularExpression="[A-Za-z]{1,}";
	if(userName==null||userName==""||!regularExpression.match(userName)){
		alert("User ID can't be blank and not a number");
		return false;
	}
	else if(atTheRatePosition<1 || atTheRatePosition>emailId.length || atTheRatePosition+2>lastDotPosition || lastDotPosition+2>=emailId.length){
		alert("Please enter valid e-mail ID");
		return false
	}
	else if(password.length<=5){
		alert("Password length must be greater than 5");
		return false
	}
	else if(mobileNumber.length!=10 && !isNaN(mobileNumber)){
		alert("Mobile Number Should be of 10 digits and should not contain alphabets");
		return false
	}
}