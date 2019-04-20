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
        <div>
            <c:import url="menu.jsp"/>
        </div>
        <br>
        <table border="1">
            <c:forEach var="usuario" items="${usuarios}" varStatus="index">
                <tr bgcolor="#${index.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.login}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
