<%@include file="adminPannelHeader.jsp" %>
<body>
<div class="body-wrapper">
    <%@include file="adminPannelMenuBar.jsp" %>

    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
				<Marquee><b>Main Categories</b></Marquee>
            </div>
        </div>
        <div class="in-services">
        <div id="row">
		    <div class="col-md-3 col-sm-6">
				<form role="form" id="form" method="POST" action="adminPannelUserReg">
					<div class="panel panel-default" style="width:990px">
						<div class="panel-heading"><h3 class="panel-title">USER REGISTRATION</h3></div>
						<div class="panel-body" style="padding:0;border:0px;height:337px;width:992px">
							<br>
							<div class="col-sm-9" style="width:499px">
								<input type="text" id="firstName" name="firstName" placeholder="First Name" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-34px">
								<input type="text" id="lastName"  name="lastName" placeholder="Last Name" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:981px">
								<br><input type="text" id="userName" name="userName" placeholder="User Name" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:499px">
								<br><input type="password" placeholder="Your Password" id="password" name="password" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-34px">
								<input type="password" placeholder="Confirm Password" id="password1" name="password1" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:499px">
								<br><input type="text" placeholder="Your Email" id="emailId" name="emailId" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-34px">
								<input type="text" placeholder="Mobile Number" id="mobile" name="mobile" class="form-control" autofocus>
							</div>
							<div class="col-sm-9" style="width:499px"><br>
								<select class="form-control" name="mainCategoryId" id="mainCategoryId">
									<c:forEach var="maincatObj" items="${allMainCategoryList}" varStatus="status">
										<option value="${maincatObj.id}">${maincatObj.categoryName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-52px"><br>
								<select class="form-control" name="adminUserRoleId" id="adminUserRoleId">
									<c:forEach var="adminUserRoleObj" items="${adminUserRoleList}" varStatus="status">
										<option value="${adminUserRoleObj.id}">${adminUserRoleObj.roleName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
							<div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
								<br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="CREATE USER" onclick="return validateAdminUsrBeforefinalSubmit()">
							</div>
						</div>
					</div>
				</form>
			</div>

		</div> <!--Row End --><div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
<!-- Display Data Start -->
<div id="row">
<div class="col-md-3 col-sm-6">
	<div class="panel panel-default" style="width:990px">
		<div class="panel-heading"><h3 class="panel-title">REGISTERED USER LIST</h3></div>
		<div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto">
			<table class="table">
				<tbody>
					<tr>
                        <td style="font-size:16px;color:black"><b><c:out value="First Name"/></b></td>
					    <td style="font-size:16px;color:black"><b><c:out value="Last Name"/></b></td>
					    <td style="font-size:16px;color:black"><b><c:out value="User Name"/></b></td>
						<td style="font-size:16px;color:black"><b><c:out value="Mobile No"/></b></td>
						<td style="font-size:16px;color:black"><b><c:out value="Email ID"/></b></td>
						<td style="font-size:16px;color:black"><b><c:out value="Role"/></b></td>
						<td style="font-size:16px;color:black"><b><c:out value="Category"/></b></td>
                    </tr>
					<c:forEach var="userObj" items="${adminPannelRegisterUsers}" varStatus="status">
					<tr>
                         <td style="font-size:16px;color:black"><c:out value="${userObj.firstName}"/></td>
						<td style="font-size:16px;color:black"><c:out value="${userObj.lastName}"/></td>
						<td style="font-size:16px;color:black"><c:out value="${userObj.userName}"/></td>
						<td style="font-size:16px;color:black"><c:out value="${userObj.mobile}"/></td>
						<td style="font-size:16px;color:black"><c:out value="${userObj.emailId}"/></td>
						<td style="font-size:16px;color:black"><c:out value="${userObj.userLoginRole}"/></td>
						<td style="font-size:16px;color:black"><c:out value="${userObj.mainCategory.categoryName}"/></td>
                    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
<!-- Display Data End -->


        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->

<!-- Bootstrap Error modal -->
<div id="alert-modal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 id="alert-modal-title" class="modal-title"></h4>
			</div>
			<div id="alert-modal-body" class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default back2" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- End -->
</body>