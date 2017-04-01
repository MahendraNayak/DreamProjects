function setMainCategoryID(MCID,MCNAME){
    $("#mainCategoryId").val(MCID);
    $("#mainCategoryName").val(MCNAME);
}

function setSubMainCategoryID(MCID,SMCID,SMCNAME){
	$("#mainCategoryId").val(MCID);
	$("#subMainCategoryId").val(SMCID);
	$("#subMainCategoryName").val(SMCNAME);
}

function getSMCBasedOnMC(ID,PAGE){
    var categoriesForm  = {
    	"mainCategoryId":ID,
    	"mainCategoryName":'MC1'
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
		 $("#mainCategoryId").val(ID);
		 $("#subMainCategoryId").val(0);
		}
		if(PAGE == "SSMC") HTML_TABLE = HTML_TABLE +
"<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='getSSMCBasedOnMC("+SMCID+")'><b>"+SMCName+"</b></td></tr>";
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

    $.ajax({
        url: '/LitrumWebServer/subSubMainCategory/list',
        type: 'GET',
        dataType: 'json',
        data: categoriesForm,
        success: function (response) {

	var HTML_TABLE = "<table class='table'><tbody>";
	for(var i=0;i<response.length;i++){
		var SMCName = (JSON.stringify(response[i].name)).replace(/"/g, '');
		var SMCID = JSON.stringify(response[i].subMainCategoryId);

		HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='getSSMCBasedOnMC("+SMCID+","+SMCName+")'><b>"+SMCName+"</b></td></tr>";
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

		if(PAGE == "CT") HTML_TABLE = HTML_TABLE +
        "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setCompanyTypeID("+ID+","+CTID+","+CTNameWithQuote+")'><b>"+CTName+"</b></td></tr>";
        		$("#serviceOfferedId").val(ID);
        		 $("#companyTypeId").val(0);
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