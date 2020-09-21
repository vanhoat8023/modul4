<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/17/2020
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>English</title>
</head>
<body>
<h1>Dictionary</h1>
<form method="post" action="/dictionary">
    <label>English:</label><input type="text" placeholder="value" name="keyword" value="${keyword}">
    <input type="submit" value="search">
    <h2>ket qua:${result}</h2>
</form>
</body>
</html>
