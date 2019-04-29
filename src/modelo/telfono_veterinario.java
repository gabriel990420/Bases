/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class telfono_veterinario {
    
    String numeroVeterinario;
    int idV;
        public telfono_veterinario() {
    }

    public telfono_veterinario(String numeroVeterinario, int idV) {
        this.numeroVeterinario = numeroVeterinario;
        this.idV = idV;
    }

    public String getNumeroVeterinario() {
        return numeroVeterinario;
    }

    public void setNumeroVeterinario(String numeroVeterinario) {
        this.numeroVeterinario = numeroVeterinario;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    @Override
    public String toString() {
        return "telfono_veterinario{" + "numeroVeterinario=" + numeroVeterinario + ", idV=" + idV + '}';
    }

    public boolean insertarTFV(String sql) {
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
