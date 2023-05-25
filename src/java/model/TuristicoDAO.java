package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TuristicoDAO {
    private static Connection conn;
    
    public TuristicoDAO() throws ClassNotFoundException, SQLException{
        conn = MyDatabase.getDatabase();
    }
    
    //*****Métodos do CRUD*****
    //Insert (Creat)
    public void insertTuristico(Turistico a) throws SQLException {
        //Criando a query para inserir o registro
        String query = "INSERT INTO turistico(ponto, historia, regiao, praca, monumento)"
                + "VALUES(?,?,?,?,?)";
        
        //Preparar a query para ser executada no B.D
        PreparedStatement prep = conn.prepareStatement(query);

        prep.setString(1, a.getPonto());
        prep.setString(2, a.getHistoria());
        prep.setString(3, a.getRegiao());
        prep.setInt(4, a.getPraca());
        prep.setInt(5, a.getMonumento());
        
        //Executando a query pronta
        prep.execute();
        prep.close();
    }
           
    
    //SELECT
    public ArrayList<Turistico> listAll() throws SQLException{
        //criar lista vazia
        ArrayList<Turistico> list = new ArrayList<>();
        
        //Criar query para pesquisa BD
        String query = "SELECT * FROM turistico";
        
        //preparar query para executar no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
        //Pegar o Resultado da pesquisa do BD
        ResultSet res = prep.executeQuery();
        
        //varrer "res" = mapeando os registro do BD
        //para objeto da classe "Turistico"
        while(res.next()){
            // Criar objeto Turistico Vazio
            Turistico tur = new Turistico();
            
            //Inserir os valores nos atributos com
            // os dados vindos das colunas do BD
            tur.setIdTuristico(res.getInt("id_turistico"));
            tur.setPonto(res.getString("ponto"));
            tur.setRegiao(res.getString("regiao"));
            tur.setHistoria(res.getString("historia"));
            tur.setPraca(res.getInt("praca"));
            tur.setMonumento(res.getInt("monumento"));
            
            //inserir o objeto completo na lista
            list.add(tur);
            
        }
        
        //Retornar lista cheia
        return list;
    }


    //SELECT
    public Turistico listById(int i) throws SQLException{
            String query = "SELECT * FROM turistico WHERE id_turistico = "+ i;

            PreparedStatement prep = conn.prepareStatement(query);
            ResultSet res = prep.executeQuery();
            
            Turistico tur = new Turistico();
            
            if(res.next()){
                tur.setIdTuristico(res.getInt("id_turistico"));
                tur.setPonto(res.getString("ponto"));
                tur.setRegiao(res.getString("regiao"));
                tur.setHistoria(res.getString("historia"));
                tur.setPraca(res.getInt("praca"));
                tur.setMonumento(res.getInt("monumento"));
            }
            return tur;
        }
    
    //UPDATE
    public void updateTuristico(Turistico tur) throws SQLException{
        String query = "UPDATE turistico SET ponto = ?"
                + "historia = ?, regiao = ?,"
                + "praca = ?, monumento = ? WHERE id_turistico = ?";
        
       PreparedStatement prep = conn.prepareStatement(query);
       prep.setString(1, query);
       prep.setString(2, query);
       prep.setString(3, query);
       prep.setString(4, query);
       prep.setString(5, query);
       prep.setString(6, query);
       
       
    }
    
    public void deleteTuristico(int id) throws SQLException {
        String query = "DELETE turistico WHERE id_turistico = " + id;
        
        PreparedStatement prep = conn.prepareStatement(query);
        prep.execute();
        prep.close();
    }
    

}//fim da classe
