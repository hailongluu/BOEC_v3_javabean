<%@page import="session.BookFacadeLocal"%>
<%@page import="entities.product.clother.Clothes"%>
<%@page import="entities.product.book.Book"%>
<%@page import="entities.product.electronic.Electronics"%>
<%@page import="entities.product.Product"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="detail" content="Books">
        <meta name="author" content="Shivangi Gupta">
        <title>TAKA</title>
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <%
            List<Book> listBooks = (List<Book>) session.getAttribute("listBooks");
            List<Electronics> listElectronics = (List<Electronics>) session.getAttribute("listElectronics");
            List<Clothes> listClothes = (List<Clothes>) session.getAttribute("listClothes");
        %>
        <div class="container-fluid" id="header">
            <div class="row">
                <div class="col-md-3 col-lg-3" id="category">
                    <div style="background:#10a3e8;color:#fff;font-weight:800;border:none;padding:15px;"> The Book Shop
                    </div>
                    <ul>
                        <li><a href="Product.jsp?value=entrance%20exam"> Entrance Exam </a></li>
                        <li><a href="Product.jsp?value=Literature%20and%20Fiction"> Literature & Fiction </a></li>
                        <li><a href="Product.jsp?value=Academic%20and%20Professional"> Academic & Professional </a></li>
                        <li><a href="Product.jsp?value=Biographies%20and%20Auto%20Biographies"> Biographies & Auto
                                Biographies </a></li>
                        <li><a href="Product.jsp?value=Children%20and%20Teens"> Children & Teens </a></li>
                        <li><a href="Product.jsp?value=Regional%20Books"> Regional Books </a></li>
                        <li><a href="Product.jsp?value=Business%20and%20Management"> Business & Management </a></li>
                        <li><a href="Product.jsp?value=Health%20and%20Cooking"> Health and Cooking </a></li>

                    </ul>
                </div>
                <div class="col-md-6 col-lg-6">
                    <div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                            <li data-target="#myCarousel" data-slide-to="4"></li>
                            <li data-target="#myCarousel" data-slide-to="5"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="img-responsive" src="img/carousel/1.jpg">
                            </div>

                            <div class="carousel-item">
                                <img class="img-responsive " src="img/carousel/2.jpg">
                            </div>

                            <div class="carousel-item">
                                <img class="img-responsive" src="img/carousel/3.jpg">
                            </div>

                            <div class="carousel-item">
                                <img class="img-responsive" src="img/carousel/4.jpg">
                            </div>

                            <div class="carousel-item">
                                <img class="img-responsive" src="img/carousel/5.jpg">
                            </div>

                            <div class="carousel-item">
                                <img class="img-responsive" src="img/carousel/6.jpg">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="col-md-3 col-lg-3" id="offer">
                    <a href="Product.jsp?value=Regional%20Books"> <img class="img-responsive center-block"
                                                                       src="img/offers/1.png"></a>
                    <a href="Product.jsp?value=Health%20and%20Cooking"> <img class="img-responsive center-block"
                                                                             src="img/offers/2.png"></a>
                    <a href="Product.jsp?value=Academic%20and%20Professional"> <img class="img-responsive center-block"
                                                                                    src="img/offers/3.png"></a>
                </div>
            </div>
        </div>
    </div>

    <%--# BOOK--%>
    <div style="text-align: left; font-size: 25px; font-family: sans-serif; padding-top: 20px; font-weight: 400; padding-left: 10px;">
        <div class="tag" style="height: 100%">TOP TRENDING BOOKS</div>
        <div class="tag-side" style="padding-top: 10px;"><img src="img/tag.png" style="width: 150%; height: 150%"></div>
    </div>
    <br>
    <div class="container-fluid text-center" id="new">
        <!--    <div style="text-align: left; font-size: 25px; font-family: sans-serif; padding-top: 20px; font-weight: 400; padding-left: 3px;">
                <div class="tag">TOP TRENDING BOOKS</div>
                <div class="tag-side"><img src="img/tag.png"></div>
            </div>-->
        <hr>
        <div class="row blog">
            <div class="col-md-12">
                <div id="blogCarousel" class="carousel slide" data-ride="carousel">

                    <ol class="carousel-indicators">
                        <%
                            int iterations = listBooks.size() / 4;
                            System.out.println(iterations);
                            for (int ite = 0; ite < iterations; ite++) {
                                if (ite == 0) {
                        %>
                        <li data-target="#blogCarousel" data-slide-to="<%=ite%>" class="active"></li>
                        <%
                        } else {
                        %>
                        <li data-target="#blogCarousel" data-slide-to="<%=ite%>"></li>
                        <%
                                }
                            }
                        %>
                    </ol>
                    <!-- Carousel items -->
                    <div class="carousel-inner">
                        <%
                            for (int i = 0; i < iterations; i++) {
                                int startIndex = i * 4;
                                int endIndex = (i == iterations - 1) ? listBooks.size() : startIndex + 4;
                                if (i == 0) {
                        %>                    
                                    <div class="carousel-item active">
                            <%  } else {
                            %>
                                    <div class="carousel-item">
                            <%
                                }
                            %>
                                    <div class="row">
                                <%
                                    for (int j = startIndex; j < endIndex; j++) {
                                        Book book = listBooks.get(j);
                                %>
                                        <div class="col-sm-6 col-md-3 col-lg-3">
                                            <a href="detail.jsp?id=<%=book.getAuthor()%>">
                                                <div class="book-block">
                                                    <div class="tag">New</div>
                                                    <div class="tag-side"><img src="img/tag.png"></div>
                                                    <img class="block-center img-responsive" src="<%=book.getProduct().getImageLink()%>" style="width: 200px; height: 200px;">
                                                    <hr>
                                                    <%=(book.getProduct().getName().length() < 30) ? book.getProduct().getName() : book.getProduct().getName().substring(0, 27) + "..."%> <br>
                                                    <%=book.getProduct().getPrice()%> USD
                                                </div>
                                            </a>
                                        </div>
                                <%
                                    }
                                %>
                                </div>
                            </div>
                            <%
                                }
                            %>
                            <!--.item-->

                        </div>
                        <!--.carousel-inner-->
                    </div>
                    <!--.Carousel-->
                </div>
            </div>
        </div>
    </div>
