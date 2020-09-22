<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/21/2020
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<label>Language: ${mailbox.language}</label>
<br>
<label>Page size: show ${mailbox.pageSize} email per page</label>
<br>
<label>Spams filter ${mailbox.spamsFilter}</label>
<br>
<label>Signature: <c:forEach var="string" items="${mailbox.strings}">${string}</c:forEach></label>
<a href="/views/editMailbox/${student.id}">edit</a>
</body>
</html>
