<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script language="JavaScript" type="text/JavaScript" src="resources/JS/bootstrap_3.3.4.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/bootstrap.min_3.3.4.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JS/custom.js"></script>
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
<script type="text/javascript">
$(document).ready(function() {
    $('#loginForm').bootstrapValidator({
        container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            uname: {
                validators: {
                    notEmpty: {
                        message: 'Please enter userName'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'please enter password'
                    }
                }
            }
        }
    });
});
</script>
</head>
<body>
<div id="container">
    <div id="header" class="headerLogo">
          <h1>Litrum Project - Data Manipulation</h1>
    </div>

    <div id="body">
        <div class="container">
                <c:if test="${not empty param.login_error}">
                    <div class="alert alert-danger fade in">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>Error!</strong> Username or password is incorrect.
                    </div>
              </c:if>
        <div class="row" style="margin-top:20px">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        		<form role="form" id="loginForm" method="post" action="j_spring_security_check">
        			<fieldset>
        				<h2>Please Sign In</h2>
        				<hr class="colorgraph">
        				<div class="form-group">
                            <input type="text" placeholder="User Name" id="uname" name="uname" class="form-control" autocomplete="off">
        				</div>
        				<div class="form-group">
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
        				</div>
        				<hr class="colorgraph">
        				<div class="row">
        					<div class="col-xs-6 col-sm-6 col-md-6">
                                <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
        					</div>
        					<div class="col-xs-6 col-sm-6 col-md-6">
        						<a href="register" class="btn btn-lg btn-primary btn-block">Register</a>
        					</div>
        				</div>
        			</fieldset>
        		</form>
        	</div>
        </div>

        </div>


</div>
<div id="footer" class="page-footer">
    </div>
</body>
</html>