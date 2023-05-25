<%@page import="model.TuristicoDAO"%>
<%@page import="model.Turistico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/pp.png"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>Por Poa</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista</title>
    </head>
    <body>
        <h1>Lista</h1>
        <hr>
        
        <table border="1">
            <thead>
                <tr>
                    <th>id_turistico</th>
                    <th>ponto</th>
                    <th>historia</th>
                    <th>regiao</th>
                    <th>praca</th>
                    <th>monumento</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    TuristicoDAO adao = new TuristicoDAO();
                    for(Turistico tur : adao.listAll()){
                %>
                <tr>
                    <td><%= tur.getIdTuristico() %></td>
                    <td><%= tur.getPonto() %></td>
                    <td><%= tur.getRegiao() %></td>
                    <td><%= tur.getHistoria() %></td>
                    <td><%= tur.getPraca() %></td>
                    <td><%= tur.getMonumento() %></td>
                    <td>
                        <a href="TuristicoUpdate?id=<%= tur.getIdTuristico() %>">Editar</a>
                    </td>
                    <td>
                        <a onclick="confirmDelete()">Excluir</a>
                    </td>
                </tr>
                <% } %>
                    
            </tbody>
        </table>

        
        <a href="home.jsp" >Pagina inicial</a>
        
        <script>
            function confirmDelete(id){
                if(confirm("deseja realmente excluir?")){
                    window.location.replace("TuristicoDelete?cod="+ id);
                } else{
                    alert("Exclusão cancelada!");
                }
            }
           </script>
            
        
        
    </body>
</html>

