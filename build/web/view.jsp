<%-- 
    Document   : viewbook
    Created on : May 14, 2019, 2:08:53 PM
    Author     : hailongluu
--%>

<%@page import="entities.product.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>get full book</h1>
<table border="1">
<tr>
<th>name</th>
<th>author</th>
<th>publisher</th>
<th>price</th>
<th>select</th>
</tr>
<%
List<Product> lisBooks = (List<Product>) session.getAttribute("listProducts");
for (int i = 0; i < lisBooks.size(); i++) {
%>
<tr>
<td><%=lisBooks.get(i).getName()%></td>
<td><%=lisBooks.get(i).getPrice()%></td>
<td><%=lisBooks.get(i).getQuantity()%></td>
<td><%=lisBooks.get(i).getPrice()%></td>
<td><a href="doCart?index=<%=i%>">add cart</a></td>
</tr>
<%
}

%>
</table>
</body>
</html>