<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 31/01/2024
  Time: 3:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product-management</title>
</head>
<body>
<a href="/product?action=create">thêm</a>
<form action="/product">
    <input type="hidden" name="action" value="search">
    <input type="text" name="nameProduct">
<button type="submit">tìm kiếm</button>
</form>
<table border="1px">
    <h1>Danh sách sản phẩm</h1>
    <tr>
        <td> thứ tự</td>
        <td>tên</td>
        <td>giá</td>
        <td>mô tả</td>
        <td>nhà sản xuất</td>
        <td>Xoa</td>
    </tr>
    <tr>
        <c:forEach var="p" items="${product}">
    <tr>
        <td>${p.id} </td>
        <td>${p.nameProduct}</td>
        <td>${p.priceProduct}</td>
        <td>${p.describeProduct}</td>
        <td>${p.producer}</td>
    <td><a href="/product?action=update&id=${p.id}">
        sửa
    </a></td>
        <td>

            <a href="/product?action=delete&id=${p.id}">Xóa</a>

        </td>
    </tr>
    </c:forEach>


</table>

</body>
</html>
