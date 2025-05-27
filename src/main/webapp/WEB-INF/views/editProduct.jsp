<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 7:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>
<form method="post" action="/products/edit" modelAttribute = "productDTO">
    Tên: <input type="text" name="product_name" value="${productDTO.product_name}"/><br/>
    Mô tả: <input type="text" name="description" value="${productDTO.description}"/><br/>

    Giá: <input type="number"  name="price" value="${productDTO.price}"/><br/>
    Hình ảnh (URL): <input type="text" name="image_url" value="${productDTO.image_url}"/><br/>
    <button type="submit">Lưu</button>
</form>

</body>
</html>
