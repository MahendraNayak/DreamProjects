
jQuery().ready(function() {

  // Binding next button on first step
  $(".open1").unbind("click").click(function() {
        $(".frm").hide("fast");
        $("#sf2").show("slow");
   });

   // Binding next button on second step
   $(".open2").unbind("click").click(function() {
        $(".frm").hide("fast");
        $("#sf3").show("slow");
    });

     // Binding back button on second step
    $(".back2").unbind("click").click(function() {
      $(".frm").hide("fast");
      $("#sf1").show("slow");
    });

     // Binding back button on third step
     $(".back3").unbind("click").click(function() {
      $(".frm").hide("fast");
      $("#sf2").show("slow");
    });

    $(".open3").unbind("click").click(function() {
        // optional
        // used delay form submission for a seccond and show a loader image
        $("#loader").show();
        return false;
    });
});

$(function () {
    $('.navbar-toggle').click(function () {
        $('.navbar-nav').toggleClass('slide-in');
        $('.side-body').toggleClass('body-slide-in');
        $('#search').removeClass('in').addClass('collapse').slideUp(200);

    });

   // Remove menu for searching
   $('#search-trigger').click(function () {
        $('.navbar-nav').removeClass('slide-in');
        $('.side-body').removeClass('body-slide-in');

    });
});

function validateBeforeFirstNext(){
	document.getElementById('BACK_3').style.display = 'none';
	document.getElementById('F_SUBMIT').style.display = 'none';
	var fName = $("#firstName").val();
	var lName = $("#lastName").val();
	var uName = $("#userName").val();

	if(fName == ""){
		showErrorMsg("BACK_2","First Name","Please Enter First Name");
	}else if(lName == ""){
		showErrorMsg("BACK_2","Last Name","Please Enter Last Name");
	}else if(uName == ""){
		showErrorMsg("BACK_2","User Name","Please Enter User Name");
	}
}

function validateBeforeSecondNext(){
	document.getElementById('BACK_2').style.display = 'none';
	document.getElementById('F_SUBMIT').style.display = 'none';
	var password = $("#password").val();
	var password1 = $("#password1").val();
	var emailId = $("#emailId").val();
	var mobileNumber = $("#mobileNumber").val();

	var IndNum = /^[0]?[789]\d{9}$/;
        var email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if(password == ""){
		showErrorMsg("BACK_3","Password","Please Enter Password");
	}else if(password1 == ""){
		showErrorMsg("BACK_3","Confirm Password","Please Enter Confirm Password");
	}else if(password != password1){
		showErrorMsg("BACK_3","Confirm Password","Confirm password should be same as Password");
	}else if(emailId == ""){
		showErrorMsg("BACK_3","Email","Please Enter Email ID");
	}else if(!email.test(emailId)){
		showErrorMsg("BACK_3","Email ID","Invalid Email ID Entered");
	}else if(mobileNumber == ""){
		showErrorMsg("BACK_3","Mobile Number","Please Enter Mobile Number");
	}else if(!IndNum.test(mobileNumber)){
		showErrorMsg("BACK_3","Mobile Number","Invalid Mobile Number Entered");
	}
}

function validateBeforefinalSubmit(){
	document.getElementById('BACK_2').style.display = 'none';
	document.getElementById('BACK_3').style.display = 'none';

	var companyName = $("#companyName").val();
	var companyCity = $("#companyCity").val();
	var serviceOffered = $("#serviceOffered").val();
	var companyType = $("#companyType").val();
	var endUserRole = $("#endUserRole").val();

	if(companyName == ""){
		showErrorMsg("F_SUBMIT","Company Name","Please Enter Company Name");
		return false;
	}else if(companyCity == 0){
		showErrorMsg("F_SUBMIT","Company City","Please Enter Company City");
		return false;
	}else if(serviceOffered == 0){
		showErrorMsg("F_SUBMIT","Service Offered","Please Select Service Offered");
		return false;
	}else if(companyType == 0){
		showErrorMsg("F_SUBMIT","Company Type","Please Select Company Type");
		return false;
	}else if(endUserRole == 0){
		showErrorMsg("F_SUBMIT","End User Role","Please Select End User Role");
		return false;
	}

}

function showErrorMsg(SPAN_ID,TITILE,ERROR_MSG){
	document.getElementById(SPAN_ID).style.display = "";
	alertModal(TITILE, ERROR_MSG);
}


function alertModal(title, body) {
  // Display error message to the user in a modal
  $('#alert-modal-title').html(title);
  $('#alert-modal-body').html(body);
  $('#alert-modal').modal('show');
}