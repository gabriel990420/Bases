/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class telefono_entrenador {
   int idTE;
   String numero;
   int idE;

    public telefono_entrenador() {
    }

    public telefono_entrenador(String numero, int idE) {
        this.numero = numero;
        this.idE = idE;
    }

    public telefono_entrenador(int idTE, String numero, int idE) {
        this.idTE = idTE;
        this.numero = numero;
        this.idE = idE;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public int getIdTE() {
        return idTE;
    }

    public void setIdTE(int idTE) {
        this.idTE = idTE;
    }

    @Override
    public String toString() {
        return "telefono_entrenador{" + "idTE=" + idTE + ", numero=" + numero + ", idE=" + idE + '}';
    }

    public boolean insertarTelefono_Entrenador(String sql) {
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

    public ResultSet obtenerTE(String sql) {
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

    public boolean eliminarTE(String sql) {
        boolean te = false;
        
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);
            }
            te = true;
        }catch(Exception e){
            System.out.println("Error: " +e.toString());
        }
        return te;
    }
   
   
    
}
