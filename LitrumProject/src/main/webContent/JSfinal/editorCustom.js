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
    		var makerId = JSON.stringify(response[i].mainItemMakerId);

    	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;;cursor:pointer' onclick='setValuesForUpdateMISR("+makerId+","+mkNameWithQuotes+","+makerRate+","+makerPriority+")'><b>"+makerName+"</b></td>";
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

function setValuesForUpdateMISR(makerId,makerName,makerRate,makerPriority){
	$("#shortDescription").prop('disabled',true);
    $("#cityId").prop('disabled',true);
	$("#makerName").val(makerName);
	$("#makerPrice").val(makerRate);
	$("#makerPriority").val(makerPriority);
	$("#makerId").val(makerId);
}

function enableMISRFormFields(){
    $("#shortDescription").prop('disabled',false);
    $("#cityId").prop('disabled',false);
}

function resetMainItemMakerForm(){
    $("#makerName").val('');
	$("#makerPrice").val('');
	$("#makerPriority").val('');
	$("#makerId").val(0);
}

function setValuesForUpdateMIIR(contractorId,contractorName,contractorPrice,contractorPriority){
	$("#shortDescription").prop('disabled',true);
    $("#cityId").prop('disabled',true);
	$("#contractorName").val(contractorName);
	$("#contractorPrice").val(contractorPrice);
	$("#contractorPriority").val(contractorPriority);
	$("#contractorId").val(contractorId);
}

function resetMainItemIRForm(){
    $("#contractorName").val('');
	$("#contractorPrice").val('');
	$("#contractorPriority").val('');
	$("#contractorId").val(0);
}

function enableMIIRFormFields(){
    $("#shortDescription").prop('disabled',false);
    $("#cityId").prop('disabled',false);
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
	$("#makerId").val(0);
	$("#MI_MAKER_TABLE").html('');
}

function resetMainItemIRFormOnReset(){
    $("#shortDescription").prop('disabled',false);
    $("#cityId").prop('disabled',false);
    $("#loadUnitId").prop('disabled',false);

    $("#contractorName").val('');
	$("#contractorPrice").val('');
	$("#contractorPriority").val('');
	$("#cityId").val(0);
	$("#shortDescription").val(0);
	$("#loadUnitId").val(0);
	$("#MI_CONTRACTOR_TABLE").html('');
	$("#contractorId").val(0);
}

function setOperationType(opType){
    $("#operationType").val(opType);
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
        		var mainItemContractorNameQu = JSON.stringify(response[i].mainItemContractorName);
        		var mainItemContractorName = (JSON.stringify(response[i].mainItemContractorName)).replace(/"/g, '');
        		var mainItemContractorRate = JSON.stringify(response[i].mainItemContractorRate);
        		var mainItemContractorPriority = (JSON.stringify(response[i].mainItemContractorPriority)).replace(/"/g, '');
                var mainItemContractorId = JSON.stringify(response[i].mainItemContractorId);

                HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;;cursor:pointer' onclick='setValuesForUpdateMIIR("+mainItemContractorId+","+mainItemContractorNameQu+","+mainItemContractorRate+","+mainItemContractorPriority+")'><b>"+mainItemContractorName+"</b></td>";
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
        		var subMainItemMakerNameWithQue = JSON.stringify(response[i].subMainItemMakerName);
        		var subMainItemMakerName = (JSON.stringify(response[i].subMainItemMakerName)).replace(/"/g, '');
        		var subMainItemMakerRate = JSON.stringify(response[i].subMainItemMakerRate);
			    var subMainItemMakerId = JSON.stringify(response[i].subMainItemMakerId);
			    var subMainItemId = JSON.stringify(response[i].subMainItemId);
        	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setValuesForUpdateSMISR("+subMainItemId+","+subMainItemMakerId+","+subMainItemMakerNameWithQue+","+subMainItemMakerRate+")'><b>"+subMainItemMakerName+"</b></td>";
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

function setValuesForUpdateSMISR(subMainItemId,subMainItemMakerId,subMainItemMakerNameWithQue,subMainItemMakerRate){
	$("#subMainItemMakerName").val(subMainItemMakerNameWithQue);
	$("#subMainItemMakerRate").val(subMainItemMakerRate);
	$("#subMainIemId").val(subMainItemId);
	$("#subMainItemMakerId").val(subMainItemMakerId);
	$("#subMainIemId").prop('disabled',true);
}

function setValuesForUpdateSMIIR(subMainItemId,subMainItemContractorId,subMainItemContractorNameWithQue,subMainItemContractorRate){
	$("#subMainItemContractorName").val(subMainItemContractorNameWithQue);
	$("#subMainItemContractorRate").val(subMainItemContractorRate);
	$("#subMainIemId").val(subMainItemId);
	$("#subMainItemContractorId").val(subMainItemContractorId);
	$("#subMainIemId").prop('disabled',true);
}

function enableSMISRFormFields(){
    $("#subMainIemId").prop('disabled',false);
}

function enableSMIIRFormFields(){
    $("#subMainIemId").prop('disabled',false);
}

function resetSubMainItemMakerFormOnReset(){
    $("#SMI_MAKER_TABLE").html('');
    $("#subMainIemId").prop('disabled',false);
    $("#subMainItemMakerName").val('');
    $("#subMainItemMakerRate").val('');
    $("#subMainIemId").val(0);
    $("#makerId").val(0);
}

function resetSubMainItemContractorFormOnReset(){
    $("#SMI_CONTRACTOR_TABLE").html('');
    $("#subMainIemId").prop('disabled',false);
    $("#subMainItemContractorName").val('');
    $("#subMainItemContractorRate").val('');
    $("#subMainIemId").val(0);
    $("#makerId").val(0);
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
            		var subMainItemContractorNameWithQue = JSON.stringify(response[i].subMainItemContractorName);
            		var subMainItemContractorName = (JSON.stringify(response[i].subMainItemContractorName)).replace(/"/g, '');
            		var subMainItemContractorRate = JSON.stringify(response[i].subMainItemContractorRate);
                    var subMainItemContractorId = JSON.stringify(response[i].subMainItemContractorId);
                    var subMainItemId = JSON.stringify(response[i].subMainItemId);
            	    HTML_TABLE = HTML_TABLE + "<tr><td style='font-size:16px;color:black;cursor:pointer' onclick='setValuesForUpdateSMIIR("+subMainItemId+","+subMainItemContractorId+","+subMainItemContractorNameWithQue+","+subMainItemContractorRate+")'><b>"+subMainItemContractorName+"</b></td>";
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