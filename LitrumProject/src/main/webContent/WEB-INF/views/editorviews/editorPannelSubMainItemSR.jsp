<%@include file="editorPannelHeader.jsp" %>

<body>
<div class="body-wrapper">
    <%@include file="editorPannelMenuBar.jsp" %>
    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
                <a href="editorPannelHome"><b>${SMCNM}</b></a><b> > </b><a href="editorPannelSSMCHome?SMCID=${SMCID}&SMCNM=${SMCNM}"><b>${SSMCNM}</b></a>
            </div>
        </div>
        <div class="in-services">
        <c:if test="${not empty sucecssMessage}"><font color="green">${successMessage}</font></c:if>
        <c:if test="${not empty errorMessage}"><font color="red">${errorMessage}</font></c:if>
        <form commandName="form" id="form" method="POST" action="editorPannelSubMainItemSRORIRAdd">
		    <div class="col-md-3 col-sm-6">
		        <div class="panel panel-default" style="width:1017px">
                <span>
                    <input type="hidden" name="SMCID" id="SMCID" value="${SMCID}">
                    <input type="hidden" name="SSMCID" id="SSMCID" value="${SSMCID}">
                    <input type="hidden" name="SMCNM" id="SMCID" value="${SMCNM}">
                    <input type="hidden" name="SSMCNM" id="SMCID" value="${SSMCNM}">
                    <input type="hidden" name="subItemType" value="MAKER"/>
                </span>
				    <div class="panel-heading"><h3 class="panel-title">SUB ITEM DETAILS - SR</h3></div>
				    <div class="panel-body" style="padding:0;border:0px;height:333px;overflow-y:auto;margin-top:6px">
                        		<div class="col-sm-9" style="width:981px"><h4 style="color:#4d20d8">SUB MAIN ITEM SUPPLY RATE MODULE</h4></div>
                                <div class="col-sm-9" style="width:981px"><br>
                                    <select class="form-control" name="subMainIemId" id="subMainIemId">
                                        <option value="0">SELECT SUB MAIN ITEM SIZE</option>
                                        <c:forEach var="subMainItemObj" items="${subMainItemList}" varStatus="mainItemStatus">
                                            <option value="${subMainItemObj.id}">${subMainItemObj.mainItem.shortDescription} - ${subMainItemObj.shortDescription}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-9" style="width:499px">
					<br><input type="text" placeholder="MK" id="subMainItemMakerName" name="subMainItemMakerName" class="form-control" autofocus>
				</div>
				<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-51px">
					<br><input type="text" placeholder="MR" id="subMainItemMakerRate" name="subMainItemMakerRate" class="form-control" autofocus>
				    <input type="hidden" name="itemType" value="MAKER"/>
				    <input type="hidden" name="mainItemId" value="${mainItemId}"/>
				</div>

                                <div class="clearfix" style="height: 10px;clear: both;"></div>
                                <div class="clearfix" style="height: 10px;clear: both;"></div>
                                <div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
                                    <br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="Add">
                                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-88px;width:129px;margin-left:-333px" value="Edit">
                                </div>
                    </div>
                </div>
            </div>
            </form>
       </div>
    </div>
</div>
</body>
</html>