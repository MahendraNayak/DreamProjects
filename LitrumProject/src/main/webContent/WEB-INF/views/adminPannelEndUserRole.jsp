<%@include file="adminPannelHeader.jsp" %>
<body>
<div class="body-wrapper">
    <%@include file="adminPannelMenuBar.jsp" %>

    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
		<Marquee><b>Compant Type</b></Marquee>
            </div>
        </div>
        <div class="in-services">
		    <div id="row">
                <div class="col-md-3 col-sm-6" style="width:33%">
                    <div class="panel panel-default" style="width:332px">
                        <div class="panel-heading"><h3 class="panel-title">SERVICE OFFERED</h3></div>
                            <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto">
                                <table class="table">
                                    <tbody>
                                        <c:forEach var="serviceOfferedObj" items="${serviceOfferedList}" varStatus="status">
                                        <tr>
                                            <td style="font-size:16px;color:black;cursor:pointer" onclick="getCTBasedOnSO(${serviceOfferedObj.id},'END_ROLE')">
							                    <b><c:out value="${serviceOfferedObj.name}"/></b>
					                    </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6" style="width:33%">
                    <div class="panel panel-default" style="width:332px">
                        <div class="panel-heading"><h3 class="panel-title">COMPANY TYPE</h3></div>
                             <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto" id="CT_TABLE">

                             </div>
                    </div>
                </div>
            </div>
		<div class="col-md-3 col-sm-6" style="width:33%">
                    <div class="panel panel-default" style="width:332px">
                        <div class="panel-heading"><h3 class="panel-title">USER ROLE</h3></div>
                             <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto"  id="END_USER_ROLE_TABLE">
                             </div>
                    </div>
                </div>
            </div>

<div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
		</div>
<div class="row" >
            <div class="col-md-3 col-sm-6">
            <form role="form" id="form" method="POST" action="adminPannelEndUserRole">
                <div class="form-group" style="margin-left:382px">
		            <input type="hidden" id="userRoleId" name="userRoleId" value="0">
			        <input type="hidden" id="companyTypeId" name="companyTypeId" value="0">
                    <input type="text" id="userRoleName" name="userRoleName" placeholder="Add / Update UR" class="form-control" autocomplete="off" style="width:350px;height:35px">
                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:7px;width:138px" value="Add New UR" onclick="setZeroIDOnClick('userRoleId')">
                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-89px;width:129px;margin-left:143px" value="Update">
                </div>
            </form>
            </div>
         </div>
        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->
</body>