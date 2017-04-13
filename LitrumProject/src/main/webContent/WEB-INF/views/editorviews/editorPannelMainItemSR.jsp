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
				    <div class="panel-body" style="padding:0;border:0px;height:333px;overflow-y:auto;margin-top:6px">
                        		<div class="col-sm-9" style="width:981px"><h4 style="color:#4d20d8">MAIN ITEM SUPPLY RATE MODULE</h4></div>
                                <div class="col-sm-9" style="width:981px"><br>
                                    <select class="form-control" name="unit" id="unit">
                                        <option value="0">Select CITY</option>
                                        <option value="1">MUMBAI</option>
                                        <option value="2">PUNE</option>
                                    </select>
                                </div>
                                <div class="col-sm-9" style="width:981px"><br>
                                    <select class="form-control" name="unit" id="unit">
                                        <option value="0">SELECT MAIN ITEM SD</option>
                                        <option value="1">ITEM 1 XXX</option>
                                        <option value="2">ITEM 2 XXX</option>
                                    </select>
                                </div>
                                <div class="col-sm-9" style="width:499px">
					<br><input type="text" placeholder="MK" id="makerName" name="makerName" class="form-control" autofocus>
				</div>
				<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-51px">
					<br><input type="text" placeholder="MP" id="makerPriority" name="makerPriority" class="form-control" autofocus>
				</div>
				<div class="col-sm-9" style="width:981px"><h4 style="color:#4d20d8">MAIN ITEM SUPPLY RATE INPUT MODULE</h4></div>
				<div class="col-sm-9" style="width:499px">
					<select class="form-control" name="unit" id="unit">
						<option value="0">Select MI Unit</option>
						<option value="1">MT</option>
						<option value="2">KG</option>
						<option value="3">TONS</option>
						<option value="4">NOS</option>
					    </select>
				</div>
				<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-51px">
					<br><input type="text" placeholder="MR" id="makerRT" name="makerRT" class="form-control" autofocus>
				</div>

                                <div class="clearfix" style="height: 10px;clear: both;"></div>
                                <div class="clearfix" style="height: 10px;clear: both;"></div>
                                <div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
                                    <br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="Add">
                                </div>
                    </div>
                </div>
            </div>
       </div>
    </div>
</div>
</body>
</html>