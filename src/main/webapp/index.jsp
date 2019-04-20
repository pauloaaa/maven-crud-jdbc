<%-- 
    Document   : index
    Created on : 20/04/2019, 20:22:03
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> .: Paulo Arruda :.</title>
    </head>
    <body>
        <div>
            <c:import url="menu.jsp"/>
        </div>
        <br>
        <div>
            Bem Vindo <c:out value="${usuarioAutenticado.nome}"/>
        </div>
    </body>
</html>
