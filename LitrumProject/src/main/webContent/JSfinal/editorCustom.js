$(document).ready(function() {
    $('#example').DataTable();
} );

function setMainItemID(mainItemID){
    $("#mainItemId").val(mainItemID);
    getSubMainItemsBasedOnMainItem(mainItemID);
}

function setMainAndSubItems(mainItemID,subMainItemID,SD,unit){
    $("#mainItemId").val(mainItemID);
    $("#subMainIemId").val(subMainItemID);
	$("#shortDecription").val(SD);
$("#loadUnitId").val(unit);
}

function setZeroIDOnClick(){
    if($("#mainItemId").val() == 0){
        alert("Please Select Main Item");
        return false;
    }
    $("#subMainIemId").val(0);
}

function setFormSubmitType(formSubmitType){
	$("#formSubmitType").val(formSubmitType);
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
		var subMainItemID = JSON.stringify(response[i].subMainItemId);
		var shortDescription = (JSON.stringify(response[i].shortDescription)).replace(/"/g, '');
		var unitName = (JSON.stringify(response[i].unitName)).replace(/"/g, '');

    var orgSD = JSON.stringify(response[i].shortDescription);
    var orgId = JSON.stringify(response[i].unitId);

		HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setMainAndSubItems("+mainItemID+","+subMainItemID+","+orgSD+","+orgId+")'><b>"+shortDescription+" | "+unitName +"</b></td></tr>";

	}
	HTML_TABLE = HTML_TABLE + "</tbody></table>";

	$("#SUB_MI_TABLE").html(HTML_TABLE);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}

function getMainItemLoadUnit(mainItemID){
    if(mainItemID == 0){
        $("#loadUnitId").val(mainItemID);
        $("#loadUnitId").prop('disabled',false);
    }

    var itemsForm  = {
        	"mainItemId":mainItemID
     }
    $.ajax({
        url: '/LitrumWebServer/loadUnit',
        type: 'GET',
        dataType: 'json',
        data: itemsForm,
        success: function (response) {
            var loadUnitId = JSON.stringify(response.loadUnitId);
            $("#loadUnitId").val(loadUnitId);
            $("#loadUnitId").prop('disabled',true);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}