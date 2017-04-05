<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/custom.js"></script>
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
                    <div id="sf1" class="frm" id="FIRST_DIV">
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
                                    <button class="btn btn-primary open1" type="button" id="FIRST_NEXT" onclick="validateBeforeFirstNext()">Next <span class="fa fa-arrow-right"></span></button>
                                </div>
                            </div>
                      </fieldset>
                    </div>
                    <div id="sf2" class="frm" style="display: none;" id="SECOND_DIV">
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
                            <button class="btn btn-warning back2" type="button" id="FIRST_PREV"><span class="fa fa-arrow-left"></span> Back</button>
                            <button class="btn btn-primary open2" type="button" onclick="validateBeforeSecondNext()">Next <span class="fa fa-arrow-right"></span></button>
                          </div>
                        </div>
                      </fieldset>
                    </div>

                    <div id="sf3" class="frm" style="display: none;" id="THIRD_DIV">
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
                          <c:forEach var="companyCityListObj" items="${companyCityList}" varStatus="status">
                            <option value="${companyCityListObj.id}">${companyCityListObj.cityName}</option>
                          </c:forEach>
                          </select>
                      </div>
                    </div>
                    <div class="clearfix" style="height: 10px;clear: both;"></div>
                    <div class="form-group">
                       <div class="col-lg-6">
                          <select class="form-control" name="serviceOffered" id="serviceOffered" onChange="getCompanyTypeBasedOnSO(this.value)">
                             <option value="0">Select Service Offered</option>
                             <c:forEach var="serviceOfferedListObj" items="${serviceOfferedList}" varStatus="status">
                                <option value="${serviceOfferedListObj.id}">${serviceOfferedListObj.name}</option>
                              </c:forEach>
                          </select>
                      </div>
                    </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                      <div class="form-group">
                         <div class="col-lg-6" id="COMP_TYPE">
                            <select class="form-control" name="companyType" id="companyType">
                                <option value="0">Select Company Type</option>
                            </select>
                          </div>
                       </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                         <div class="col-lg-6" id="USR_ROLE">
                            <select class="form-control" name="endUserRole" id="endUserRole">
                              <option value="0">Select Role</option>
                            </select>
                          </div>
                       </div>
                        <div class="clearfix" style="height: 10px;clear: both;"></div>
                        <div class="form-group">
                          <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-warning back3" type="button"><span class="fa fa-arrow-left"></span> Back</button>
                            <button type="submit" value="Submit" class="btn btn-success" onclick="return validateBeforefinalSubmit()">Submit</button>
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
        <span style="display:none" id="BACK_2"><button type="button" class="btn btn-default back2" data-dismiss="modal">Close</button></span>
	<span style="display:none" id="BACK_3"><button type="button" class="btn btn-default back3" data-dismiss="modal">Close</button></span>
	<span style="display:none" id="F_SUBMIT"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></span>
      </div>
    </div>
  </div>
</div>
<!-- End -->
<div id="footer" class="page-footer">
    </div>
</body>
</html>