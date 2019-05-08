/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Raza {

    private int idR;
    private String nombre_raza;

    public Raza() {
    }

    public Raza(String nombre_raza) {
        this.nombre_raza = nombre_raza;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNombre_raza() {
        return nombre_raza;
    }

    public void setNombre_raza(String nombre_raza) {
        this.nombre_raza = nombre_raza;
    }

    public boolean insertarRaza(String sql) {
        boolean d = false;
        try {
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
                objCB.getStatement().executeUpdate(sql);
            }

            d = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }

    public ResultSet obtenerRaza(String sql) {
        
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

    public boolean eliminarRaza(String sql) {
        boolean r = false;
        try {
            ConnectBD objCB = new ConnectBD();
            if (objCB.crearConexion()) {
                objCB.getStatement().executeUpdate(sql);
            }
            r = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return r;
    }

    public boolean actualizarRaza(String sql) {
        boolean r = false;
        try {
            ConnectBD connectdb = new ConnectBD();
            if (connectdb.crearConexion()) {
                connectdb.getStatement().executeUpdate(sql);

            }
            r = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());

        }

        return r;
    }

}