<footer style="margin-top: 50px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-1 col-md-1 col-lg-1">
            </div>
            <div class="col-sm-7 col-md-5 col-lg-5">
                <div class="row text-center">
                    <h2>Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Still Confused? Give us a call or send us an email and we will get back to you as soon as
                        possible!</p>
                </div>
                <div class="row">
                    <div class="col-md-6 text-center">
                        <span class="glyphicon glyphicon-earphone"></span>
                        <p>123-456-6789</p>
                    </div>
                    <div class="col-md-6 text-center">
                        <span class="glyphicon glyphicon-envelope"></span>
                        <p>BookStore@gmail.com</p>
                    </div>
                </div>
            </div>
            <div class="hidden-sm-down col-md-2 col-lg-2">
            </div>
            <div class="col-sm-4 col-md-3 col-lg-3 text-center">
                <h2 style="color:#10a3e8;">Follow Us At</h2>
                <div>
                    <a href="https://twitter.com/strandbookstore">
                        <img title="Twitter" alt="Twitter" src="img/social/twitter.png" width="35" height="35"/>
                    </a>
                    <a href="https://www.linkedin.com/company/strand-book-store">
                        <img title="LinkedIn" alt="LinkedIn" src="img/social/linkedin.png" width="35" height="35"/>
                    </a>
                    <a href="https://www.facebook.com/strandbookstore/">
                        <img title="Facebook" alt="Facebook" src="img/social/facebook.png" width="35" height="35"/>
                    </a>
                    <a href="https://plus.google.com/111917722383378485041">
                        <img title="google+" alt="google+" src="img/social/google.jpg" width="35" height="35"/>
                    </a>
                    <a href="https://www.pinterest.com/strandbookstore/">
                        <img title="Pinterest" alt="Pinterest" src="img/social/pinterest.jpg" width="35" height="35"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</footer>

</body>

</html>