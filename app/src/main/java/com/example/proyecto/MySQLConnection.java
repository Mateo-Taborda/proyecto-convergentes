package com.example.proyecto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            String url = "jdbc:mysql://localhost:3306/convergentes";
            String usuario = "root";
            String contraseña = "";
            connection = DriverManager.getConnection(url, usuario, contraseña);

        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
