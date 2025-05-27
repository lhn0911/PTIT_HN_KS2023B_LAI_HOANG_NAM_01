<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>
<form method="post" action="/category/edit" modelAttribute = "CategoryDTO">
  <label>
    ID<input type="text" name="category_id" value="${CategoryDTO.category_id}"/>
  </label>
  Tên danh mục: <label>
    <input type="text" name="category_name" value="${CategoryDTO.category_name}"/>
</label><br/>
  Mô tả: <label>
    <input type="text" name="description" value="${CategoryDTO.description}"/>
</label><br/>
  Trạng thái: <label>
    <input type="text" name="status" value="${CategoryDTO.status}"/>
</label><br/>
  <button type="submit">Lưu</button>
</form>
</body>
</html>
