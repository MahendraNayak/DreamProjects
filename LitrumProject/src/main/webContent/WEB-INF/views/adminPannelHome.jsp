<html>
<head>
<link rel="stylesheet" href="./styles/bootstrap-modal.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-modal-bs3patch.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap.min.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-responsive.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-responsive.min.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-grid.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-grid.min.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-reboot.css" type="text/css"></link>
<link rel="stylesheet" href="./styles/bootstrap-reboot.min.css" type="text/css"></link>

<link rel="stylesheet" href="./styles/custom.css" type="text/css"></link>


<script language="JavaScript" type="text/JavaScript" src="./JS/jquery-1.9.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="./JS/bootstrap.js"></script>
<script language="JavaScript" type="text/JavaScript" src="./JS/bootstrap.min.js"></script>
<script language="JavaScript" type="text/JavaScript" src="./JS/bootstrap-modal.js"></script>
<script language="JavaScript" type="text/JavaScript" src="./JS/bootstrap-modalmanager.js"></script>
<script language="JavaScript" type="text/JavaScript" src="./JS/custom.js"></script>
</head>
<body>


<!-- Modal -->


                        <div id="responsive" class="modal hide fade" tabindex="-1" data-width="500" data-height="800">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h3>Responsive</h3>
                          </div>
                          <div class="modal-body">
                            <div class="row-fluid">
                              <div class="span6">
                                <h4>Some Input</h4>
                                <p><input type="text" class="span12"></p>
                              </div>
                            </div>
                          </div>
                          <div class="modal-footer">
                            <button type="button" data-dismiss="modal" class="btn">Close</button>
                          </div>
                        </div>

                                <!-- Modal -->

    <div id="container">




        <div id="header" class="headerLogo">
              <h1>Litrum Project - Data Manipulation</h1>
        </div>



        <div class="row">
            <!-- uncomment code for absolute positioning tweek see top comment in css -->
            <!-- <div class="absolute-wrapper"> </div> -->
            <!-- Menu -->
            <div class="side-menu">

            <!--  deleted navigTION -->

                    <!-- Main Menu -->
                    <div class="side-menu-container">
                        <ul class="nav navbar-nav" style="width: 300px; height: 380px; overflow: auto">
                            <li style="background-color: Gainsboro"><a href="adminPannelHome.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Home Page</h4></span></a></li>
                            <li style="background-color: Beige"><a href="adminPannelMainCat.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Main Category(MC)</h4></span></a></li>
                            <li style="background-color: Gainsboro"><a href="adminPannelSubMainCat.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Sub Main Category(SMC)</h4></span></a></li>
                            <li style="background-color: Beige"><a href="adminPannelSubSubMainCat.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Sub Sub Main Category(SSMC)</h4></span></a></li>
                            <li style="background-color: Gainsboro"><a href="adminPannelComType.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Company Type</h4></span></a></li>
                            <li style="background-color: Beige"><a href="adminPannelUserRole.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>User Role</h4></span></a></li>
                            <li style="background-color: Gainsboro"><a href="adminPannelAuth.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>User and Category Authorization</h4></span></a></li>
                            <li style="background-color: Beige"><a href="adminPannelComReg.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Company Registration</h4></span></a></li>
                            <li style="background-color: Gainsboro"><a href="adminPannelProductMaster.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>Product Master</h4></span></a></li>
                            <li style="background-color: Beige"><a href="adminPannelAddUserAndRole.jsp"><span style="color:#FF0000;text-shadow: 1px 1px black;"><h4>New User And Role</h4></span></a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
               <!--  DELETED NAVIGATION END -->
            </div>

            <!-- Main Content -->

            <div class="side-body">
                <div class="container bootstrap snippet">
                    <div class="row">
                        <div class="col-lg-3 col-sm-6">
                            <div class="circle-tile ">
                                <div class="circle-tile-heading dark-blue">
                                    <i class="fa fa-users fa-fw fa-3x"></i>
                                    <img src="./images/userIcon.jpg" style='height: 100%; width: 100%; object-fit: contain'>
                                </div>
                                <div class="circle-tile-content dark-blue">
                                    <div class="circle-tile-description text-faded"> Users</div>
                                    <div class="circle-tile-number text-faded ">265</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="circle-tile ">
                                <div class="circle-tile-heading green">
                                    <i class="fa fa-users fa-fw fa-3x"></i>
                                    <img src="./images/itemsIcon.jpg" style='height: 100%; width: 100%; object-fit: contain'>
                                </div>
                                <div class="circle-tile-content green">
                                    <div class="circle-tile-description text-faded"> Items</div>
                                    <div class="circle-tile-number text-faded ">1000</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="circle-tile ">
                                <div class="circle-tile-heading purple">
                                    <i class="fa fa-users fa-fw fa-3x"></i>
                                    <img src="./images/downloadIcon.png" style='height: 100%; width: 100%; object-fit: contain'>
                                </div>
                                <div class="circle-tile-content purple">
                                    <div class="circle-tile-description text-faded"> BOQ Download</div>
                                    <div class="circle-tile-number text-faded ">561</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- -->
                                        <div class="row">
                                            <div class="col-lg-3 col-sm-6">
                                                <div class="circle-tile ">
                                                    <div class="circle-tile-heading dark-blue">
                                                        <i class="fa fa-users fa-fw fa-3x"></i>
                                                        <img src="./images/userIcon.jpg" style='height: 100%; width: 100%; object-fit: contain'>
                                                    </div>
                                                    <div class="circle-tile-content dark-blue">
                                                        <button class="demo btn btn-primary btn-lg" data-toggle="modal" href="#responsive">View Users Categorywise</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-3 col-sm-6">
                                                <div class="circle-tile ">
                                                    <div class="circle-tile-heading green">
                                                        <i class="fa fa-users fa-fw fa-3x"></i>
                                                        <img src="./images/itemsIcon.jpg" style='height: 100%; width: 100%; object-fit: contain'>
                                                    </div>
                                                    <div class="circle-tile-content green">
                                                        <button class="demo btn btn-primary btn-lg" data-toggle="modal" href="#responsive">View Items Categorywise</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-3 col-sm-6">
                                                <div class="circle-tile ">
                                                    <div class="circle-tile-heading purple">
                                                        <i class="fa fa-users fa-fw fa-3x"></i>
                                                        <img src="./images/authIcon.jpg" style='height: 100%; width: 100%; object-fit: contain'>
                                                    </div>
                                                    <div class="circle-tile-content purple">
                                                        <button class="demo btn btn-primary btn-lg" data-toggle="modal" href="#responsive">Pending Authorization</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                    <!-- -->
                </div>
            </div>
        </div>

        <div id="footer" class="page-footer">
            <h1>Footer Description</h1>
        </div>
    </div>

</body>
</html>