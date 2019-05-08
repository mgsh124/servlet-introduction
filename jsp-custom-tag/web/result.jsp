<%--
  Created by IntelliJ IDEA.
  User: huy
  Date: 2019-05-07
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Beer Advisor</title>
    <style><%@ include file="css/styles.css" %></style>
</head>
<body>
<h1>Beer Selection Advice</h1>
<p>Got beer color <strong>${color}</strong></p>
<c:forEach var="brand" items="${brands}">
    Try: ${brand} <br/>
</c:forEach>
</body>
</html>
