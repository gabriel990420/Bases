/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.sql.*;

/**
 *
 * @author dacastro
 */
public class ConnectBD {

    Connection conexion;
    Statement st;
    public static String User;
    public static String password;
    
     public ConnectBD() {
        //conexion
    }
     public Connection getConexion() {
        return conexion;
    }
     
    public Statement getStatement(){
        return st;
    }
    
    public static void setUser(String User){
        ConnectBD.User = User;
    }
     public static void setPassword(String password){
        ConnectBD.password = password;
    }
    public String getUser(){
        return User;
    }
    public String getPassword(){
        return password;
    }
    
      /**
     * Método utilizado para establecer la conexión con la base de datos
     * 
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
     */
    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/guarderia", User, password);
            st = conexion.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

   
}
