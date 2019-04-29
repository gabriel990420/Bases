/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.ResultSet;
import modelo.Raza;

/**
 *
 * @author david
 */
public class ControlRaza {
    public static boolean insertarRaza(Raza objR){
        
        boolean d = false;
        String nombre_raza = "'"+objR.getNombre_raza()+"'";
        String sql = "INSERT into raza (nombre_raza) values("+nombre_raza+")";
        d = objR.insertarRaza(sql);
        return d;
    }
    
    public static Raza obtenerRaza(int idRaza){
        Raza objR = new Raza();
        
        String nombre;
        int idR;
        String sql = "select * from raza where idRaza = "+Integer.toString(idRaza);
        ResultSet rs = objR.obtenerRaza(sql);
        
        if(rs == null){
            
        }else{
            try{
            rs.next();
            idR = rs.getInt("idRaza");
            nombre = rs.getString("nombre_raza");
            objR = new Raza(nombre);
            objR.setIdR(idR);
            }catch(Exception e){
                System.out.println("Error: "+e.toString());
            }
        }
        return objR;
    }
    
    public static boolean actualizarRaza(Raza objR){
        boolean d;
        String idRaza, nombre_raza;
        idRaza = Integer.toString(objR.getIdR());
        nombre_raza = "'"+objR.getNombre_raza()+"'";
        
        String sql = "update raza set "
                + "nombre_raza = "+nombre_raza+"where idRaza = "+idRaza;
        
        d = objR.actualizarRaza(sql);
        return d;
    }
    
    public static boolean eliminarRaza(int id){
        boolean c;
        Raza r= new Raza();
        String sql = "DELETE FROM raza WHERE idRaza ="+ Integer.toString(id);
        c=r.eliminarRaza(sql);
        return c;
        
    }
    
}
