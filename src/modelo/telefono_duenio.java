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
public class telefono_duenio {
    String numeroDuenio;
    int idD;

    public telefono_duenio() {
    }

    public telefono_duenio(String numeroDuenio, int idD) {
        this.numeroDuenio = numeroDuenio;
        this.idD = idD;
    }

    public String getNumeroDuenio() {
        return numeroDuenio;
    }

    public void setNumeroDuenio(String numeroDuenio) {
        this.numeroDuenio = numeroDuenio;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    @Override
    public String toString() {
        return "telefono_duenio{" + "numeroDuenio=" + numeroDuenio + ", idD=" + idD + '}';
    }

    public boolean insertarTelefono_Duenio(String sql) {
        boolean d = false;
        ConnectBD objCB = new ConnectBD();

        try {
            if (objCB.crearConexion()) {
                Statement sentencia = objCB.getConexion().createStatement();
                sentencia.executeUpdate(sql);
            }
            d = true;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return d;
    }
    
    
    
}
