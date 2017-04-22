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
	$("#loadUnitId").prop('disabled',false);
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
        $("#mainItemId").val(0);
        return;
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
            $("#mainItemId").val(mainItemID);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}


function getAvailableMainItemMakers(){
    resetMainItemMakerForm();
    var cityId = $("#cityId").val();
    var mainItemId = $("#shortDescription").val();

    if(cityId == 0 || mainItemId ==0) return false;
        var subItemForm  = {
        	"cityId":cityId,
        	"mainItemId":mainItemId
        }
        $.ajax({
            url: '/LitrumWebServer/mainItemMaker/list',
            type: 'GET',
            dataType: 'json',
            data: subItemForm,
            success: function (response) {
    	var HTML_TABLE = "<table class='table'><tbody>";
             HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'><b>MAKER NAME</b></td>";
             HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'><b>MAKER RATE</b></td>";
             HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'><b>MAKER PRIORITY</b></td></tr>";
	for(var i=0;i<response.length;i++){
    		var mkNameWithQuotes = JSON.stringify(response[i].mainItemMakerName);
    		var makerName = (JSON.stringify(response[i].mainItemMakerName)).replace(/"/g, '');
    		var makerRate = JSON.stringify(response[i].mainItemMakerRate);
    		var makerPriority = (JSON.stringify(response[i].mainItemMakerPriority)).replace(/"/g, '');

    	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;;cursor:pointer' onclick='setValuesForUpdateMISR("+mkNameWithQuotes+","+makerRate+","+makerPriority+")'><b>"+makerName+"</b></td>";
            HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'>"+makerRate+"</td>";
            HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'>"+makerPriority+"</td></tr>";
	}
    	    HTML_TABLE = HTML_TABLE + "</tbody></table>";

    	$("#MI_MAKER_TABLE").html(HTML_TABLE);
            },
            error: function (e) {
                alert('error'+e);
            }
        });
}

function setValuesForUpdateMISR(makerName,makerRate,makerPriority){
	$("#shortDescription").prop('disabled',true);
    $("#cityId").prop('disabled',true);
	$("#makerName").val(makerName);
	$("#makerPrice").val(makerRate);
	$("#makerPriority").val(makerPriority);
}

function enableMISRFormFields(){
    $("#shortDescription").prop('disabled',false);
    $("#cityId").prop('disabled',false);
}

function resetMainItemMakerForm(){
    $("#makerName").val('');
	$("#makerPrice").val('');
	$("#makerPriority").val('');
}

function resetMainItemMakerFormOnReset(){
    $("#shortDescription").prop('disabled',false);
    $("#cityId").prop('disabled',false);
    $("#loadUnitId").prop('disabled',false);

    $("#makerName").val('');
	$("#makerPrice").val('');
	$("#makerPriority").val('');
	$("#cityId").val(0);
	$("#shortDescription").val(0);
	$("#loadUnitId").val(0);
	$("#MI_MAKER_TABLE").html('');
}


function getAvailableMainItemContractor(){
        var cityId = $("#cityId").val();
        var mainItemId = $("#shortDescription").val();

        if(cityId == 0 || mainItemId ==0) return false;
            var subItemForm  = {
            	"cityId":cityId,
            	"mainItemId":mainItemId
            }
            $.ajax({
                url: '/LitrumWebServer/mainItemContractor/list',
                type: 'GET',
                dataType: 'json',
                data: subItemForm,
                success: function (response) {

        	    var HTML_TABLE = "<table class='table'><tbody>";
                 HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'><b>CONTRACTOR NAME</b></td>";
                 HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'><b>CONTRACTOR RATE</b></td>";
                 HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'><b>CONTRACTOR PRIORITY</b></td></tr>";
    	for(var i=0;i<response.length;i++){
        		var mainItemContractorName = (JSON.stringify(response[i].mainItemContractorName)).replace(/"/g, '');
        		var mainItemContractorRate = JSON.stringify(response[i].mainItemContractorRate);
        		var mainItemContractorPriority = (JSON.stringify(response[i].mainItemContractorPriority)).replace(/"/g, '');

        	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'>"+mainItemContractorName+"</td>";
                HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'>"+mainItemContractorRate+"</td>";
                HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'>"+mainItemContractorPriority+"</td></tr>";
    	}
        	    HTML_TABLE = HTML_TABLE + "</tbody></table>";

        	$("#MI_CONTRACTOR_TABLE").html(HTML_TABLE);
                },
                error: function (e) {
                    alert('error'+e);
                }
            });
}

function getAvailableSubMainItemMakers(){
        var subMainIemId = $("#subMainIemId").val();

        if(subMainIemId ==0) return false;
            var subItemForm  = {
            	"subMainIemId":subMainIemId,
            }
            $.ajax({
                url: '/LitrumWebServer/subMainItemMaker/list',
                type: 'GET',
                dataType: 'json',
                data: subItemForm,
                success: function (response) {
        	var HTML_TABLE = "<table class='table'><tbody>";
                 HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'><b>MAKER NAME</b></td>";
                 HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'><b>MAKER RATE</b></td>";
    	for(var i=0;i<response.length;i++){
        		var subMainItemMakerName = (JSON.stringify(response[i].subMainItemMakerName)).replace(/"/g, '');
        		var subMainItemMakerRate = JSON.stringify(response[i].subMainItemMakerRate);

        	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'>"+subMainItemMakerName+"</td>";
                HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'>"+subMainItemMakerRate+"</td>";
    	}
        	    HTML_TABLE = HTML_TABLE + "</tbody></table>";

        	$("#SMI_MAKER_TABLE").html(HTML_TABLE);
                },
                error: function (e) {
                    alert('error'+e);
                }
            });
}

function getAvailableSubMainItemContractor(){
    var subMainIemId = $("#subMainIemId").val();

            if(subMainIemId ==0) return false;
                var subItemForm  = {
                	"subMainIemId":subMainIemId,
                }
                $.ajax({
                    url: '/LitrumWebServer/subMainItemContractor/list',
                    type: 'GET',
                    dataType: 'json',
                    data: subItemForm,
                    success: function (response) {
            	var HTML_TABLE = "<table class='table'><tbody>";
                     HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'><b>CONTRACTOR NAME</b></td>";
                     HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'><b>CONTRACTOR RATE</b></td>";
        	for(var i=0;i<response.length;i++){
            		var subMainItemContractorName = (JSON.stringify(response[i].subMainItemContractorName)).replace(/"/g, '');
            		var subMainItemContractorRate = JSON.stringify(response[i].subMainItemContractorRate);

            	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black'>"+subMainItemContractorName+"</td>";
                    HTML_TABLE = HTML_TABLE + "<td style='font-size:16px;color:black'>"+subMainItemContractorRate+"</td>";
        	}
            	    HTML_TABLE = HTML_TABLE + "</tbody></table>";

            	$("#SMI_CONTRACTOR_TABLE").html(HTML_TABLE);
                    },
                    error: function (e) {
                        alert('error'+e);
                    }
                });
}

function addUpdateDeleteSubMainItems(formSubmitType){
	$("#loadUnitId").prop('disabled',false);
	var loadUnitId = $("#loadUnitId").val();
	$("#loadUnitId").prop('disabled',true);
	var mainItemId = $("#mainItemId").val();
	var shortDecription = $("#shortDecription").val();
	var subMainIemId = 0;

	if(formSubmitType == 'UPDATE' || formSubmitType == 'DELETE') subMainIemId = $("#subMainIemId").val()

	var subItemForm  = {
		"formSubmitType":formSubmitType,
		"subMainIemId":subMainIemId,
		"mainItemId":mainItemId,
		"loadUnitId":loadUnitId,
		"shortDecription":shortDecription
        }

	        $.ajax({
                url: '/LitrumWebServer/editorPannelSubMainItemAdd',
                type: 'POST',
                dataType: 'json',
                data: subItemForm,
                success: function (response) {
			        getSubMainItemsBasedOnMainItem(mainItemId);
		        },
                error: function (e) {
                    alert('error'+e);
                }

            });
            return false;
}


function setMainItemDetailsToupdate(mainItemId,shortDescription,longDescription,loadUnitId,subItemForMainItem){
	var mainItemAvail = 'NO';
	if(subItemForMainItem) mainItemAvail = 'YES';
	$("#mainITEMID").val(mainItemId);
	$("#shortDescriptionUpdate").val(shortDescription);
	$("#longDescriptionUpdate").val(longDescription);
	$("#loadUnitIdUpdate").val(loadUnitId);
	$("#subItemForMainItemsUpdate").val(mainItemAvail);
}

/*function updateMainItemDetails(){
	var itemForm  = {
		"mainItemId":$("#mainITEMID").val(),
		"loadUnitId":$("#loadUnitIdUpdate").val(),
		"shortDescription":$("#shortDescriptionUpdate").val(),
		"longDescription":$("#longDescriptionUpdate").val(),
		"subItemForMainItem":$("#subItemForMainItemsUpdate").val()
	}

	$.ajax({
		url: '/LitrumWebServer/mainItem/update',
		type: 'POST',
		dataType: 'json',
		data: itemForm,
		success: function (response) {
				//getSubMainItemsBasedOnMainItem(mainItemId);
				alert("updated sucessfully");
			},
		error: function (e) {
		    alert('error'+e);
		}
	});
}*/