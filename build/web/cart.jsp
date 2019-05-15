<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="group.faf.bookstore.model.product.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="group.faf.bookstore.model.order.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="group.faf.bookstore.model.product.book.Book" %>
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
    Cart cart = (Cart) session.getAttribute("cart");
    Map<Product, Integer> products = cart.getProducts();
    List<Product> listProducts = new ArrayList<>();
    List<Integer> listQuantity = new ArrayList<>();
    for (Product p : products.keySet())
        listProducts.add(p);
    for (int quantity : products.values())
        listQuantity.add(quantity);
%>

    <div class="container-fluid" id="cart">
        <div class="row">
            <div class="col-12 text-center" id="heading">
                <h2 style="color:#10a3e8;text-transform:uppercase;"> YOUR CART </h2>
            </div>
        </div>
        <div class="row">
            <c:set var="cartLength" value="<%=cart.getProducts().size()%>"/>
            <c:if test ="${cartLength > 0}">
                <c:forEach var="index" begin="0" end="<%=cart.getProducts().size() - 1%>">
                    <%
                        int i = (Integer) pageContext.getAttribute("index");
                        Product p = listProducts.get(i);
                    %>
                    <c:if test="${index mod 3 == 0}">
                        <br>
                    </c:if>
                    <div class="panel col-xs-12 col-sm-4 offset-sm-0 col-md-4 offset-md-0 col-lg-4 offset-lg-0 text-center"
                         style="color:#10a3e8;font-weight:800;">
                        <div class="panel-heading">Order 1</div>
                        <div class="panel-body">
                            <img class="image-responsive block-center"
                                 src="<%=p.getImageLink()%>"
                                         style="height :100px;"/> <br>
                            Title : <%=p.getName()%> <br>
                            Code : <%=p.getId()%> <br>
                            <c:set var="className" value="<%=p.getClass().getSimpleName()%>"/>
                            <c:if test="${className == 'Book'}">
                                <%
                                    Book book = (Book) p;
                                %>
                                Author : <%=book.getAuthor()%> <br>
                                Edition : 6th <br>
                            </c:if>
                            Quantity : <%=listQuantity.get(i)%> <br>
                            Price : <%=p.getPrice()%> VND<br>
                            Sub Total : <%=p.getPrice() * listQuantity.get(i)%> VND<br>
                            <a href="cart.jsp?remove='.$row['PID'].'" class="btn btn-sm"
                               style="background:#10a3e8;color:white;font-weight:800;">
                                Remove
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
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
            <a href="/home" class="btn btn-lg" style="background:#10a3e8;color:white;font-weight:800;">Continue
                Shopping</a>
        </div>
        <div class="col-xs-6 offset-xs-3 col-sm-4 offset-sm-2 col-md-4 offset-md-1 col-lg-4 ">
            <a class="btn btn-lg" style="background:#10a3e8;color:white;font-weight:800;margin-top:5px;"
               class="btn btn-lg" data-toggle="modal" data-target="#query">Make Order</a>
        </div>
    </div>

    <div class="container">
        <!-- Modal -->
        <div class="modal fade" id="query" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title">Purchase Cart</h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" class="form" role="form">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" placeholder="Your Name" name="sender" required>
                            </div>
                            <div class="form-group">
                                <label for="city">City</label>
                                <select name="city" class="form-control">
                                    <option value="hanoi">Hanoi</option>
                                    <option value="danang">Danang</option>
                                    <option value="hCM">HCM</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="province">Province</label>
                                <select name="province" class="form-control">
                                    <option value="a">A</option>
                                    <option value="b">B</option>
                                    <option value="c">C</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" placeholder="Your Address" name="address"
                                       required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone Number</label>
                                <input type="text" class="form-control" placeholder="Your Phone Number" name="phone"
                                       required>
                            </div>
                            <div class="form-group">
                                <label for="shipment">Shipment method</label>
                                <select name="shipment" class="form-control">
                                    <option value="fast">Fast</option>
                                    <option value="normal">Normal</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="payment">Payment method</label>
                                <select name="payment" class="form-control">
                                    <option value="cash">Cash</option>
                                    <option value="visa">Visa Card</option>
                                    <option value="member">BookStore Member Card</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="submit" value="confirm" class="btn btn-block">
                                    Confirm
                                </button>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
<html>		