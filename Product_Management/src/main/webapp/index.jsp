<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Search Name</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table border="1">

    <tr>
        <td>Id</td>
        <td>Name Product</td>
        <td>Price Product</td>
        <td>Description Product</td>
        <td>Company</td>
    </tr>

    <c:forEach  var="p" items="${product}" >
        <tr>
            <td>${p.getId()}</td>
            <td>${p.getNameProduct()}</td>
            <td>${p.getPriceProduct()}</td>
            <td>${p.getDescribeProduct()}</td>
            <td>${p.getProducer()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>