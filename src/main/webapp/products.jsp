<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<c:choose>
    <c:when test="${empty sessionScope.products}">
        <p>Không có sản phẩm nào!</p>
    </c:when>
    <c:otherwise>
        <table border="1" style="width:100%">
            <tr>
                <th>Tên sản phẩm</th>
                <th>Giá (VND)</th>
            </tr>
            <c:forEach items="${sessionScope.products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<br>
<a href="product-form.html">Thêm sản phẩm mới</a>
</body>
</html>