<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/21/2020
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator">
    <div style="margin-bottom: 15px">
        <input type="text" name="num1" placeholder="number 1">
        <input type="text" name="num2" placeholder="number 2"><br>
    </div>
    <input type="submit" name="calculate" value="Addition(+)">
    <input type="submit" name="calculate" value="Subtraction(-)">
    <input type="submit" name="calculate" value="Multiplication(x)">
    <input type="submit" name="calculate" value="Division(/)">

    <p>Result :${result}</p>
    <p>${message}</p>

</form>
</body>
</html>
