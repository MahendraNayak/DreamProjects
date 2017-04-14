<div class="col-sm-9" style="width:981px"><h4 style="color:#4d20d8">MAIN ITEM DATA MODULE</h4></div>
<form commandName="itemForm" id="form" method="POST" action="editorPannelMainItemAdd" enctype="multipart/form-data">
<div class="col-sm-9" style="width:981px">
    <textarea rows="2" cols="50" id="shortDesc" name="shortDescription" placeholder="Short Description..." class="form-control"></textarea>
</div>
<div class="col-sm-9" style="width:981px">
    <br><textarea rows="4" cols="50" id="longDesc" name="longDescription" placeholder="Long Description..." class="form-control"></textarea><br>
</div>
<div class="col-sm-9" style="width:499px">
    <label>Upload TS File</label>
    <br><input id="pdffile" name="pdfFile" type="file" />
</div>
<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-43px">
    <label>Upload IM File</label>
    <br><input id="imgfile" name="imageFile" type="file" />
</div>
<div class="col-sm-9" style="width:981px"><br>
    <select class="form-control" name="loadUnitId" id="unit">
				<c:forEach var="loadUnit" items="${loadUnitList}" varStatus="loadUnitId">
		                    <option value="${loadUnit.id}">${loadUnit.unitName}</option>
				</c:forEach>
    </select>
</div>
<div class="col-sm-9" style="width:981px"><br><h4 style="color:#4d20d8">SUB MAIN ITEM CHECK MODULE</h4></div>
<div class="col-sm-9" style="width:499px"><br>
    <select class="form-control" name="subItemForMainItem" id="subItemForMainItem">
        <option value="NO">SELECT SUB ITEM AVAILABLE</option>
        <option value="YES">YES</option>
        <option value="NO">NO</option>
    </select>
</div>
<div class="clearfix" style="height: 10px;clear: both;"></div>
<div class="clearfix" style="height: 10px;clear: both;"></div>
<div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
<div><input id="subSubMainCategoryId" name="subSubMainCategoryId" type="hidden" value="${SSMCID}"/></div>
<br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="Add">
</div>
</form>