<%--
  Created by IntelliJ IDEA.
  User: huy
  Date: 2019-05-06
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose</title>
</head>
<body>
<form method="post" action="ChooseServlet">
    <p>Is JSP cool?</p>
    <label><input type="radio" value="1"
           name="radioJSPCool" ${radioJSPCool.getYesCheck() == "1" ? "checked" : ""}>Yes</label><br/>
    <label><input type="radio" value="0"
           name="radioJSPCool" ${radioJSPCool.getNoCheck() == "0" ? "checked" : ""}>No</label><br/><br/>
    <input type="submit" name="btnSubmit" value="Submit"/><br/><br/>
    <p>Is JSF way cool?</p>
    <label><input type="radio" value="1"
           name="JSFwayCool" ${jsfWayCool.getYesCheck() == "1" ? "checked" : ""}>Yes</label><br/>
    <label><input type="radio" value="0"
           name="JSFwayCool" ${jsfWayCool.getNoCheck() == "0" ? "checked" : ""}>No</label><br/><br/>
    <input type="submit" name="btnSubmit" value="Submit"/><br/><br/>
    <p>Is the moon made of cheese?</p>
    <label><input type="radio" value="1"
           name="moonCheese" ${moonCheese.getYesCheck() == "1" ? "checked" : ""}>Yes</label><br/>
    <label><input type="radio" value="0"
           name="moonCheese" ${moonCheese.getNoCheck() == "0" ? "checked" : ""}>No</label><br/><br/>
    <input type="submit" name="btnSubmit" value="Submit"/>
</form>
</body>
</html>
