<%-- 
    Document   : cadastro
    Created on : 10 de mai. de 2023, 19:24:55
    Author     : QI
--%>

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
        <h1 style="font-family: Arial; text-align: center;">Cadastro</h1>
        <hr>
        
        <div id="form-center">
        <form action="CadastroTuristico" method="post">
            <h3 style="text-align: center;">Novos pontos turisticos</h3>
            <input type="text" name="ponto" placeholder="Nome Ponto Turistico" class="input-center">
            <br><br>
            <input type="text" name="regiao" placeholder="Regiao do ponto" class="input-center">
            <br><br>
            <input type="text" name="historia" placeholder="Conte um pouco sobre o lugar" class="input-center">
            <br><br>
            <input type="checkbox" name="praca" value="sim"> <label>Praça</label>  
            <br><br>
            <input type="checkbox" name="monumento" value="sim"> <label>Monumento</label>  
            <br><br>
            <input type="submit" value="cadastrar" id="submit-cadastro" ><hr><br>
            
            
        </form>
        </div>
        
        <a style="font-family: Arial;" href="home.jsp" >Pagina inicial</a>
        
    </body>
</html>
