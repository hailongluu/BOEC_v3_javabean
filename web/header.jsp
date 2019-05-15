<%--
  Created by IntelliJ IDEA.
  User: phamhoanganh
  Date: 2019-05-14
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@page import="entities.customer.Accountcustomer"%>
<%@page import="entities.customer.Customer"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
</head>
<html>

<body>
<div id="top">
    <div id="searchbox" style="display: inline-flex; width: 100%;">
        <div style="margin: 20px">
            <a class="" href="/"><img class="img-responsive" alt="Brand"
                                      src="img/logo_white_n.jpg"
                                      style="width: 100px; margin: 5px 15px;"></a></div>
        <div style="margin:20px 20px 20px 20px;width: 70%">
            <form role="search" method="POST" action="Result.jsp">
                <input type="text" class="form-control" name="keyword"
                       placeholder="Search for a Book , Electronic or Fashion that you are looking for ...">
            </form>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right navbar-horizontal">
                <% if (session.getAttribute("isLogin") != null) {
                Customer customer = (Customer) session.getAttribute("customer");      
                %>
                    <div class="dropdown" style="color: white;margin: 25px;font-size: 19px;">
                        <a class="dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <%=customer.getName().getFullName()%>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="account.jsp">Account</a>
                            <a class="dropdown-item" href="#">Notification</a>
                            <a class="dropdown-item" href=<%=request.getContextPath()+"/logout"%>>Logout</a>
                        </div>
                    </div>
                <% } else { %>
                <li style="margin: 15px;">
                    <a type="button" id="login_button" class="btn btn-lg" href="login.jsp" onclick="action()">Login</a>
                </li>
                <li style="margin: 15px 0">
                    <a type="button" id="register_button" class="btn btn-lg" href="register.jsp" onclick="action()">Sign Up</a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</body>
</html>
