<%@page import="util.TimeConvert"%>
<%@page import="entities.order.Order1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Books">
        <meta name="author" content="Shivangi Gupta">
        <title> Manage </title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/my.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

        <style>
            /*    --------------------------------------------------
            :: General
            -------------------------------------------------- */
            body {
                font-family: 'Open Sans', sans-serif;
                color: #353535;
            }
            .content h1 {
                text-align: center;
            }
            .content .content-footer p {
                color: #6d6d6d;
                font-size: 12px;
                text-align: center;
            }
            .content .content-footer p a {
                color: inherit;
                font-weight: bold;
            }

            /*	--------------------------------------------------
                :: Table Filter
                -------------------------------------------------- */
            .panel {
                border: 1px solid #ddd;
                background-color: #fcfcfc;
            }
            .panel .btn-group {
                margin: 15px 0 30px;
            }
            .panel .btn-group .btn {
                transition: background-color .3s ease;
            }
            .table-filter {
                background-color: #fff;
                border-bottom: 1px solid #eee;
            }
            .table-filter tbody tr:hover {
                cursor: pointer;
                background-color: #eee;
            }
            .table-filter tbody tr td {
                padding: 10px;
                vertical-align: middle;
                border-top-color: #eee;
            }
            .table-filter tbody tr.selected td {
                background-color: #eee;
            }
            .table-filter tr td:first-child {
                width: 38px;
            }
            .table-filter tr td:nth-child(2) {
                width: 35px;
            }
            .ckbox {
                position: relative;
            }
            .ckbox input[type="checkbox"] {
                opacity: 0;
            }
            .ckbox label {
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }
            .ckbox label:before {
                content: '';
                top: 1px;
                left: 0;
                width: 18px;
                height: 18px;
                display: block;
                position: absolute;
                border-radius: 2px;
                border: 1px solid #bbb;
                background-color: #fff;
            }
            .ckbox input[type="checkbox"]:checked + label:before {
                border-color: #2BBCDE;
                background-color: #2BBCDE;
            }
            .ckbox input[type="checkbox"]:checked + label:after {
                top: 3px;
                left: 3.5px;
                content: '\e013';
                color: #fff;
                font-size: 11px;
                font-family: 'Glyphicons Halflings';
                position: absolute;
            }
            .table-filter .star {
                color: #ccc;
                text-align: center;
                display: block;
            }
            .table-filter .star.star-checked {
                color: #F0AD4E;
            }
            .table-filter .star:hover {
                color: #ccc;
            }
            .table-filter .star.star-checked:hover {
                color: #F0AD4E;
            }
            .table-filter .media-photo {
                width: 200px;
                height: 250px;
            }
            .table-filter .media-body {
                display: block;
                /* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
            }
            .table-filter .media-meta {
                font-size: 17px;
                color: #999;
            }
            .table-filter .media .title {
                color: #2BBCDE;
                font-size: 23px;
                font-weight: bold;
                line-height: normal;
                margin: 0;
            }
            .table-filter .media .title span {
                font-size: .8em;
                margin-right: 20px;
            }
            .table-filter .media .title span.Success {
                color: #5cb85c;
            }
            .table-filter .media .title span.Delivering {
                color: #f0ad4e;
            }
            .table-filter .media .title span.Cancelled {
                color: #d9534f;
            }
            .table-filter .media .summary {
                font-size: 14px;
            }
        </style>
        <script>
            $(document).ready(function () {

                $('.star').on('click', function () {
                    $(this).toggleClass('star-checked');
                });

                $('.ckbox label').on('click', function () {
                    $(this).parents('tr').toggleClass('selected');
                });

                $('.btn-filter').on('click', function () {
                    var $target = $(this).data('target');
                    if ($target != 'all') {
                        $('.table tr').css('display', 'none');
                        $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
                    } else {
                        $('.table tr').css('display', 'none').fadeIn('slow');
                    }
                });

            });</script>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <!------ Include the above in your HEAD tag ---------->
        <%

            List<Order1> list = (List<Order1>) request.getSession().getAttribute("listOrders");
            List<Order1> list1 = (List<Order1>) request.getSession().getAttribute("listOrders1");
            List<Order1> list2 = (List<Order1>) request.getSession().getAttribute("listOrders2");
            List<Order1> list3 = (List<Order1>) request.getSession().getAttribute("listOrders3");


        %>
        <div class="container">
            <div class="row">

                <section class="content" style="width: 100%">
                    <h1>MANAGE YOUR ITEMS</h1>
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-success btn-filter" data-target="Success">Confirmed</button>
                                        <button type="button" class="btn btn-warning btn-filter" data-target="Delivering">Delivering</button>
                                        <button type="button" class="btn btn-danger btn-filter" data-target="Cancelled">Complete</button>
                                        <button type="button" class="btn btn-default btn-filter" data-target="all">All</button>
                                    </div>
                                </div>
                                <div class="table-container">
                                    <table class="table table-filter">
                                        <tbody>
                                            <tr data-status="Success">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox1">
                                                        <label for="checkbox1"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <%    
                                                        for (Order1 o : list1) {

                                                    %>
                                                    <div class="media">
                                                        <a href="#" class="pull-left">
                                                            <img src=<%=o.getCart().getCartProductList().get(0).getProductId().getImageLink()%> class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">Date Created: <%=TimeConvert.convertToString(o.getDateCreated())%></span>
                                                            <h4 class="title">
                                                                <%=o.getCart().getCartProductList().get(0).getProductId().getName()%>
                                                                <span class="pull-right Success">(Confirmed)</span>
                                                            </h4>
                                                            <br>
                                                            <p class="summary">
                                                                <b>PRICE:</b><%=o.getCart().getTotalPrice().toString()%><br>
                                                                <b>Shipping Address</b> <%=o.getShippingAddress()%><br><br>
                                                                Note: The data might be updated later than up to 3 hours
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <% 
                                        
                                                    };
                                        
                                        
                                                    %>
                                                </td>
                                            </tr>
                                            <tr data-status="Delivering">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox3">
                                                        <label for="checkbox3"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <td>
                                                    <%    
                                                        for (Order1 o : list2) {

                                                    %>
                                                    <div class="media">
                                                        <a href="#" class="pull-left">
                                                            <img src=<%=o.getCart().getCartProductList().get(0).getProductId().getImageLink()%> class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">Date Created: <%=TimeConvert.convertToString(o.getDateCreated())%></span>
                                                            <h4 class="title">
                                                                <%=o.getCart().getCartProductList().get(0).getProductId().getName()%>
                                                                <span class="pull-right Success">(Delivering)</span>
                                                            </h4>
                                                            <br>
                                                            <p class="summary">
                                                                <b>PRICE:</b><%=o.getCart().getTotalPrice().toString()%><br>
                                                                <b>Shipping Address</b> <%=o.getShippingAddress()%><br><br>
                                                                Note: The data might be updated later than up to 3 hours
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <% 
                                        
                                                    };
                                        
                                        
                                                    %>
                                                </td>
                                            </tr>
                                            <tr data-status="Cancelled">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox2">
                                                        <label for="checkbox2"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <td>
                                                    <%    
                                                        for (Order1 o : list3) {

                                                    %>
                                                    <div class="media">
                                                        <a href="#" class="pull-left">
                                                            <img src=<%=o.getCart().getCartProductList().get(0).getProductId().getImageLink()%> class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">Date Created: <%=TimeConvert.convertToString(o.getDateCreated())%></span>
                                                            <h4 class="title">
                                                                <%=o.getCart().getCartProductList().get(0).getProductId().getName()%>
                                                                <span class="pull-right Success">(Delivered)</span>
                                                            </h4>
                                                            <br>
                                                            <p class="summary">
                                                                <b>PRICE:</b><%=o.getCart().getTotalPrice().toString()%><br>
                                                                <b>Shipping Address</b> <%=o.getShippingAddress()%><br><br>
                                                                Note: The data might be updated later than up to 3 hours
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <% 
                                        
                                                    };
                                        
                                        
                                                    %>
                                                </td>
                                            </tr>
<!--                                            <tr data-status="Success" class="">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox4">
                                                        <label for="checkbox4"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <div class="media">
                                                        <a href="#" class="pull-left">
                                                            <img src="img/books/vnbook/4.jpg" class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                            <h4 class="title">
                                                                Lorem Impsum
                                                                <span class="pull-right Success">(Success)</span>
                                                            </h4>
                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr data-status="Delivering">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox5">
                                                        <label for="checkbox5"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <div class="media">
                                                        <a href="#" class="pull-left">
                                                            <img src="img/books/vnbook/4.jpg" class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">Febrero 13, 2016</span>
                                                            <h4 class="title">
                                                                Lorem Impsum
                                                                <span class="pull-right Delivering">(Delivering)</span>
                                                            </h4>
                                                            <p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>-->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="content-footer">
                            <p>
                                Hanoi, 2019 <br>
                                Powered By <b> TAKA TEAM </b>
                            </p>
                        </div>
                    </div>
                </section>

            </div>
        </div>
    </body>
</html>