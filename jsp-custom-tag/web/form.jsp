<%--
  Created by IntelliJ IDEA.
  User: huy
  Date: 2019-05-07
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
    <title>Beer Advisor</title>
    <style><%@ include file="css/styles.css" %></style>
</head>
<body>
<h1 class="center">Beer selection page</h1>
<form action="SelectBeer.do" method="post">
    <fieldset>
        <legend>Select beer characteristics</legend>

        <div class="row">
            <label for="color">Color:</label>
            <select name="color" id="color">
                <option value="light">light</option>
                <option value="amber">amber</option>
                <option value="brown">brown</option>
                <option value="dark">dark</option>
            </select>
        </div>

        <button type="submit">Submit</button>
    </fieldset>
</form>
</body>
</html>
