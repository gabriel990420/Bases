/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.telefono_entrenador;

/**
 *
 * @author david
 */
public class Controltelefono_entrenador {
    
//    public static boolean insertarTE(telefono_entrenador te, ConnectBD objBD){ 
//        boolean m;
//    String idE, numero;
//    idE= "'"+Integer.toString(te.getIdE())+"'";
//    numero= "'"+te.getNumero()+"'";
//    
//    String sql="INSERT into telefono_entrenador( numero, idE) values ("+ numero+","+ idE+")";
//    
//    m =te.insertarTF(sql, objBD);
//    return m;
//    
//    
//    }
    public static boolean insertarTE(telefono_entrenador objTE){
String idE,numeroEntrenador;
    boolean m;
    idE ="'"+ Integer.toString(objTE.getIdE())+"'";
    numeroEntrenador = "'"+objTE.getNumero()+"'";
    
    String sql="INSERT into telefono_entrenador(numero, idE) values ("+numeroEntrenador+","+idE+")";
    m= objTE.insertarTelefono_Entrenador(sql);
    return m; 
    }
    
    public static telefono_entrenador obtenerTE(int idTE){
        telefono_entrenador objTE = new telefono_entrenador();
        
        String numero;
        int idE;
        
        String sql = "SELECT * FROM telefono_entrenador WHERE idTE=" + Integer.toString(idTE);
        ResultSet rs = objTE.obtenerTE(sql);
        
        if(rs==null){
            objTE=null;
        }else{
            try{
                rs.next();
                numero = rs.getString("numero");
                idE = rs.getInt("idE");
                
                objTE =new telefono_entrenador(numero, idE);
                objTE.setIdTE(idTE);                
            }catch(Exception e){
                System.out.println("Error"+ e.toString());
            }
        }
        return objTE;
    }    
    
    public static boolean eliminarTE(int idTE){
        boolean te;
        telefono_entrenador objTE = new telefono_entrenador();
        
        String sql = "DELETE FROM telefono_entrenador WHERE idTel ="+ Integer.toString(idTE);
        te=objTE.eliminarTE(sql);
        
        return te;
    }
}
