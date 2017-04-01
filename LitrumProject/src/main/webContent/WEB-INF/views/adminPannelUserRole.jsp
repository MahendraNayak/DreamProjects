<%@include file="adminPannelHeader.jsp" %>
<body>
<div class="body-wrapper">
    <%@include file="adminPannelMenuBar.jsp" %>

    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
		<Marquee><b>Admin User Role</b></Marquee>
            </div>
        </div>
        <div class="in-services">
		    <div class="col-md-3 col-sm-6">
		        <div class="panel panel-default">
				<div class="panel-heading"><h3 class="panel-title">ADMIN USER ROLE</h3></div>
				<div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto">

					<table class="table">
						<tbody>
						<c:forEach var="adminUserRole" items="${adminUserRoleList}" varStatus="status">
						<tr>
							<td style="font-size:16px;color:black;cursor:pointer" onclick="setAdminUserRoleID(${adminUserRole.id},'${adminUserRole.roleName}')"><b><c:out value="${adminUserRole.roleName}"/></b></td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
		    </div>
		</div>
        <div class="row" >
        <div class="col-md-3 col-sm-6">
        <form role="form" id="form" method="POST" action="adminPannelUserRole">
            <div class="form-group">
                <input type="hidden" id="userRoleId" name="userRoleId" value="0">
                <input type="text" id="userRoleName" name="userRoleName" placeholder="Add / Update UR" class="form-control" autocomplete="off" style="width:350px;height:35px">
                <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:7px;width:129px" value="Add New UR">
                <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-89px;width:129px;margin-left:143px" value="Update">
            </div>
        </form>
        </div>
        </div>

        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->
</body>