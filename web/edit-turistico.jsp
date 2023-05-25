<%-- 
    Document   : cadastro
    Created on : 10 de mai. de 2023, 19:24:55
    Author     : QI
--%>
<%@page import="model.Turistico"%> 

<%
    Turistico tur = (Turistico)request.getAttribute("turistico");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pontos Turiticos</title>
    </head>
    <body>
        <h1>Edição</h1>
        <hr>
        <form action="CadastroTuristico" method="post">
            <input type="text" name="id" value="<%= tur.getIdTuristico() %>" readonly>
            <br><br>
            
            
            
            <input type="text" name="ponto" value="<%= tur.getPonto() %>" placeholder="Nome Ponto Turistico">
            <br><br>
            <input type="text" name="regiao" value="<%= tur.getRegiao() %>" placeholder="Regiao do ponto">
            <br><br>
            <input type="text" name="historia" value="<%= tur.getHistoria() %>" placeholder="Conte um pouco sobre o lugar">
            <br><br>
            <input type="checkbox" name="praca" value="sim" <%= (tur.getPraca()==1) ? "checked" : "" %>> <label>Praça</label>  
            <br><br>
            <input type="checkbox" name="monumento" value="sim" <%= (tur.getMonumento()==1) ? "checked" : "" %>> <label>Monumento</label>  
            <br><br>
            <input type="submit" value="Finalizar edição" >
            <input type="reset" value="Restaurar">
            <hr><br>
            
            
        </form>
        <a href="home.jsp" >Pagina inicial</a>
        
    </body>
</html>
