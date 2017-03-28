<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="resources/styles/jquery.ui.1.9.2.ie.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/jquery.ui.1.10.0.ie.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/jquery-ui-1.9.2.custom.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/jquery-ui-1.10.0.custom.css" type="text/css"></link>
<ink rel="stylesheet" href="resources/styles/bootstrap_3.3.4.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/bootstrap.min_3.3.4.css" type="text/css"></link>
<ink rel="stylesheet" href="resources/styles/bootstrap-theme_3.3.4.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/bootstrap-theme.min_3.3.4.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/bootstrap-grid.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/bootstrap-grid.min.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/bootstrap-reboot.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/bootstrap-reboot.min.css" type="text/css"></link>
<link rel="stylesheet" href="resources/styles/custom.css" type="text/css"></link>

<script language="JavaScript" type="text/JavaScript" src="resources/JS/jquery-3.2.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/affix.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/alert.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/button.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/carousel.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/collapse.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/dropdown.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/modal.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/scrollspy.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/tab.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/tooltip.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/transition.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/custom.js"></script>

<script language="JavaScript" type="text/JavaScript" src="resources/JS/bootstrap_3.3.4.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/bootstrap.min_3.3.4.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/custom.js"></script>
</head>
<body>
<div id="container">
    <div id="header" class="headerLogo">
          <h1>Litrum Project - Data Manipulation</h1>
    </div>

    <div id="body">
        <div class="container" style="padding-left: 0px; padding-right: 15px;">
              <div class="panel panel-primary">
                <div class="panel-heading">
                  <h3 class="panel-title">Complete registration in quick 3 steps!</h3>
                </div>
                <div class="panel-body">
                  <form name="form" id="form" method="post" action="register">
                    <div id="sf1" class="frm">
                      <fieldset>
                        <legend>Step 1 of 3</legend>
                        <div class="form-group">
                            <div class="col-lg-6">
                                <input type="text" placeholder="First Name" id="firstName" name="firstName" class="form-control" autocomplete="off">
                            </div>
                            </div>
                            <div class="clearfix" style="height: 10px;clear: both;"></div>
                            <div class="form-group">
                                <div class="col-lg-6">
                                    <input type="text" placeholder="Last Name" id="lastName" name="lastName" class="form-control" autocomplete="off">
                                </div>
                            </div>

                            <div class="clearfix" style="height: 10px;clear: both;"></div>
                            <div class="form-group">
                                <div class="col-lg-6">
                                    <input type="text" placeholder="User Name" id="userName" name="userName" class="form-control" autocomplete="off">
                                 </div>
                            </div>
                            <div class="clearfix" style="height: 10px;clear: both;"></div>
                            <div class="clearfix" style="height: 10px;clear: both;"></div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button class="btn btn-primary open1" type="button">Next <span class="fa fa-arrow-right"></span></button>
                                </div>
                            </div>
                      </fieldset>
                    </div>
                    <div id="sf2" class="frm" style="display: none;">
                      <fieldset>
                        <legend>Step 2 of 3</legend>
                        <div class="form-group">
                          <div class="col-lg-6">
                            <input type="password" placeholder="Your Password" id="password" name="password" class="form-control" autocomplete="off">
                          </div>
                        </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                          <div class="col-lg-6">
                            <input type="password" placeholder="Confirm Password" id="password1" name="password1" class="form-control" autocomplete="off">
                          </div>
                        </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                          <div class="col-lg-6">
                            <input type="text" placeholder="Your Email" id="emailId" name="emailId" class="form-control" autocomplete="off">
                          </div>
                        </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                          <div class="col-lg-6">
                            <input type="text" placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" class="form-control" autocomplete="off">
                          </div>
                        </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                          <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-warning back2" type="button"><span class="fa fa-arrow-left"></span> Back</button>
                            <button class="btn btn-primary open2" type="button">Next <span class="fa fa-arrow-right"></span></button>
                          </div>
                        </div>
                      </fieldset>
                    </div>

                    <div id="sf3" class="frm" style="display: none;">
                      <fieldset>
                        <legend>Step 3 of 3</legend>
                        <div class="form-group">
                          <div class="col-lg-6">
                            <input type="text" placeholder="Company Name" id="companyName" name="companyName" class="form-control" autocomplete="off">
                          </div>
                        </div>
                    <div class="clearfix" style="height: 10px;clear: both;"></div>
                    <div class="form-group">
                       <div class="col-lg-6">
                          <select class="form-control" name="companyCity" id="companyCity">
                            <option>Select Current City</option>
                            <option>Mumbai</option>
                            <option>Pune</option>
                          </select>
                      </div>
                    </div>
                    <div class="clearfix" style="height: 10px;clear: both;"></div>
                    <div class="form-group">
                       <div class="col-lg-6">
                          <select class="form-control" name="serviceOffered" id="serviceOffered">
                            <option>Select Service Offered</option>
                            <option>DD</option>
                            <option>CO</option>
                            <option>SM</option>
                          </select>
                      </div>
                    </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                      <div class="form-group">
                         <div class="col-lg-6">
                            <select class="form-control" name="companyType" id="companyType">
                              <option>Select Company Type</option>
                              <option>CO_CT 1</option>
                              <option>SM_CT 1</option>
                              <option>SM_CT 2</option>
                              <option>DD_CT 1</option>
                            </select>
                          </div>
                       </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                         <div class="col-lg-6">
                            <select class="form-control" name="endUserRole" id="endUserRole">
                              <option>Select Role</option>
                              <option>SM_CT1_UR1</option>
                              <option>CO_CT1_UR1</option>
                              <option>DD_CT1_UR2</option>
                              <option>DD_CT1_UR1</option>
                            </select>
                          </div>
                       </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                          <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-warning back3" type="button"><span class="fa fa-arrow-left"></span> Back</button>
                            <button type="submit" value="Submit" class="btn btn-success">Submit</button>
                          </div>
                        </div>
                      </fieldset>
                    </div>
                  </form>
                </div>
              </div>
            </div>
    </div>


</div>
<div id="footer" class="page-footer">
    </div>
</body>
</html>