<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 01/02/2024
  Time: 2:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form  method="post">
<input name="id" type="text" placeholder="id" value="${product.getId()}">
<input name="nameProduct" type="text" placeholder="name" value="${product.getNameProduct()}">
<input name="priceProduct" type="text" placeholder="price" value="${product.getPriceProduct()}">
<input name="describeProduct" type="text" placeholder="describeProduct" value="${product.getDescribeProduct()}">
<input name="producer" type="text" placeholder="producer" value="${product.getProducer()}">
<button > sửa</button>

</form>
<%--<p>--%>
<%--    <a href="/product">Back</a>--%>
<%--</p>--%>
</body>
</html>
