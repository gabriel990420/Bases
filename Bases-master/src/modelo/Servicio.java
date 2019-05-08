/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Servicio {
    int codigoEntrenador,codigoEntrenamiento;

    public Servicio() {
    }

    public Servicio(int codigoEntrenador, int codigoEntrenamiento) {
        this.codigoEntrenador = codigoEntrenador;
        this.codigoEntrenamiento = codigoEntrenamiento;
    }

    public int getCodigoEntrenador() {
        return codigoEntrenador;
    }

    public void setCodigoEntrenador(int codigoEntrenador) {
        this.codigoEntrenador = codigoEntrenador;
    }

    public int getCodigoEntrenamiento() {
        return codigoEntrenamiento;
    }

    public void setCodigoEntrenamiento(int codigoEntrenamiento) {
        this.codigoEntrenamiento = codigoEntrenamiento;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codigoEntrenador=" + codigoEntrenador + ", codigoEntrenamiento=" + codigoEntrenamiento + '}';
    }



    public boolean insertarServicio(String sql, ConnectBD ConnectDB) {
                   
        boolean d = false;
        //suponemos que la conección ya ha sido creada
            try{
                Statement sentencia = ConnectDB.getConexion().createStatement();
                sentencia.executeUpdate(sql);
                d=true;
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        
        return d;
    }
    
    
}
