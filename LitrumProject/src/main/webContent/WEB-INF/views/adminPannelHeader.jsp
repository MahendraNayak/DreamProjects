<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="resources/cssfinal/bootstrap3.1.0.min.css" type="text/css"></link>
<link rel="stylesheet" href="resources/cssfinal/checkbox.css" type="text/css"></link>
<link rel="stylesheet" href="resources/cssfinal/font-awesome.css" type="text/css"></link>
<link rel="stylesheet" href="resources/cssfinal/innerStyle.css" type="text/css"></link>
<link rel="stylesheet" href="resources/cssfinal/jquery.jscrollPannel.css" type="text/css"></link>
<link rel="stylesheet" href="resources/cssfinal/simplebar.css" type="text/css"></link>
<link rel="stylesheet" href="resources/cssfinal/custom.css" type="text/css"></link>

<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/Jquery.1.10.2.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/Jquery.1.10.2.min.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/jQueryUI.1.10.4.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/bootstrap3.2.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/ajaxSearch.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/jScrollablePannel.js"></script>
<script language="JavaScript" type="text/JavaScript" src="resources/JSfinal/custom.js"></script>

<script language="JavaScript" type="text/JavaScript">
$(document).ready(function (e) {
        $('.list-group li:first-child a').addClass('active');
		        $('.list-group-item-success a').click(function () {
            $(this).parent().siblings('li').children('a').removeClass('active');
            $(this).parent('li').children('a').addClass('active');
            var Id = $(this).next('div').attr('id');
            //alert(Id);
            var classtest = $(this).parent().siblings('li').children('div').attr('id');
            $(this).parent().siblings('li').children('div').removeClass('in');
        });
    });
</script>
<script language="JavaScript" type="text/JavaScript">
    //Used for header navigatiob
        $(document).ready(function() {
                var sideslider = $('[data-toggle=collapse-side]');
                var sel = sideslider.attr('data-target');
                var sel2 = sideslider.attr('data-target-2');
                sideslider.click(function(event){
                    $(sel).toggleClass('in');
                    $(sel2).toggleClass('out');
                });
            });
</script>
</head>