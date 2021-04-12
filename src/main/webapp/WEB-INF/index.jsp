<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categorie TSW</title>
</head>
<body>
<h1><%= "Home Page" %>
</h1>
<br/>

<form id="form1" action="CategoriaServlet">
    <label for="select1">Categorie:</label>
    <select id="select1" name="categoria" size="1" form="form1">
        <c:forEach items="${categorie}" var="categoria">
            <option value="${categoria.id}">${categoria.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Vai alla categoria">
</form>

<ul>
    <c:forEach items="${prodotti}" var="prodotto">
        <li>
            Nome:${prodotto.name}<br>
            Descrizione:${prodotto.description}<br>
            Prezzo:${prodotto.price}<br>
        </li>
    </c:forEach>
</ul>
</body>
</html>