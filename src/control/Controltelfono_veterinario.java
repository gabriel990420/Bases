/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.telfono_veterinario;

/**
 *
 * @author david
 */
public class Controltelfono_veterinario {
    
    public static boolean insertTelVE(telfono_veterinario tv){
    String idD,numeroVeterinadio;
    boolean m;
    idD ="'"+ Integer.toString(tv.getIdV())+"'";
    numeroVeterinadio = "'"+tv.getNumeroVeterinario()+"'";
    
    String sql="INSERT into telfono_veterinario(numeroVeterinario, idV) values ("+numeroVeterinadio+","+idD+")";
    m= tv.insertarTFV(sql);
    return m;
    
    }
}
