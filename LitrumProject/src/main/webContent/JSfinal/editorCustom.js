$(document).ready(function() {
    $('#example').DataTable();
} );

function setMainItemID(mainItemID){
    $("#mainItemId").val(mainItemID);
    getSubMainItemsBasedOnMainItem(mainItemID);
}

function setMainAndSubItems(mainItemID,subMainItemID){
    $("#mainItemId").val(mainItemID);
    $("#subMainIemId").val(mainItemID);
}

function setZeroIDOnClick(){
    if($("#mainItemId").val() == 0){
        alert("Please Select Main Item");
        return false;
    }
    $("#subMainIemId").val(0);
}

function getSubMainItemsBasedOnMainItem(mainItemID){
    var subItemForm  = {
    	"mainItemId":mainItemID
    }

    $.ajax({
        url: '/LitrumWebServer/subMainItem/list',
        type: 'GET',
        dataType: 'json',
        data: subItemForm,
        success: function (response) {

	var HTML_TABLE = "<table class='table'><tbody>";
	for(var i=0;i<response.length;i++){
		//var SMCNameWithQuotes = JSON.stringify(response[i].name);
		//var SMCName = (JSON.stringify(response[i].name)).replace(/"/g, '');
		//var SSMCID = JSON.stringify(response[i].subSubMainCategoryId);

		//HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setSubSubMainCategoryID("+ID+","+SSMCID+","+SMCNameWithQuotes+")'><b>"+SMCName+"</b></td></tr>";

	}
	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#SUB_MI_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}
