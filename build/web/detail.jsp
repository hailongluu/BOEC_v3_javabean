<%@page import="entities.product.Product"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Books">
    <meta name="author" content="Shivangi Gupta">
    <title> Online Bookstore</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/my.css" rel="stylesheet">

    <style>
        @media only screen and (width: 768px) {
            body {
                margin-top: 150px;
            }
        }

        @media only screen and (max-width: 760px) {
            #books .row {
                margin-top: 10px;
            }
        }

        .tag {
            display: inline;
            float: left;
            padding: 2px 5px;
            width: auto;
            background: #F5A623;
            color: #fff;
            height: 23px;
        }

        .tag-side {
            display: inline;
            float: left;
        }

        #books {
            border: 1px solid #DEEAEE;
            margin-bottom: 20px;
            padding-top: 30px;
            padding-bottom: 20px;
            background: #fff;
        }

        #description {
            border: 1px solid #DEEAEE;
            margin-bottom: 20px;
            padding: 20px 50px;
            background: #fff;
        }

        #description hr {
            margin: auto;
        }

        #service {
            background: #fff;
            padding: 20px 10px;
            width: 112%;
            margin-left: -6%;
            margin-right: -6%;
        }

        .glyphicon {
            color: #10a3e8;
        }
    </style>

</head>
<body>
<%@ include file="header.jsp" %>
<%
    Product product = (Product) session.getAttribute("product");
    Integer type = (Integer) session.getAttribute("type");
%>

<%-- <?jsp
include "dbconnect.jsp";
$PID=$_GET['ID'];
$query = "SELECT * FROM products WHERE PID='$PID'";
$result = mysqli_query ($con,$query)or die(mysql_error());
    if(mysqli_num_rows($result) > 0)
    {
        while($row = mysqli_fetch_assoc($result))
        {
        $path="img/books/".$row['PID'].".jpg";
        $target="cart.jsp?ID=".$PID."&";
echo ' --%>
<div class="container-fluid" id="books">
    <div class="row">
        <div class="col-sm-10 col-md-6">
            <div class="tag">50% OFF</div>
            <div class="tag-side"><img src="img/orange-flag.png">
            </div>
            <img class="center-block img-responsive" src=<%=product.getImageLink()%> height="550px" style="padding:20px;">
        </div>
        <div class="col-sm-10 col-md-4 offset-md-1">
            <h2 id="product_name"><%=product.getName()%>
            </h2>
            <span style="color:#00B9F5;">
                <%
                    if (type == 0) {
                %>
                        <%=product.getBook().getAuthor()%> - <%=(product.getBook().getPublisherId() == null) ? "Unknown" : product.getBook().getPublisherId().getName()%>
                <%
                    } else {
                %>
                        <%=product.getName()%>
                <%
                    }
                %>
            <%--Nguyen X - NXB GIAO DUC--%>
            </span>
            <hr>
            <span style="font-weight:bold;"> Quantity : </span>
            <select id="quantity" name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="5">5</option>
            </select>
            <br><br><br>
            <a id="buyLink" onclick="btnAddClick()" class="btn btn-lg btn-danger"
               style="padding:15px;color:white;text-decoration:none;">
                ADD TO CART for only 50$ until 28th November 2018<br>
                <span style="text-decoration:line-through;"> 100$</span>
                | 50% discount
            </a>
            <input type="hidden" name="quantity_var" id="quantity_var" value="default"/>
        </div>
    </div>
</div>
<div class="container-fluid" id="description">
    <div class="row">
        <h2> Description </h2>
        <p> For Student only </p>
        <pre style="background:inherit;border:none;">
            <%
                if (type == 0) {
            %>
                    PRODUCT CODE  <%=product.getId()%> <hr>
                    TITLE         <%=product.getName()%> <hr>
                    AUTHOR        <%=product.getBook().getAuthor()%> <hr>
                    AVAILABLE     20 <hr>
                    PUBLISHER     <%=(product.getBook().getPublisherId() == null) ? "Unknown" : product.getBook().getPublisherId().getName()%><hr>
                    EDITION       6th <hr>
                    LANGUAGE      Vietnamese <hr>
                    PAGES         <%=product.getBook().getNumOfPage()%> <hr>
            <%
                }
            %>
        </pre>
    </div>
</div>
</div>


<div class="container-fluid" id="service">
    <div class="row">
        <div class="col-sm-6 col-md-3 text-center">
            <span class="glyphicon glyphicon-heart"></span> <br>
            24X7 Care <br>
            Happy to help 24X7, call us on 0120-3062244 or click here
        </div>
        <div class="col-sm-6 col-md-3 text-center">
            <span class="glyphicon glyphicon-ok"></span> <br>
            Trust <br>
            Your money is yours! All refunds come with no question asked guarantee.
        </div>
        <div class="col-sm-6 col-md-3 text-center">
            <span class="glyphicon glyphicon-check"></span> <br>
            Assurance <br>
            We provide 100% assurance. If you have any issue, your money is immediately refunded. Sit back and enjoy
            your shopping.
        </div>
        <div class="col-sm-6 col-md-3 text-center">
            <span class="glyphicon glyphicon-tags"></span> <br>
            24X7 Care <br>
            Happiness is guaranteed. If we fall short of your expectations, give us a shout.
        </div>
    </div>
</div>


 jQuery (necessary for Bootstrap's JavaScript plugins) 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 Include all compiled plugins (below), or include individual files as needed 
<script src="js/bootstrap.min.js"></script>
<script>
    // $(function () {
    //     // var link = $('#buyLink').attr('href');
    //     // $('#buyLink').attr('href', link + 'quantity=' + $('#quantity option:selected').val());
    //     // $('#quantity').on('change', function () {
    //     //     $('#buyLink').attr('href', link + 'quantity=' + $('#quantity option:selected').val());
    //     // });
    // });
    function btnAddClick() {
        var select = document.getElementById("quantity");
        var url = window.location;
        var new_url = "http://localhost:8080/detail_added.jsp?id=" + <%=product.getId()%>;
        if (select.selectedIndex == NaN)
            new_url += + "&quantity=1";
        else
            new_url +="&quantity=" + select.options[select.selectedIndex].value;
        window.location = new_url;
    }

</script>
</body>
</html>   