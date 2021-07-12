/**
 * 
 */

function checkPassword(){
	if(document.getElementById("pwd").value != document.getElementById("confirmpwd").value){
		alert("Password mismatch");
		return false;
	}else{
		//alert("Password matched");
	}
	
}

function enablebutton(){
	if(document.getElementById("chekpolicy").checked){
		document.getElementById("submitbt").disabled=false;
	}else{
		document.getElementById("submitbt").disabled=true;
	}
}

function updatePassword(){
	if(document.getElementById("checkUpdatePass").checked){
		document.getElementById("confirmpwd").disabled=false;
		document.getElementById("pwd").disabled=false;
		document.getElementById("gg").disabled=false;
	}else{
		document.getElementById("confirmpwd").disabled=true;
		document.getElementById("pwd").disabled=true;
		document.getElementById("gg").disabled=true;
	}
}