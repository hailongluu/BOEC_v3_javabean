<%-- 
    Document   : viewbook
    Created on : May 14, 2019, 2:08:53 PM
    Author     : hailongluu
--%>

<%@page import="util.TimeConvert"%>
<%@page import="entities.order.Order1"%>
<%@page import="entities.product.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Page</title>
    </head>
    <body>
        <h1>Update State For Order</h1>
        <table border="1">
            <tr>
                <th>Order ID</th>
                <th>Date Created</th>
                <th>Price</th>
                <th>Shipping Address</th>
                <th>Shipping Status</th>

            </tr>
            <%
                List<Order1> listOrders = (List<Order1>) session.getAttribute("listEmOrders");
                for (int i = 0; i < listOrders.size(); i++) {
            %>
            <tr>
                <td><%=listOrders.get(i).getId()%></td>
                <td><%=TimeConvert.convertToString(listOrders.get(i).getDateCreated())%></td>
                <td><%=listOrders.get(i).getCart().getTotalPrice().toString()%></td>
                <td><%=listOrders.get(i).getShippingAddress()%></td>
                <td><%=listOrders.get(i).getShippingStatus()%></td>
                <td><a href="updatestate?index=<%=listOrders.get(i).getId()%>">Update Status</a></td>
            </tr>
            <%
                }

            %>
        </table>
    </body>
</html>