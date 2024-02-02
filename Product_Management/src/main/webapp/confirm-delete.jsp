<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 01/02/2024
  Time: 11:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Bạn có muốn xóa sản phẩm có tên là ${product.nameProduct} không?</h1>
<a href="/product">Khong</a>
<form action="/product" method="post">
    <input type="hidden" value="${product.id}" name="id">
    <input type="hidden" name="action" value="delete">
    <button>Co</button>
</form>
</body>
</html>
