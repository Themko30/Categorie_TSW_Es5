<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categorie TSW</title>
</head>
<body>
<h1><%= "Prodotti" %>
</h1>
<br/>
<h1>
    Ecco i prodotti della categoria ${categoria.name}:
</h1>
<ul>
    <c:forEach items="${prodotti}" var="prodotto">
        <li>
            Nome: ${prodotto.name}<br>
            Descrizione: ${prodotto.description}<br>
            Prezzo: ${prodotto.price}<br>
        </li>
    </c:forEach>
</ul>
</body>
</html>