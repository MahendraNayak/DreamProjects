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
        <div class="row">
		    <div class="col-md-3 col-sm-6">
		        <div class="panel panel-default" style="width:1017px">

				    <div class="panel-heading"><h3 class="panel-title">ITEM DETAILS - MAIN ITEM</h3></div>
				    <div class="panel-body" style="padding:0;border:0px;height:480px;overflow-y:auto;margin-top:6px">
                        		<%@include file="editorPannelCommonMainItemAdd.jsp" %>
                    </div>
                </div>
            </div>
         </div>
        <div class="row">
             <div class="col-md-4 col-sm-6">
                 <div class="panel panel-default">
                     <div class="panel-heading"><h3 class="panel-title">MAIN ITEMS</h3></div>
                         <div class="panel-body" style="padding:0;border:0px;height:335px;overflow-y:auto">
                             <table class="table">
                                 <tbody>
                                     <c:forEach var="mainItemObj" items="${mainItemList}" varStatus="status">
                                     <tr>
                                         <td style="font-size:16px;color:black;cursor:pointer">
                                            <b><c:out value="${mainItemObj.shortDescription}"/></b>
                                        </td>
                                     </tr>
                                     </c:forEach>
                                 </tbody>
                             </table>
                         </div>
                 </div>
             </div>
             <div class="col-md-4 col-sm-6">
                 <div class="panel panel-default" style="width: 641px">
                     <div class="panel-heading"><h3 class="panel-title">UPDATE MAIN ITEM DETAILS</h3></div>
                         <div class="panel-body" style="padding:0;border:0px;height:335px;overflow-y:auto">
                             <div class="col-sm-9" style="width:640px">
                    <br><textarea rows="2" cols="55" id="longDescription" name="shortDescription" placeholder="Short Description..." class="form-control"></textarea>
                    </div>
                    <div class="col-sm-9" style="width:640px">
                            <br><textarea rows="3" cols="55" id="longDescription" name="longDescription" placeholder="Short Description..." class="form-control"></textarea>
                    </div>
                    <div class="col-sm-9" style="width:640px"><br>
                        <select class="form-control" name="loadUnitId" id="unit">
                        <option value="0">Select Unit</option>
                        <c:forEach var="loadUnit" items="${loadUnitList}" varStatus="loadUnitId">
                            <option value="${loadUnit.id}">${loadUnit.unitName}</option>
                        </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-9" style="width:640px"><br>
                        <select class="form-control" name="subItemForMainItem" id="subItemForMainItem">
                        <option value="NO">SELECT SUB ITEM AVAILABLE</option>
                        <option value="YES">YES</option>
                        <option value="NO">NO</option>
                        </select>
                    </div>
                    </div>
                 </div>
              </div>
        </div>
       </div>
    </div>
</div>
</body>
</html>