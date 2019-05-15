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
        <style>
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

    </head>
    <body>
        <%@ include file="header.jsp" %>
        <%
            Cart cart = (Cart) request.getAttribute("cart");
            ArrayList<CartProduct> listCartProducts = new ArrayList<>();
            listCartProducts.addAll(cart.getCartProductList());
            int removeIndex = -1;
        %>

        <div class="container-fluid" id="cart">
            <div class="row">
                <div class="col-12 text-center" id="heading">
                    <h2 style="color:#10a3e8;text-transform:uppercase;"> YOUR CART </h2>
                </div>
            </div>
            <div class="row">
                <%
                    int cartLength = listCartProducts.size();
                    if (cartLength > 0) {
                        for (int i = 0; i < cartLength; i++) {
                            Product p = listCartProducts.get(i).getProductId();
                            if (i % 3 == 0) { %>
                                <br>
                            <% } %>
                                <div class="panel col-xs-12 col-sm-4 offset-sm-0 col-md-4 offset-md-0 col-lg-4 offset-lg-0 text-center"
                                 style="color:#10a3e8;font-weight:800;">
                                <div class="panel-heading">Order 1</div>
                                <div class="panel-body">
                                    <img class="image-responsive block-center"
                                         src="<%=p.getImageLink()%>"
                                         style="height :100px;"/> <br>
                                    Name : <%=p.getName()%> <br>
                                    Code : <%=p.getId()%> <br>
                                    Quantity : <%=listCartProducts.get(i).getQuantity()%> <br>
                                    Price : <%=p.getPrice().toString()%> VND<br>
                                    Sub Total : <%=p.getPrice().multiply(new BigInteger(Integer.toString(listCartProducts.get(i).getQuantity()))).toString()%> VND<br>
                                    <a onClick="" class="btn btn-sm"
                                       style="background:#10a3e8;color:white;font-weight:800;">
                                        Remove
                                    </a>
                                </div>
                            </div>
                <%            
                        }
                    }
                %>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="panel col-4 offset-4 text-center" style="color:#10a3e8;font-weight:800;">
                    <div class="panel-heading">TOTAL</div>
                    <div class="panel-body"><%=cart.getTotalPrice()%> VND</div>
                </div>
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
    </body>
    <html>		