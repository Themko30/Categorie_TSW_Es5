<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<fieldset>
    <legend>Area di registrazione</legend>
    <form action="" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label>Password :
            <input name="password" id="password" type="password" onkeyup='check();'/>
        </label>
        <br>
        <label>Confirm password:
            <input type="password" name="confirm_password" id="confirm_password"
                   onkeyup='check();'/>
            <span id='message'></span>
        </label>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br>
    </form>
</fieldset>

</body>
</html>
