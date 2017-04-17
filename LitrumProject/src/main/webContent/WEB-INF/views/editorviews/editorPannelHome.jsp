<%@include file="editorPannelHeader.jsp" %>

<body>
<div class="body-wrapper">
    <%@include file="editorPannelHomeMenuBar.jsp" %>
    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
		<Marquee><b>EDITOR DASHBOARD</b></Marquee>
            </div>
        </div>
        <div class="in-services">
		    <div id="row">
		    <div class="col-md-3 col-sm-6" style="width:33%">
		        <div class="panel panel-default" style="width:330px">
		        <div class="panel-heading"><h3 class="panel-title">USERS CATEGORY WISE</h3></div>
		        <div class="panel-body" style="padding:0;border:0px;height:460px;overflow-y:auto">
				<table class="table">
					<tbody>
					<c:forEach var="userRoleAndCountObj" items="${UserRoleAndCount}" varStatus="status">
						<tr>
						<td style="font-size:16px;color:black;cursor:pointer"><b><c:out value="${userRoleAndCountObj.key} ${userRoleAndCountObj.value}"/></b></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
		        </div>
		        </div>
		    </div>
            <div class="col-md-3 col-sm-6" style="width:33%">
		        <div class="panel panel-default" style="width:330px">
		        <div class="panel-heading"><h3 class="panel-title">ITEMS CATEGORY WISE</h3></div>
		        <div class="panel-body" style="padding:0;border:0px;height:460px;overflow-y:auto">
				<table class="table">
					<tbody>
					<c:forEach var="itemsCategoryObj" items="${mainItemList}" varStatus="status">
						<tr>
						<td style="font-size:16px;color:black;cursor:pointer"><b><c:out value="SMI${itemsCategoryObj.id}"/></b></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
		        </div>
		        </div>
		    </div>
		    <div class="col-md-3 col-sm-6" style="width:33%">
		        <div class="panel panel-default" style="width:330px">
		            <div class="panel-heading"><h3 class="panel-title">PENDING ITEMS Auth</h3></div>
		             <div class="panel-body" style="padding:0;border:0px;height:460px;overflow-y:auto">
				<table class="table">
					<tbody>
					<c:forEach var="pendingAuthObj" items="${pendingMainItemList}" varStatus="status">
						<tr>
						<td style="font-size:16px;color:black;cursor:pointer"><b><c:out value="SMI${pendingAuthObj.id}"/></b></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
		             </div>
		        </div>
		    </div>
        </div>
       </div>
    </div>
</div>
</body>
</html>