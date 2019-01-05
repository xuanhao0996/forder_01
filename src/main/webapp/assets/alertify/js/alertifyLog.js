
var getMessageLogin = document.getElementById("messageLogin").innerHTML;

if (getMessageLogin == 'success') {
	alertify.success("Login Success !");
	
}
if (getMessageLogin == 'err') {
	alertify.error("You have to Login !");
}

var getMessageExistsProduct = document.getElementById("existProduct").innerHTML;
if (getMessageExists == 'existProduct') {
	alertify.error("Exist Product!");
}

var getMessageExistsUser = document.getElementById("existProduct").innerHTML;
if (getMessageExists == 'existProduct') {
	alertify.error("Exist Product!");
}