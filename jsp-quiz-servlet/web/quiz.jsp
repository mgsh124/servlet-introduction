<%--
  Created by IntelliJ IDEA.
  User: huy
  Date: 2019-05-06
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Quiz Servlet</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your current score is <strong>${sessionScope.quiz.score}</strong>.</p>
<p>Guess the next number in the sequence.</p>
<p>${questions[sessionScope.quiz.questionNo - 1]}</p>
<form method="post">
    <div class="row">
        <label for="age">Your age:</label>
        <input type="text" name="age" id="age" size="10" value=${sessionScope.quiz.age > 0 ? sessionScope.quiz.age : null}>
        <%
            String invalid = request.getAttribute("invalid").toString();
            if (invalid != null && !invalid.equals("")) {
        %>
        <p><small style="color:red;"><%= invalid %></small></p>
        <% } %>
    </div>
    <br/>
    <div class="row">
        <label for="answer">Your answer:</label>
        <input type="text" name="answer" id="answer" pattern="\d*" size="10" title="Please input a number" required autofocus/>
        <p><small>You have <strong>${sessionScope.quiz.count}</strong> chance(s) left!</small></p>
    </div>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
