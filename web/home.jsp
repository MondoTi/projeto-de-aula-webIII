<%-- 
    Document   : home
    Created on : 26 de abr. de 2023, 21:12:55
    Author     : QI
--%>

<%@page import="model.User" %>
<%
    User uSession = (User)session.getAttribute("userLoggedSession");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/pp.png"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>Por Poa</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="session/verify.jsp" %>
        <p style="text-align: center; font-family: Arial Black; ">
            Seja Bem Vindo !
            
        </p>
        <hr>
        
        <button onclick="window.location.href='session/logout.jsp'" class="botaol">Logout</button>
        <button onclick="window.location.href='cadastro.jsp'" class="botaocadastro">CADASTRAR</button>
        <button onclick="window.location.href='lista.jsp'" class="botaocadastro">LISTAR</button>
         
       
    </body>
</html>
