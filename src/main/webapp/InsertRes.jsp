<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Risultato Save Form</title>
</head>
<body>
<h3> Il tuo insert è riuscito correttamente</h3>
<h4>I dati aggiornati sono:</h4>
<p>
    Id: ${utente.id}<br>
    Username: ${utente.username}<br>
    Email: ${utente.email}<br>
</p>

<a href="index.jsp">Torna alla home</a>
</body>
</html>
