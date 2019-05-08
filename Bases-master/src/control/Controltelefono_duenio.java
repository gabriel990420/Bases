/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.telefono_duenio;

/**
 *
 * @author david
 */
public class Controltelefono_duenio {
    
    public static boolean insertarTele_Duenio(telefono_duenio tfd){
    String idD,numeroDuenio;
    boolean m;
    idD ="'"+ Integer.toString(tfd.getIdD())+"'";
    numeroDuenio = "'"+tfd.getNumeroDuenio()+"'";
    
    String sql="INSERT into telefono_duenio(numeroDuenio, idD) values ("+numeroDuenio+","+idD+")";
    m= tfd.insertarTelefono_Duenio(sql);
    return m;
    
    
    }

    public static boolean eliminarTele_Duenio(int id) {
               boolean te;
        telefono_duenio objTD = new telefono_duenio();
        
        String sql = "DELETE FROM telefono_duenio WHERE idTel ="+ Integer.toString(id);
        te=objTD.eliminarTD(sql);
        
        return te;
    }
    
}
