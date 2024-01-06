function validateForm(){
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var proMadeIn=document.getElementById("proMadeIn").value;
	var proMfgDate=document.getElementById("proMfgDate").value;
	var proExpDate=document.getElementById("proExpDate").value;
	
	if(proId.trim() ==="" || proName.trim() ==="" || proPrice.trim() ==="" || proBrand.trim() ==="" || proMadeIn.trim() ===""){
		alert("All fields must be filled out..")
		return false;
	}	
	
	if(parseFloat(proPrice)<0){
		alert("product price must be a non-negative value..");
		return false;
	}
	
	if(proName.length >50 || proBrand.length >50){
		alert("product name and product brand must be less than 50 characters");
		return false;
	}
	//conversion mfgdate and expDate into date formate
	var manufactureDateObj = new Date(proMfgDate);
	var expiryDateObj = new Date(proExpDate);
	
	if(manufactureDateObj > expiryDateObj){
		alert("manufactureing date cannot be greater than expiry date.");
		return false;
	}
	return true;
}