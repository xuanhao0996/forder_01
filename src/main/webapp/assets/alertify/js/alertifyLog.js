
var getMessageLogin = document.getElementById("messageLogin").innerHTML;

if (getMessageLogin == 'success') {
	alertify.success("Login Success !");
	
}
if (getMessageLogin == 'err') {
	alertify.error("You have to Login !");
}
