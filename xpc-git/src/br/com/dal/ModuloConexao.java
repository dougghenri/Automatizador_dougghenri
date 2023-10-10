/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dal;


import java.sql.*;

/**
 *
 * @author gabri
 */
public class ModuloConexao {
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // a linha abaixo "chama" o driver
        String driver = "com.mysql.cj.jdbc.Driver";
        //armazenar informações do banco
   
        //String url =TelaLogin.teste.getText();
        
        String url = "jdbc:mysql:// localhost:3306/xpc?characterEncoding=utf-8";
       
        //String user = TelaLogin.user.getText();
        String user = "root"; // ativar linha quando o padronizador não funionar
        //String password = TelaLogin.senha.getText();
        String password = ""; // ativar linha quando o padronizador não funionar
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //a linha abaixo serve para o desenvolvedor identificar erros de conexão com banco de dados 
            //System.out.println(e);
            return null;
        }
    }

  
}
    

