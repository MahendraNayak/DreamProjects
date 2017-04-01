<%@include file="adminPannelHeader.jsp" %>
<body>
<div class="body-wrapper">
    <%@include file="adminPannelMenuBar.jsp" %>

    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
		<Marquee><b>Sub Main Categories</b></Marquee>
            </div>
        </div>
        <div class="in-services">
		    <div id="row">
                <div class="col-md-3 col-sm-6" style="width:33%">
                    <div class="panel panel-default" style="width:332px">
                        <div class="panel-heading"><h3 class="panel-title">MAIN CATEGORIES</h3></div>
                            <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto">
                                <table class="table">
                                    <tbody>
                                        <c:forEach var="maincatObj" items="${mainCategoryList}" varStatus="status">
                                        <tr>
                                            <td style="font-size:16px;color:black;cursor:pointer" onclick="getSMCBasedOnMC(${maincatObj.id},'SSMC')">
							                    <b><c:out value="${maincatObj.categoryName}"/></b>
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
                        <div class="panel-heading"><h3 class="panel-title">SUB MAIN CATEGORIES</h3></div>
                             <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto" id="SUB_MC_TABLE">
                             </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6" style="width:33%">
                    <div class="panel panel-default" style="width:332px">
                        <div class="panel-heading"><h3 class="panel-title">SUB SUB MAIN CATEGORIES</h3></div>
                             <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto"  id="SUB_SUB_MC_TABLE">
                             </div>
                    </div>
                </div>
            </div><div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
		</div>
	<div class="row" >
            <div class="col-md-3 col-sm-6">
            <form role="form" id="form" method="POST" action="adminPannelSubSubMainCat">
                <div class="form-group" style="margin-left:382px">
                    <input type="hidden" id="subMainCategoryId" name="subMainCategoryId" value="0">
		            <input type="hidden" id="subSubMainCategoryId" name="subSubMainCategoryId" value="0">
                    <input type="text" id="subSubMainCategoryName" name="subSubMainCategoryName" placeholder="Add / Update SSMC" class="form-control" autocomplete="off" style="width:355px;height:35px">
                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:7px;width:142px" value="Add New SSMC">
                    <input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-89px;width:129px;margin-left:143px" value="Update">
                </div>
            </form>
            </div>
         </div>
        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->
</body>