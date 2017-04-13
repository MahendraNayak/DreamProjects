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
		    <div class="col-md-3 col-sm-6">
		        <div class="panel panel-default" style="width:1017px">

				    <div class="panel-heading"><h3 class="panel-title">ITEM DETAILS - MAIN ITEM</h3></div>
				    <div class="panel-body" style="padding:0;border:0px;height:480px;overflow-y:auto;margin-top:6px">
                        		<%@include file="editorPannelCommonMainItemAdd.jsp" %>
                    </div>
                </div>
            </div>
       </div>
    </div>
</div>
</body>
</html>