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
		    <div class="col-md-3 col-sm-6">
		    <form role="form" id="form" method="POST" action="adminPannelUserReg">
		        <div class="panel panel-default" style="width:990px">
                    <div class="panel-heading"><h3 class="panel-title">USER REGISTRATION</h3></div>
                    <div class="panel-body" style="padding:0;border:0px;height:337px;width:992px">

                        <br>
			<div class="col-sm-9" style="width:499px">
				<input type="text" id="firstName" placeholder="First Name" class="form-control" autofocus>
			</div>
    			<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-34px">
				<input type="text" id="lastName" placeholder="Last Name" class="form-control" autofocus>
			</div>
			<div class="col-sm-9" style="width:981px">
				<br><input type="text" id="fuserName" placeholder="User Name" class="form-control" autofocus>
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
			<input type="text" placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" class="form-control" autofocus>
			</div>
			<div class="col-sm-9" style="width:499px"><br>
			    <select class="form-control" name="MCID" id="MCID">
				<c:forEach var="maincatObj" items="${allMainCategoryList}" varStatus="status">
		                    <option id="${maincatObj.id}">${maincatObj.categoryName}</option>
				</c:forEach>
                          </select>
			</div>
			<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-52px"><br>
			    <select class="form-control" name="USER_ROLE" id="USER_ROLE">
				<c:forEach var="adminUserRoleObj" items="${adminUserRoleList}" varStatus="status">
		                    <option id="${adminUserRoleObj.id}">${adminUserRoleObj.roleName}</option>
				</c:forEach>
                          </select>
			</div>
			<div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
			<div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
			    <br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="CREATE USER">
			</div>
                    </div>
		        </div>
		    </form>
        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->
</body>