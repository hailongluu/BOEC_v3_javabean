<%@page import="entities.order.Cart"%>
<%@page import="java.math.BigInteger"%>
<%@page import="entities.product.Product"%>
<%@page import="entities.order.CartProduct"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Cart">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/favicon.ico" type="image/x-icon">
        <meta name="author" content="Shivangi Gupta">
        <title>order</title>
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

            #cart {
                margin-top: 30px;
                margin-bottom: 30px;
            }

            .panel {
                border: 1px solid #10a3e8;
                padding-left: 0px;
                padding-right: 0px;
            }

            .panel-heading {
                background: #10a3e8 !important;
                color: white !important;
            }

            @media only screen and (width: 767px) {
                body {
                    margin-top: 150px;
                }
            }

            .modal-header {
                background: #10a3e8;
                color: #fff;
                font-weight: 800;
            }

            .modal-body {
                font-weight: 800;
            }

            .modal-body ul {
                list-style: none;
            }

            .modal .btn {
                background: #10a3e8;
                color: #fff;
            }

            .modal a {
                color: #10a3e8;
            }

            .modal-backdrop {
                position: inherit !important;
            }

            #login_button, #register_button {
                background: none;
                color: #10a3e8 !important;
            }

            #query_button {
                position: fixed;
                right: 0px;
                bottom: 0px;
                padding: 10px 80px;
                background-color: #10a3e8;
                color: #fff;
                border-color: #f05f40;
                border-radius: 2px;
            }

            @media (max-width: 767px) {
                #query_button {
                    padding: 5px 20px;
                }
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
        <%
            Cart cart = (Cart) request.getAttribute("cart");
            ArrayList<CartProduct> listCartProducts = new ArrayList<>();
            listCartProducts.addAll(cart.getCartProductList());
            int removeIndex = -1;
        %>

        <div class="container">
            <div class="row">

                <section class="content" style="width: 100%">
                    <h1>MANAGE CART</h1>
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-success btn-filter" data-target="Books">Books</button>
                                        <button type="button" class="btn btn-warning btn-filter" data-target="Clothes">Clothes</button>
                                        <button type="button" class="btn btn-danger btn-filter" data-target="Electronics">Electronics</button>
                                        <button type="button" class="btn btn-default btn-filter" data-target="all">All</button>
                                    </div>
                                </div>
                                <div class="table-container">
                                    <table class="table table-filter">
                                        <tbody>
                                        <%
                                            for (int i = 0; i < listCartProducts.size(); i++) {
                                                Product product = listCartProducts.get(i).getProductId();
                                                String id = product.getId();
                                                String dataStatus = "";
                                                switch (id.charAt(0)) {
                                                    case 'E':
                                                        dataStatus = "Clothes";
                                                        break;
                                                    case 'C':
                                                        dataStatus = "Electronics";
                                                        break;
                                                    case 'B':
                                                        dataStatus = "Books";
                                                        break;
                                                }
                                        %>
                                                <tr data-status=<%=dataStatus%>>
                                                    <!--<td>
                                                        <div class="ckbox">
                                                            <input type="checkbox" id="checkbox1">
                                                            <label for="checkbox1"></label>
                                                        </div>
                                                    </td>-->
<!--                                                    <td>
                                                        <a href="javascript:;" class="star">
                                                            <i class="glyphicon glyphicon-star"></i>
                                                        </a>
                                                    </td>-->
                                                    <td>
                                                        <div class="media">
                                                            <a href="#" class="pull-left">
                                                                <img src=<%=product.getImageLink()%> class="media-photo">
                                                            </a>
                                                            <div class="media-body">
                                                                <span type="button" onClick="btnRemoveClick(this)" class="pull-right btn btn-danger" style="text-decoration: none;" value="<%= i %>">X</span>
                                                                <h4 class="title">
                                                                    <%=product.getName()%>
                                                                    <!--<span class="pull-right Success">(Success)</span>-->
                                                                </h4>
                                                                <br>
                                                                <p class="summary">
                                                                    <b>PRICE:</b> <%=product.getPrice()%><br>
                                                                    <b>QUANTITY:</b> <%= listCartProducts.get(i).getQuantity() %><br><br>
                                                                    <!--Note: The data might be updated later than up to 3 hours-->
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                        <%
                                            }
                                        %>
                                        
                                        </tbody>
                                    </table>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="panel col-4 offset-4 text-center" style="color:#10a3e8;font-weight:800;">
                                            <div class="panel-heading">TOTAL</div>
                                            <div class="panel-body"><%=cart.getTotalPrice()%> VND</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        
        
        <br> <br>
        <div class="row">
            <div class="col-xs-8 offset-xs-2  col-sm-4 offset-sm-2 col-md-4 offset-md-3 col-lg-4 offset-lg-3">
                <a href=<%=request.getContextPath()+"/home"%> class="btn btn-lg" style="background:#10a3e8;color:white;font-weight:800;">Continue
                    Shopping</a>
            </div>
            <div class="col-xs-6 offset-xs-3 col-sm-4 offset-sm-2 col-md-4 offset-md-1 col-lg-4 ">
                <a class="btn btn-lg" style="background:#10a3e8;color:white;font-weight:800;margin-top:5px;"
                   href=<%=request.getContextPath()+"/makeorder"%> >Make Order</a>
            </div>
        </div>

  


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script>
            function btnRemoveClick(btn) {
            }
        </script>
    </body>
    <html>		
