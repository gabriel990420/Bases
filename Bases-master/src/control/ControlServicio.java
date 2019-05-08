/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Servicio;

/**
 *
 * @author david
 */
public class ControlServicio {
    
   public static boolean insertarServicio(Servicio objS, ConnectBD ConnectDB){
       boolean m;
    String codigoEntrenador, codigoEntrenamiento;
    
    codigoEntrenador = "'"+Integer.toString(objS.getCodigoEntrenador())+"'";
    codigoEntrenamiento = "'"+Integer.toString(objS.getCodigoEntrenamiento())+"'";
    String sql= "INSERT into servicio(codigoEntrenador, codigoEntrenamiento) values("+codigoEntrenador+","+codigoEntrenamiento+")";
    m= objS.insertarServicio(sql,ConnectDB);
    return m;
    
    }
    
}
