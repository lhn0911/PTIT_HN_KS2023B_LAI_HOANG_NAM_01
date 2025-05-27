<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="/products/add">Thêm mới</a>
<table border="1">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Mô tả sản phẩm</th>
        <th>Giá</th>
        <th>Đường dẫn ảnh</th>
        <th>Trạng thái hiển thị</th>
        <th>Ngày thêm mới</th>
        <th>Mã danh mục</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.product_id}</td>
            <td>${p.product_name}</td>
            <td>${p.description}</td>
            <td>${p.price}</td>
            <td>${p.image_url}</td>
            <td>${p.status}</td>
            <td>${p.created_at}</td>
            <td>${p.category_id}</td>
            <td>
                <a href="/products/edit/${p.id}">Sửa</a> |
                <a href="/products/delete/${p.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
