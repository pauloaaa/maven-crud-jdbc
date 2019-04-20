<%-- 
    Document   : listar_usuario
    Created on : 13/04/2019, 10:25:40
    Author     : paulo
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.paulo.mavencrud.usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .: Listar Usuário :. </title>
    </head>
    <body>

        <c:forEach var="usuario" items="${usuarios}">
            ${usuario.nome}
        </c:forEach>

    </body>
</html>
