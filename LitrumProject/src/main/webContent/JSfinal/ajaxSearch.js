var myAjax = ajax();
function ajax() {
	var ajax = null;
	if (window.XMLHttpRequest) {
		try {
				ajax = new XMLHttpRequest();
		}
		catch(e) {}
	}
	else if (window.ActiveXObject) {
		try {
			ajax = new ActiveXObject("Msxm12.XMLHTTP");
		}
		catch (e){
			try{
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e) {}
		}
	}
	return ajax;
}
function request(str, cid, pageName) {
	//Don't forget to modify the path according to your theme
	//alert(str);
	myAjax.open("POST", "searchrequest.php");
	myAjax.onreadystatechange = result;
	myAjax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	myAjax.send("search="+str+"&cid="+cid+"&pageName="+pageName);
}
function result() {
	if (myAjax.readyState == 4) {
		var liste = myAjax.responseText;
		var cible = document.getElementById('tag_update').innerHTML = liste;
		document.getElementById('tag_update').style.display = "block";
	}
}
function selected(choice){
	var cible = document.getElementById('searchkeyword');
	cible.value = choice;
	document.getElementById('tag_update').style.display = "none";
	document.searchform.submit();
}