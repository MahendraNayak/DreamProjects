function setMainCategoryID(MCID,MCNAME){
    $("#mainCategoryId").val(MCID);
    $("#mainCategoryName").val(MCNAME);
}

function setSubMainCategoryID(MCID,SMCID,SMCNAME){
	$("#mainCategoryId").val(MCID);
	$("#subMainCategoryId").val(SMCID);
	$("#subMainCategoryName").val(SMCNAME);
}

function setSubSubMainCategoryID(SMCID,SSMCID,SSMCNAME){
	$("#subMainCategoryId").val(SMCID);
	$("#subSubMainCategoryId").val(SSMCID);
	$("#subSubMainCategoryName").val(SSMCNAME);
}

function getSMCBasedOnMC(ID,PAGE){
    var categoriesForm  = {
    	"mainCategoryId":ID,
    	"mainCategoryName":'MC1'
    }
if(PAGE == "SMC"){
        $("#mainCategoryId").val(ID);
		 $("#subMainCategoryId").val(0);
}
if(PAGE == "SSMC"){
        $("#subMainCategoryId").val(0);
        $("#subSubMainCategoryId").val(0);
        $("#SUB_SUB_MC_TABLE").html("");
}
    $.ajax({
        url: '/LitrumWebServer/subMainCategory/list',
        type: 'GET',
        dataType: 'json',
        data: categoriesForm,
        success: function (response) {

	var HTML_TABLE = "<table class='table'><tbody>";
	for(var i=0;i<response.length;i++){
		var SMCNameWithQuote = (JSON.stringify(response[i].name))
		var SMCName = (JSON.stringify(response[i].name)).replace(/"/g, '');
		var SMCID = JSON.stringify(response[i].subMainCategoryId);

		if(PAGE == "SMC"){
		 HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setSubMainCategoryID("+ID+","+SMCID+","+SMCNameWithQuote+")'><b>"+SMCName+"</b></td></tr>";
		}
		if(PAGE == "SSMC"){
 			HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='getSSMCBasedOnMC("+SMCID+")'><b>"+SMCName+"</b></td></tr>";
		}
	}
	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#SUB_MC_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}

function getSSMCBasedOnMC(ID){
    var categoriesForm  = {
    	"subMainCategoryId":ID
    }
	$("#subMainCategoryId").val(ID);
	$("#subSubMainCategoryId").val(0);
	$("#subSubMainCategoryName").val("");

    $.ajax({
        url: '/LitrumWebServer/subSubMainCategory/list',
        type: 'GET',
        dataType: 'json',
        data: categoriesForm,
        success: function (response) {

	var HTML_TABLE = "<table class='table'><tbody>";
	for(var i=0;i<response.length;i++){
		var SMCNameWithQuotes = JSON.stringify(response[i].name);
		var SMCName = (JSON.stringify(response[i].name)).replace(/"/g, '');
		var SSMCID = JSON.stringify(response[i].subSubMainCategoryId);

		HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setSubSubMainCategoryID("+ID+","+SSMCID+","+SMCNameWithQuotes+")'><b>"+SMCName+"</b></td></tr>";

	}
	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#SUB_SUB_MC_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}

function getCTBasedOnSO(ID,PAGE){
    var companyTypeAndUserForm  = {
    	"serviceOfferedId":ID
    }
    if(PAGE == "CT"){
        $("#serviceOfferedId").val(ID);
        $("#companyTypeId").val(0);
    }else if(PAGE == "END_ROLE"){
        $("#userRoleId").val(0);
        $("#companyTypeId").val(0);
        $("#userRoleName").val("");
        $("#END_USER_ROLE_TABLE").html("");
    }
    $.ajax({
        url: '/LitrumWebServer/companyType/list',
        type: 'GET',
        dataType: 'json',
        data: companyTypeAndUserForm,
        success: function (response) {
	var HTML_TABLE = "<table class='table'><tbody>";
	for(var i=0;i<response.length;i++){
		var CTNameWithQuote = (JSON.stringify(response[i].type))
		var CTName = (JSON.stringify(response[i].type)).replace(/"/g, '');
		var CTID = JSON.stringify(response[i].companyTypeId);

        if(PAGE == "CT"){ HTML_TABLE = HTML_TABLE +
            "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setCompanyTypeID("+ID+","+CTID+","+CTNameWithQuote+")'><b>"+CTName+"</b></td></tr>";
        }else if(PAGE == "END_ROLE"){
             HTML_TABLE = HTML_TABLE +
            "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='getEndUserRoleBasedOnCompType("+CTID+")'><b>"+CTName+"</b></td></tr>";
        }
    }

	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#CT_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}

function setCompanyTypeID(SOID,CTID,CTNAME){
	$("#serviceOfferedId").val(SOID);
	$("#companyTypeId").val(CTID);
	$("#companyTypeName").val(CTNAME);
}

function setEndUserRoleID(CTID,userRoleId,userRoleNameWithQuotes){
	$("#companyTypeId").val(CTID);
	$("#userRoleId").val(userRoleId);
	$("#userRoleName").val(userRoleNameWithQuotes);
}

function getEndUserRoleBasedOnCompType(CTID){

	var companyTypeAndUserRolesForm  = {
    		"companyTypeId":CTID
    	}

	$("#companyTypeId").val(CTID);
    $.ajax({
        url: '/LitrumWebServer/endUserRole/list',
        type: 'GET',
        dataType: 'json',
        data: companyTypeAndUserRolesForm,
        success: function (response) {

	var HTML_TABLE = "<table class='table'><tbody>";
	for(var i=0;i<response.length;i++){
		var userRoleNameWithQuotes = JSON.stringify(response[i].roleName);
		var userRoleName = (JSON.stringify(response[i].roleName)).replace(/"/g, '');
		var userRoleId = JSON.stringify(response[i].endUserRoleId);

		HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setEndUserRoleID("+CTID+","+userRoleId+","+userRoleNameWithQuotes+")'><b>"+userRoleName+"</b></td></tr>";

	}
	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#END_USER_ROLE_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}

function setAdminUserRoleID(AURID,AURNAME){
    $("#userRoleId").val(AURID);
    $("#userRoleName").val(AURNAME);
}

function getCompanyTypeBasedOnSO(SERVICE_OFFERED_ID){
 	if(SERVICE_OFFERED_ID == 0) return;
 	var companyTypeAndUserForm  = {
     		"serviceOfferedId":SERVICE_OFFERED_ID
     	}

 	$.ajax({
 		url: '/LitrumWebServer/companyType/list',
 		type: 'GET',
 		dataType: 'json',
 		data: companyTypeAndUserForm,
 		async:true,
 		success: function (response) {
 			if(response.length == 0) return;
 			var HTML_TABLE = "<select class='form-control' name='companyType' id='companyType' onChange='getEURoleBasedOnCompTypeReg(this.value)'>";
 			for(var i=0;i<response.length;i++){
 			var CTNameWithQuote = (JSON.stringify(response[i].type))
 			var CTName = (JSON.stringify(response[i].type)).replace(/"/g, '');
 			var CTID = JSON.stringify(response[i].companyTypeId);
 				HTML_TABLE = HTML_TABLE  + "<option value='"+CTID+"'>"+CTName+"</option>";
 			     }
 		 	HTML_TABLE = HTML_TABLE  + "</select>";
 			$("#COMP_TYPE").html(HTML_TABLE);

            var COMP_ID = $("#companyType").val();
 			if(COMP_ID != 0) getEURoleBasedOnCompTypeReg(COMP_ID)
 		},
 		error: function (e) {
 		    alert('error'+e);
 		}
     	});

 }

 function getEURoleBasedOnCompTypeReg(COMP_ID){
 	var companyTypeAndUserRolesForm  = {
        		"companyTypeId":COMP_ID
    }

 	$.ajax({
 		url: '/LitrumWebServer/endUserRole/list',
 		type: 'GET',
 		dataType: 'json',
 		data: companyTypeAndUserRolesForm,
 		async:true,
 		success: function (response) {
 			if(response.length == 0) return;
 			var HTML_TABLE = "<select class='form-control' name='endUserRole' id='endUserRole'>";
 			for(var i=0;i<response.length;i++){
 			var userRoleNameWithQuotes = JSON.stringify(response[i].roleName);
            var userRoleName = (JSON.stringify(response[i].roleName)).replace(/"/g, '');
            var userRoleId = JSON.stringify(response[i].endUserRoleId);
 				HTML_TABLE = HTML_TABLE  + "<option value='"+userRoleId+"'>"+userRoleName+"</option>";
 			     }
 		 	HTML_TABLE = HTML_TABLE  + "</select>";
 			$("#USR_ROLE").html(HTML_TABLE);
 		},
 		error: function (e) {
 		    alert('error'+e);
 		}
     	});

 }

  function setZeroIDOnClick(FIELD_ID){
    $("#"+FIELD_ID).val(0);
  }

  function validateAdminUsrBeforefinalSubmit(){

  	var fName = $("#firstName").val();
    var lName = $("#lastName").val();
    var uName = $("#userName").val();
    var password = $("#password").val();
	var password1 = $("#password1").val();
	var emailId = $("#emailId").val();
	var mobileNumber = $("#mobile").val();
	var mainCategoryId = $("#mainCategoryId").val();
	var adminUserRoleId = $("#adminUserRoleId").val();

	var IndNum = /^[0]?[789]\d{9}$/;
    var email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if(fName == ""){
        alertModalForAdmUsr("First Name","Please Enter First Name");
        return false;
    }else if(lName == ""){
        alertModalForAdmUsr("Last Name","Please Enter Last Name");
        return false;
    }else if(uName == ""){
        alertModalForAdmUsr("User Name","Please Enter User Name");
        return false;
    }else if(password == ""){
        alertModalForAdmUsr("Password","Please Enter Password");
        return false;
    }else if(password1 == ""){
        alertModalForAdmUsr("Confirm Password","Please Enter Confirm Password");
        return false;
    }else if(password != password1){
        alertModalForAdmUsr("Confirm Password","Confirm password should be same as Password");
        return false;
    }else if(emailId == ""){
        alertModalForAdmUsr("Email","Please Enter Email ID");
        return false;
    }else if(!email.test(emailId)){
        alertModalForAdmUsr("Email ID","Invalid Email ID Entered");
        return false;
    }else if(mobileNumber == ""){
        alertModalForAdmUsr("Mobile Number","Please Enter Mobile Number");
        return false;
    }else if(!IndNum.test(mobileNumber)){
        alertModalForAdmUsr("Mobile Number","Invalid Mobile Number Entered");
        return false;
    }else if(mainCategoryId ==0){
        alertModalForAdmUsr("Main Category","Please Select Category");
        return false;
    }else if(adminUserRoleId == 0){
        alertModalForAdmUsr("User Role","Please Select Role");
        return false;
    }

  }


  function alertModalForAdmUsr(title, body) {
    // Display error message to the user in a modal
    $('#alert-modal-title').html(title);
    $('#alert-modal-body').html(body);
    $('#alert-modal').modal('show');
  }

  function addUpdateSubSubMainCatAjaxCall(operationName){
    if(operationName == "ADD") setZeroIDOnClick('subSubMainCategoryId');

    var subMainCategoryId = $("#subMainCategoryId").val();
    var subSubMainCategoryId = $("#subSubMainCategoryId").val();
    var subSubMainCategoryName = $("#subSubMainCategoryName").val();

    var categoryForm = {
        "subMainCategoryId":subMainCategoryId,
		"subSubMainCategoryId":subSubMainCategoryId,
		"subSubMainCategoryName":subSubMainCategoryName
    }

    $.ajax({
                    url: '/LitrumWebServer/adminPannelSubSubMainCatAjax',
                    type: 'POST',
                    dataType: 'json',
                    data: categoryForm,
                    success: function (response) {
    			        getSSMCBasedOnMC(subMainCategoryId);
    		        },
                    error: function (e) {
                        alert('error'+e);
                    }

                });
                return false;
    //
  }