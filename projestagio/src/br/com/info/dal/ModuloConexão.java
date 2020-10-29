package br.com.info.dal;

import java.sql.*;

public class ModuloConexão {
    //método responsável por estabelecer a conexão com o banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbinfo";
        String user = "root";
        String password = "";
        //estabelencendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
       } catch (Exception e) {
            System.out.println(e);
           return null;
        }
    }
}
