package com.example.proyecto.usuariomvc;

import java.sql.Connection;
import java.sql.Statement;

public class UsuarioModel {


    public void insertarUsuario(String username, String firstname, String lastname, String email, long phone, String address, String country, String city, String birthdate, String role) {
        Connection connection;
        Statement statement;

        //  try{
        //connection = mySql.getConnection();
        //statement = connection.createStatement();
        // String sql = "INSERT INTO usuario (username, firstname, lastname, email, phone, address, country, city, birthdate, role, created_at) VALUES ('" + username + "', '" + firstname + "', '" + lastname + "', '" + email + "', " + phone + ", '" + address + "', '" + country + "', '" + city + "', '" + birthdate + "', '" + role + "')";
        // statement.executeQuery(sql);
        //}catch (SQLException e){
        //   System.out.println(e.getErrorCode());
        //};

        //}
    }
}
