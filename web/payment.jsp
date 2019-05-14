<%--
  Created by IntelliJ IDEA.
  User: hailongluu
  Date: 5/8/2019
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
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
            #cart {margin-top:30px;margin-bottom:30px;}
            .panel {border:1px solid #10a3e8;padding-left:0px;padding-right:0px;}
            .panel-heading {background:#10a3e8 !important;color:white !important;}
            @media only screen and (width: 767px) { body{margin-top:150px;}}
            .modal-header {background:#10a3e8;color:#fff;font-weight:800;}
            .modal-body{font-weight:800;}
            .modal-body ul{list-style:none;}
            .modal .btn {background:#10a3e8;color:#fff;}
            .modal a{color:#10a3e8;}
            .modal-backdrop {position:inherit !important;}
            #login_button,#register_button{background:none;color:#10a3e8!important;}
            #query_button {position:fixed;right:0px;bottom:0px;padding:10px 80px;
                background-color:#10a3e8;color:#fff;border-color:#f05f40;border-radius:2px;}
            @media(max-width:767px){
                #query_button {padding: 5px 20px;}
            }
        </style>

    </head>
<body>
<div class="container">
    <form method="post" class="form" role="form" action="payment">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control"  placeholder="Your Name" name="sender" required>
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
                <option value="a">Hà Nội</option>
                <option value="b">TP HCM</option>
                <option value="c">Đà Nẵng</option>
            </select>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" placeholder="Your Address" name="address" required>
        </div>
        <div class="form-group">
            <label  for="phone">Phone Number</label>
            <input type="text" class="form-control" placeholder="Your Phone Number" name="phone" required>
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
</body>
</html>
