<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<fieldset>
    <legend>Area di registrazione</legend>
    <form action="RegistrazioneServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label>Password :
            <input name="psw1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="password"
                   type="password" onkeyup='check();'/>
        </label>
        <br>
        <label>Confirm password:
            <input type="password" name="psw2" id="confirm_password"
                   onkeyup='check();'/>
            <span id='message'></span>
        </label><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br>
        <input type="submit" value="ok">
    </form>
    <a href="index.jsp">Torna alla home</a>
</fieldset>

<script>
  var check = function () {
    if (document.getElementById('password').value ==
        document.getElementById('confirm_password').value) {
      document.getElementById('message').style.color = 'green';
      document.getElementById('message').innerHTML = 'matching';
    } else {
      document.getElementById('message').style.color = 'red';
      document.getElementById('message').innerHTML = 'not matching';
    }
  }

</script>

</body>
</html>
