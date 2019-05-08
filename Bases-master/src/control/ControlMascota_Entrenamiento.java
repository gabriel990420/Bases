/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Mascota_Entrenamiento;

/**
 *
 * @author david
 */
public class ControlMascota_Entrenamiento {
    
//    public static boolean insertarMascota_Entrenamiento(Mascota_Entrenamiento objME, ConnectBD objCB){
//        boolean ME = false;
//        String idME, totalPagar, idMas, idEn;
//        String fecha_inscripcion;
//        
//        totalPagar = Integer.toString(objME.getIdME());
//        fecha_inscripcion = "'"+objME.getFecha_inscripcion()+"'";
//        idMas = Integer.toString(objME.getIdMas());
//        idEn = Integer.toString(objME.getIdEn());
//        
//        String sql = "insert into mascota_entrenamiento(totalPagar, fecha_inscripcion, idMas, idEn) values("+totalPagar+","+
//                fecha_inscripcion+","+idMas+","+idEn+")";
//        ME=objME.insertarMascota_Entrenamiento(sql, objCB);
//        return ME;
//    }
   public static boolean insertarMarcota_Entrenamiento(Mascota_Entrenamiento objME, ConnectBD objCB){
       boolean me;
       String sql = "INSERT INTO mascota_entrenamiento(totalPagar, fecha_inscripcion, idMas, idEn)" + "values(?,?,?,?)";
       me = objME.insertarMascota_Entrenamiento(sql); 
       return me;
   }
   public static Mascota_Entrenamiento obtenerME(int idME){
       Mascota_Entrenamiento objME = new Mascota_Entrenamiento();
       
       int totalPagar;
       String fecha_inscripcion;
       int idMas;
       int idEn;
       
       String sql = "SELECT * FROM mascota_entrenamiento WHERE idME=" + Integer.toString(idME);
       ResultSet rs = objME.obtenerMascota_Entrenamiento(sql);
       
       if(rs==null){
           objME=null;
       }else{
           try{
               rs.next();
               totalPagar = rs.getInt("totalPagar");
               fecha_inscripcion = rs.getString("fecha_inscripcion");
               idMas = rs.getInt("idMas");
               idEn = rs.getInt("idEn");
               
               objME = new Mascota_Entrenamiento( totalPagar, idMas, idEn, fecha_inscripcion);
               objME.setIdME(idME);
           }catch(Exception e){
               System.out.println("Error"+ e.toString());
           }
       }
       return objME;
   }
}
