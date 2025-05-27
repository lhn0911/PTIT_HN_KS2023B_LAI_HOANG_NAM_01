<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/category/add" modelAttribute="categoryDTO">
    Tên danh mục: <label>
    <input type="text" name="category_name" value="${CategoryDTO.category_name}"/>
</label><br/>
    Mô tả: <label>
    <input type="text"  name="description" value="${CategoryDTO.description}"/>
</label><br/>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
