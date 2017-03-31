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
                <div class="col-md-4 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 class="panel-title">SERVICE OFFERED</h3></div>
                            <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto">
                                <table class="table">
                                    <tbody>
                                        <c:forEach var="serviceOfferedObj" items="${serviceOfferedList}" varStatus="status">
                                        <tr>
                                            <td style="font-size:16px;color:black;cursor:pointer" onclick="getCTBasedOnSO(${serviceOfferedObj.id},'CT')">
							                    <b><c:out value="${serviceOfferedObj.name}"/></b>
					                    </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 class="panel-title">COMPANY TYPE</h3></div>
                             <div class="panel-body" style="padding:0;border:0px;height:300px;overflow-y:auto" id="CT_TABLE">

                             </div>
                    </div>
                </div>
            </div><div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
		</div>
        </div><!--in-services End -->
    </div><!-- rightInfo landing-page-wrapper End -->
</div><!-- body-wrapper End -->
</body>