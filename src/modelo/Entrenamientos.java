/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Entrenamientos {

    int identrenamientos;
    String nombre;
    int valor;
    int duracion;

    public Entrenamientos() {
    }

    public Entrenamientos(int identrenamientos, String nombre, int valor, int duracion) {
        this.identrenamientos = identrenamientos;
        this.nombre = nombre;
        this.valor = valor;
        this.duracion = duracion;
        
    }

    public Entrenamientos(String nombre, int valor, int duracion) {
        this.nombre = nombre;
        this.valor = valor;
        this.duracion = duracion;
    }

    public int getIdentrenamientos() {
        return identrenamientos;
    }

    public void setIdentrenamientos(int identrenamientos) {
        this.identrenamientos = identrenamientos;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Entrenamientos{" + "nombre=" + nombre + ", valor=" + valor + ", duracion=" + duracion + '}';
    }

    public boolean insertarEntrenamientos(String sql) {

        boolean d = false;

        try {
            ConnectBD objCB = new ConnectBD();

            if (objCB.crearConexion()) {
                Statement sentencia = objCB.getConexion().createStatement();
                sentencia.executeUpdate(sql);
                d = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }

        return d;
    }

    public ResultSet obtenerEntrenamiento(String sql) {
        ResultSet rs = null;

        try {
            ConnectBD objCB = new ConnectBD();

            if (objCB.crearConexion()) {
                rs = objCB.getStatement().executeQuery(sql);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }

    public boolean EliminarEntrenamiento(String sql) {
        boolean d = false;
        try {
            ConnectBD objCB = new ConnectBD();
            if (objCB.crearConexion()) {
                objCB.getStatement().executeUpdate(sql);
            }
            d = true;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return d;
    }
    
    public boolean actualizarEntrenamiento(String sql){
        boolean d = false;
        try {
            ConnectBD objCB = new ConnectBD();
            if (objCB.crearConexion()) {
                objCB.getStatement().executeUpdate(sql);
            }
            d = true;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return d;
    }

}
