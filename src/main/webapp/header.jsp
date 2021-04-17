<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<fieldset>
    <legend>Area Registrazione</legend>
    <form action="signup.jsp">
        <label>Se sei un nuovo utente registrati qui:</label>
        <input type="submit" value="Registrati">
    </form>
    <form action="login.html">
        <label>Se già sei registrato clicca qui:</label>
        <input type="submit" value="Login">
    </form>
</fieldset>

</body>
</html>
