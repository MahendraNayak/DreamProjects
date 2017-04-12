<%@include file="editorPannelHeader.jsp" %>

<body>

<div class="body-wrapper">
    <%@include file="editorPannelMenuBar.jsp" %>

    <div class="rightInfo landing-page-wrapper">
        <div class="padding-txt">
            <div class="col-xs-12 category-header">
		<Marquee><b>MAIN ITEM DATA MODULE</b></Marquee>
            </div>
        </div>
        <div class="in-services">
		    <div class="col-md-3 col-sm-6">
		        <div class="panel panel-default" style="width:1017px">

				<div class="panel-heading"><h3 class="panel-title">MAIN ITEM DATA MODULE</h3></div>
				<div class="panel-body" style="padding:0;border:0px;height:502px;overflow-y:auto;margin-top:6px">

<a onclick="showAddForm()" class="btn btn-default pull-left" style="margin-left:10px;margin-bottom:7px">ADD</a>
<a onclick="showItems()" class="btn btn-default pull-left" style="margin-left:10px;margin-bottom:7px">VIEW</a>
<div id="DISPLAY_ADD_FORM">
	<form role="form" id="form" method="POST" action="adminPannelUserReg">
		        <div class="panel panel-default" style="width:990px"><br><br><br>
                    <div class="panel-body" style="padding:0;border:0px;height:427px;width:992px">

                        <br>
			<div class="col-sm-9" style="width:981px">
				<textarea rows="2" cols="50" id="shortDesc" placeholder="Short Description..." class="form-control"></textarea>
			</div>
    			<div class="col-sm-9" style="width:981px">
				<br><textarea rows="4" cols="50" id="longDesc" placeholder="Long Description..." class="form-control"></textarea><br>
			</div>
			<div class="col-sm-9" style="width:499px">
				<label>Upload TS File</label>
				<br><input id="pdffile" name="file" type="file" /><br>
			</div>
    			<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-53px">
				<label>Upload IM File</label>
				<br><input id="imgfile" name="file" type="file" /><br>
			</div>
			<div class="col-sm-9" style="width:499px"><br>
			    <select class="form-control" name="unit" id="unit">
				    <option value="0">Select MI Unit</option>
		                    <option value="1">MT</option>
		                    <option value="2">KG</option>
		                    <option value="3">TONS</option>
		                    <option value="4">NOS</option>
                          </select>
			</div>
			<div class="col-sm-9" style="width:499px"><br>
			    <select class="form-control" name="SIAvail" id="SIAvail">
				    <option value="0">SELECT SUB ITEM AVAILABLE</option>
		                    <option value="1">YES</option>
		                    <option value="2">NO</option>
                          </select>
			</div>
			<div class="col-sm-9" style="width:499px;margin-left:482px;margin-top:-53px"><br>
			    <select class="form-control" name="sunit" id="sunit">
				    <option value="0">Select SMI Unit</option>
		                    <option value="1">MT</option>
		                    <option value="2">KG</option>
		                    <option value="3">TONS</option>
		                    <option value="4">NOS</option>
                          </select>
			</div>
			<div class="clearfix" style="height: 10px;clear: both;"></div><div class="clearfix" style="height: 10px;clear: both;"></div>
			<div class="col-sm-9" style="width:499px;margin-left:480px;margin-top:31px">
			    <br><input type="submit" class="btn btn-lg btn-success btn-block" style="margin-top:-56px;width:129px;margin-left:-480px" value="CREATE MAIN ITEM">
			</div>
                    </div>
		        </div>
	</form>
</div>

<div id="DISPLAY_TABLE">
	<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Item Number</th>
                <th>SD</th>
                <th>LD</th>
                <th>TS</th>
                <th>IM</th>
                <th>UN</th>
		<th>SUB ITEMS</th>
		<th>SUB ITEMS UN</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>SMC1</td>
                <td><textarea rows="2" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td>XXX.pdf</td>
                <td>XXX.jpeg</td>
                <td>KG</td>
                <td>YES</td>
                <td>KG</td>
            </tr>
	    <tr>
                <td>SMC2</td>
                <td><textarea rows="2" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td>XXX.pdf</td>
                <td>XXX.jpeg</td>
                <td>KG</td>
                <td>YES</td>
                <td>KG</td>
            </tr>
<tr>
                <td>SMC1</td>
                <td><textarea rows="2" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td>XXX.pdf</td>
                <td>XXX.jpeg</td>
                <td>KG</td>
                <td>YES</td>
                <td>KG</td>
            </tr>
	    <tr>
                <td>SMC2</td>
                <td><textarea rows="2" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td><textarea rows="4" cols="50" placeholder="Describe yourself here..."></textarea></td>
                <td>XXX.pdf</td>
                <td>XXX.jpeg</td>
                <td>KG</td>
                <td>YES</td>
                <td>KG</td>
            </tr>
        </tbody>
	</table>
</div>
</div>
</div>
</div>
</div>
</body>
</html>