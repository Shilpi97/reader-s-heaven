<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page autoFlush="true" buffer="1094kb"%>
 <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.List" %>
    <%@page import="bean.library_joinBean" %>
    <%@page import="bean.bookBean" %>
    <!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>libraryApproval | Reader's Heaven</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="./css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="./css/owl.carousel.css">
    <link rel="stylesheet" href="./css/owl.theme.css">
    <link rel="stylesheet" href="./css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="./css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="./css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="./css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="./css/main.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="./css/morris./js/morris.css"> 
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="./css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="./css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="./css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="./css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="./css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="./css/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="./css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="./js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

   
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
        <div class="container-fluid">
            
        </div>
   <%@ include file="header.jsp"%>
    <div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                        <div class="breadcome-heading">
                            			<form role="search" class="">
                                                
                                            </form>               
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                        <ul class="breadcome-menu">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><span class="bread-blod">Library List</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
       <div class="product-status mg-tb-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap">
                            <h4>Library  List</h4>
                            
                            <table>
                                <tr>
                                    <th>Library Title</th>
                                    <th>Library Branch</th>
                                    <th>Setting</th>
                                </tr>
                         <%List<library_joinBean>b=(ArrayList)request.getAttribute("listOfLibrary");
							if(b==null){ %>
							 <jsp:forward page="/approveLibraryListServelt?action=libraryApproval.jsp" />
		 					<% }else{
		 						b=(ArrayList)request.getAttribute("listOfLibrary");%>
		 						
		 						<% 
		 						for(int i=0;i<b.size();i++)
								{
									library_joinBean book=b.get(i);
		 					
							%>
                                
                                <tr>
                                    
                                    <td><%= book.getLibrary_name() %></td>
                                    <td><%= book.getBranch_name() %></td>
                                    <td>
                                        <a href="./approveLibraryServelt?id=<%=book.getLibrary_address_id() %>"><button data-toggle="tooltip" title="Approve" class="pd-setting-ed"><i class="fa fa-check-square-o" aria-hidden="true"></i></button></a>
                                        <a href="./disapproveLibraryServelt?id=<%=book.getLibrary_address_id() %>"><button data-toggle="tooltip" title="Disapprove" class="pd-setting-ed"><i class="fa fa-times-circle" aria-hidden="true"></i></button></a>
                                    </td>
                                </tr>
                                <% }
		 						} %>
                                
                            </table>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
     	  
        <div class="calender-area mg-tb-30">
           
        </div>
        <div class="footer-copyright-area">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer-copy-right">
                            <p>Copyright by Reader's Heaven &copy; 2018 <a href="https://colorlib.com/wp/templates/"></a> .</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jquery
		============================================ -->
    <script src="./js/vendor/jquery-1.11.3.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="./js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="./js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="./js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="./js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="./js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="./js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="./js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="./js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="./js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="./js/metisMenu/metisMenu.min.js"></script>
    <script src="./js/metisMenu/metisMenu-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="./js/morris./js/raphael-min.js"></script>
    <script src="./js/morris./js/morris.js"></script>
    <script src="./js/morris./js/morris-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="./js/sparkline/jquery.sparkline.min.js"></script>
    <script src="./js/sparkline/jquery.charts-sparkline.js"></script>
    <!-- calendar JS
		============================================ -->
    <script src="./js/calendar/moment.min.js"></script>
    <script src="./js/calendar/fullcalendar.min.js"></script>
    <script src="./js/calendar/fullcalendar-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="./js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="./js/main.js"></script>
</body>

</html>