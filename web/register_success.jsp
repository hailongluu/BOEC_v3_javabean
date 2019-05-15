<%--
  Created by IntelliJ IDEA.
  User: hailongluu
  Date: 4/18/2019
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="entities.customer.Customer"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Success</title>
</head>
<body>
    <% Customer customer = (Customer) session.getAttribute("customer");
    %>
<a><b>Welcome User!!!!</b></a>
<a>username: <%=customer.getName().getFullName()%></a>
<a href=<%=request.getContextPath()+"/home"%>>Back to Home Page</a>
</body>
</html>
