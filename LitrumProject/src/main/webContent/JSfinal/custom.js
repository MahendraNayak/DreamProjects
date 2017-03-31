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
		var SMCName = (JSON.stringify(response[i].name)).replace(/"/g, '');
		var SMCID = JSON.stringify(response[i].subMainCategoryId);

		if(PAGE == "SMC") HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer'><b>"+SMCName+"</b></td></tr>";
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

		HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer'><b>"+SMCName+"</b></td></tr>";
	}
	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#SUB_SUB_MC_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}