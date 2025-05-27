<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách danh muc</h2>
<a href="${pageContext.request.contextPath}/category/add">Thêm mới</a>
<table border="1">
    <tr>
        <th>ID</th><th>Tên</th><th>Mô tả</th><th>Trạng thái</th><th>Hành động</th>
    </tr>
    <c:forEach items="${categories}" var="c">
    <tr>
        <td>${c.category_id}</td>
        <td>${c.category_name}</td>
        <td>${c.description}</td>
        <td>${c.status}</td>
        <td>
            <a href="/category/edit/${c.category_id}">Sửa</a> |
            <a href="/category/delete/${c.category_id}">Xóa</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
