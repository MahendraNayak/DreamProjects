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
        <c:if test="${not empty sucecssMessage}"><font color="green">${successMessage}</font></c:if>
        <c:if test="${not empty errorMessage}"><font color="red">${errorMessage}</font></c:if>
        <form commandName="form" id="form" method="POST" action="editorPannelMainItemIRAndSRAdd">
		    <div class="col-md-3 col-sm-6">
		        <div class="panel panel-default" style="width:1017px">
                <span>
                    <input type="hidden" name="SMCID" id="SMCID" value="${SMCID}">
                    <input type="hidden" name="SSMCID" id="SSMCID" value="${SSMCID}">
                    <input type="hidden" name="SMCNM" id="SMCID" value="${SMCNAME}">
                    <input type="hidden" name="SSMCNM" id="SMCID" value="${SSMCNAME}">
                </span>
				    <div class="panel-heading"><h3 class="panel-title">SUB ITEM DETAILS - SR</h3></div>
				    <div class="panel-body" style="padding:0;border:0px;height:333px;overflow-y:auto;margin-top:6px">
                        		<div class="col-sm-9" style="width:981px"><h4 style="color:#4d20d8">SUB MAIN ITEM SUPPLY RATE MODULE</h4></div>
                                <div class="col-sm-9" style="width:981px"><br>
                                    <select class="form-control" name="cityId" id="cityId">
                                        <option value="0">Select CITY</option>
                                        <c:forEach var="rateCityObj" items="${rateCityList}" varStatus="rateCityStatus">
                                            <option value="${rateCityObj.id}">${rateCityObj.city}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-9" style="width:981px"><br>
                                    <select class="form-control" name="shortDescription" id="shortDescription">
                                        <option value="0">SELECT SUB MAIN ITEM SD</option>
                                        <c:forEach var="mainItemObj" items="${mainItemList}" varStatus="mainItemStatus">
                                            <option value="${mainItemObj.shortDescription}">${mainItemObj.shortDescription}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-9" style="width:499px">
					<br><input type="text" placeholder="MK" id="makerName" name="makerName" class="form-control" autofocus>
				</div>
				<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-51px">
					<br><input type="text" placeholder="MR" id="makerPrice" name="makerPrice" class="form-control" autofocus>
				    <input type="hidden" name="itemType" value="MAKER"/>
				    <input type="hidden" name="mainItemId" value="${mainItemId}"/>
				</div>

                                <div class="clearfix" style="height: 10px;clear: both;"></div>
                                <div class="clearfix" style="height: 10px;clear: both;"></div>
                                <div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
                                    <br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="Add">
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