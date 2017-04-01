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