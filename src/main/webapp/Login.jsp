<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<fieldset>
    <legend>Area di login:</legend>
    <form action="LoginServlet" method="get">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="ok">
    </form>
    <a href="index.jsp">Torna alla home</a>
</fieldset>
</body>
</html>
