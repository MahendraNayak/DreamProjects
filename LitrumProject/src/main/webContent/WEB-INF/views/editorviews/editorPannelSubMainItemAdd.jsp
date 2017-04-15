<%@include file="editorPannelHeader.jsp" %>

<body>
<div class="body-wrapper">
    <%@include file="editorPannelMenuBar.jsp" %>
	<div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
		<a href="editorPannelHome"><b>${SMCNAME}</b></a><b> > </b><a href="editorPannelSSMCHome?SMCID=${SMCID}&SMCNM=${SMCNAME}"><b>${SSMCNAME}</b></a>
            </div>
        </div>
        <div class="in-services">
<div class="row" >
		<div class="col-md-3 col-sm-6">
		<div class="panel panel-default" style="width: 1049px;height: 472px;">
			<div class="panel-heading"><h3 class="panel-title">MAIN ITEM DATA MODULE</h3></div>
			<div class="panel-body" style="padding:0;border:0px;height:441px;overflow-y:auto;margin-top:3px">
				<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
					<thead>
					    <tr>
						<th>Item Number</th>
						<th>SD</th>
						<th>LD</th>
						<th>TS</th>
						<th>IM</th>
						<th>UN</th>
						<th>SUB ITEMS</th>
					    </tr>
					</thead>
					<tbody>
					<c:forEach var="mainItemObj" items="${mainItemList}" varStatus="status">
					    <tr>
						<td>SMC${mainItemObj.id}</td>
						<td><textarea rows="2" cols="50" placeholder="Describe yourself here...">${mainItemObj.shortDescription}</textarea></td>
						<td><textarea rows="4" cols="50" placeholder="Describe yourself here...">${mainItemObj.longDescription}</textarea></td>
						<td>${mainItemObj.techSpecificationName}</td>
						<td>${mainItemObj.imageName}</td>
						<td></td>
						<td>${mainItemObj.isSubMainItemForMainItem}</td>
					    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</div>
</div><!--row End -->

<div class="row" >
<div class="col-md-4 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 class="panel-title" style="width:380px">MAIN ITEM</h3></div>
                            <div class="panel-body" style="padding:0;border:0px;height:230px;overflow-y:auto">
                                <table class="table">
                                    <tbody>
					<tr>
					    <td style="font-size:16px;color:black;cursor:pointer"><b>XXXXXXX</b></td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
		<div class="col-md-4 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 class="panel-title">SUB MAIN ITEM</h3></div>
                            <div class="panel-body" style="padding:0;border:0px;height:230px;overflow-y:auto">
                                <table class="table">
                                    <tbody>
					<tr>
					    <td style="font-size:16px;color:black;cursor:pointer"><b>DEMOSD - KG</b></td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
</div><!--row End -->
<div class="row" >
            <div class="col-md-3 col-sm-6">
            <form role="form" id="form" method="POST" action="adminPannelSubMainCat">
            <span>
                <input type="hidden" name="SMCID" id="SMCID" value="${SMCID}">
                <input type="hidden" name="SSMCID" id="SSMCID" value="${SSMCID}">
                <input type="hidden" name="SMCNM" id="SMCID" value="${SMCNAME}">
                <input type="hidden" name="SSMCNM" id="SMCID" value="${SSMCNAME}">
            </span>
                <div class="form-group" style="margin-left:382px">
                    <input type="hidden" id="mainCategoryId" name="mainCategoryId" value="0">
		    <input type="hidden" id="subMainCategoryId" name="subMainCategoryId" value="0">
                    <input type="text" id="subMainCategoryName" name="subMainCategoryName" placeholder="Sub Main Item SD" class="form-control" autocomplete="off" style="width:420px;height:35px"><br>
			<select class="form-control" name="loadUnitId" id="loadUnitId" style="width:419px">
				<option value="0">Select Unit</option>
				<option value="1">KG</option>
				<option value="1">NUMBER</option>
			</select>


                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:7px;width:138px" value="Add" onclick="setZeroIDOnClick('subMainCategoryId')">
                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-89px;width:129px;margin-left:143px" value="Update">
		    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-89px;width:129px;margin-left:278px" value="Delete">
                </div>
            </form>
            </div>
         </div>
	</div> <!-- in-services -->
	</div> <!-- rightInfo landing-page-wrapper -->
</div> <!-- body-wrapper -->
</body>
</html>