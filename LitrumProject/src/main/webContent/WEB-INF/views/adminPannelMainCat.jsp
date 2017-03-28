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
		        <div class="panel panel-default">
				<div class="panel-heading"><h3 class="panel-title">MAIN CATEGORIES</h3></div>
				<div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto">

					<table class="table">
						<tbody>
						<c:forEach var="maincatObj" items="${mainCategoryList}" varStatus="status">
						<tr>
							<td style="font-size:16px;color:black"><b><c:out value="${maincatObj.categoryName}"/></b></td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
		    </div>
		</div>
        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->
</body>